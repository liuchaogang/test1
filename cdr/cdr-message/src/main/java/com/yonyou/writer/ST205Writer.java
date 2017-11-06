package com.yonyou.writer;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcTransDept;
import com.yonyou.hl7adapter.model.PatientMinimal;
import com.yonyou.hl7adapter.model.ST205.ST205;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.PatientService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.Constant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author
 * @ClassName:
 * @Description:
 * @date
 */
@Component(value = "ST205")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST205Writer implements BaseProcessWriter<ST205> {

    private static Logger st205Logger = LoggerFactory.getLogger("ST205Logger");

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientVisitService patientVisitService;

    private String orgCode;

    private String groupCode;

    private String pkPati;

    private Date currentTime;

    private String empiId;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;

    @Override
    public boolean validation(ST205 st205, Object reMsg) {

        msgId = st205.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st205Logger.error("st205,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);

        if (StringUtils.isEmpty(st205.getPidCode())
                || StringUtils.isEmpty(st205.getPatientTypeCode())
                || StringUtils.isEmpty(st205.getVisitNo())) {

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
                    "非空项为空，patiCode:[" + st205.getPidCode() + "],pvCode:["
                            + st205.getVisitNo() + "],visitTypeCode:[" + st205.getPatientTypeCode() + "]", MessageStatus.NULL_FIELD));
            st205Logger
                    .error("ST205-[{}],非空项为空，patiCode:[{}],pvCode:[{}],visitTypeCode:[{}]",
                            st205.getMsgId(), st205.getPidCode(),
                            st205.getVisitNo(), st205.getPatientTypeCode());

            return false;
        }

        currentTime = new Date();

        orgCode = Constant.getOrgCode();
        groupCode = Constant.getGroupCode();

        if (StringUtils.isEmpty(st205.getGroupCode()))
            st205.setGroupCode(groupCode);
        if (StringUtils.isEmpty(st205.getOrgCode()))
            st205.setOrgCode(orgCode);

        return true;
    }

    @Override
    public boolean checkPre(ST205 st205) {

        // 查找患者基本信息是否存在
        // 不存在，直接从本消息中取出简单的患者信息，插入临时信息，在新建或更新主索引消息中再进行更新
        UhDcPi uhDcPiDB = patientService.getUhDcPiByCrossIndex(
                st205.getPidCode(), st205.getPatientTypeCode(),
                st205.getGroupCode(), st205.getOrgCode());
        if (uhDcPiDB == null) {
            empiId = "T_" + st205.getPidCode() + "_"
                    + st205.getPatientTypeCode();

            PatientMinimal patient = new PatientMinimal();

            patient.setEmpiId(st205.getEMPINo());
            patient.setPatientId(st205.getPidCode());
            patient.setOupatientNo(st205.getOutpatientNo());
            patient.setInpatientNo(st205.getInpatientNo());
            patient.setPatientName(st205.getPatientName());
            patient.setGenderCode(st205.getPatientSexCode());
            patient.setGenderName(st205.getPatientSexName());
            patient.setBirthDate(st205.getPatientBirthTime());
            patient.setAge(st205.getPatientAge());
            patient.setOrgCode(st205.getOrgCode());
            patient.setOrgName(st205.getOrgName());
            patient.setGroupCode(st205.getGroupCode());
            patient.setGroupName(st205.getGroupName());

            // 交叉索引
            patientService.saveUhPiCrossIndex(PatientConvertor.getPiCrossIndex(
                    patient, st205.getPatientTypeCode(), empiId, currentTime));
            // 基本信息
            UhDcPi uhDcPi = patientService.savePatientInfo(PatientConvertor
                    .getMiniPi(patient, empiId, currentTime));

            pkPati = uhDcPi.getPkPati();

            tables = "UhDcPiCrossIndex;UhDcPi;";

        } else {
            pkPati = uhDcPiDB.getPkPati();
            empiId = uhDcPiDB.getEmpi();
        }
        return true;
    }

    @Override
    public void businessWrite(ST205 st205) {

        if (Constant.getMsgActionAdd().equals(st205.getServiceType())) {
            // 新增
            //1、根據聯合主鍵查詢就診記錄是否存在（患者id+就診流水號+就診類型）
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st205.getPidCode(),
                    st205.getVisitNo(), st205.getVisitTimes(),
                    st205.getPatientTypeCode(), st205.getGroupCode(),
                    st205.getOrgCode());

            //2、消息中的就診信息轉換為數據庫實體對象
            //3、保存數據庫實體對象
            if (uhDcPvDB != null) {
                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST205(st205, uhDcPvDB, "deptOut");

                patientVisitService.saveOrUpdateTransDept(transdept);

                tables += "UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            } else {
                UhDcPv uhdcpv = VisitConvertor.getUhDcPv(st205, empiId,
                        pkPati, currentTime, uhDcPvDB);

                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST205(st205, uhDcPvDB, "deptOut");

                patientVisitService.saveOrUpdateDcPvAndTransDept(uhdcpv, transdept);

                tables += "uhdcpv;UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            }

        } else if (Constant.getMsgActionCancel().equals(st205.getServiceType())) {
            //1、根據聯合主鍵查詢就診記錄是否存在（患者id+就診流水號+就診類型）
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st205.getPidCode(),
                    st205.getVisitNo(), st205.getVisitTimes(),
                    st205.getPatientTypeCode(), st205.getGroupCode(),
                    st205.getOrgCode());

            //2、消息中的就診信息轉換為數據庫實體對象
            //3、保存數據庫實體對象
            if (uhDcPvDB != null) {
                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST205(st205, uhDcPvDB, "cancelDeptOut");

                patientVisitService.saveOrUpdateTransDept(transdept);


                tables += "UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            } else {
                UhDcPv uhdcpv = VisitConvertor.getUhDcPv(st205, empiId,
                        pkPati, currentTime, uhDcPvDB);

                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST205(st205, uhDcPvDB, "cancelDeptOut");

                patientVisitService.saveOrUpdateDcPvAndTransDept(uhdcpv, transdept);


                tables += "uhdcpv;UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            }
        } else {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NOT_SUPPORT_ACTION));
            st205Logger.error("不支持的类型");
        }

    }

}
