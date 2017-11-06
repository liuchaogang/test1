package com.yonyou.writer;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcTransDept;
import com.yonyou.hl7adapter.model.PatientMinimal;
import com.yonyou.hl7adapter.model.ST204.ST204;
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
@Component(value = "ST204")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST204Writer implements BaseProcessWriter<ST204> {

    private static Logger st204Logger = LoggerFactory.getLogger("ST204Logger");

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
    public boolean validation(ST204 st204, Object reMsg) {

        msgId = st204.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st204Logger.error("ST204,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);


        if (StringUtils.isEmpty(st204.getPidCode())
                || StringUtils.isEmpty(st204.getPatientTypeCode())
                || StringUtils.isEmpty(st204.getVisitNo())) {

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
                    "非空项为空，patiCode:[" + st204.getPidCode() + "],pvCode:["
                            + st204.getVisitNo() + "],visitTypeCode:[" + st204.getPatientTypeCode() + "]", MessageStatus.NULL_FIELD));
            st204Logger
                    .error("ST203-[{}],非空项为空，patiCode:[{}],pvCode:[{}],visitTypeCode:[{}]",
                            st204.getMsgId(), st204.getPidCode(),
                            st204.getVisitNo(), st204.getPatientTypeCode());

            return false;
        }

        currentTime = new Date();

        orgCode = Constant.getOrgCode();
        groupCode = Constant.getGroupCode();

        if (StringUtils.isEmpty(st204.getGroupCode()))
            st204.setGroupCode(groupCode);
        if (StringUtils.isEmpty(st204.getOrgCode()))
            st204.setOrgCode(orgCode);

        return true;
    }

    @Override
    public boolean checkPre(ST204 st204) {

        // 查找患者基本信息是否存在
        // 不存在，直接从本消息中取出简单的患者信息，插入临时信息，在新建或更新主索引消息中再进行更新
        UhDcPi uhDcPiDB = patientService.getUhDcPiByCrossIndex(
                st204.getPidCode(), st204.getPatientTypeCode(),
                st204.getGroupCode(), st204.getOrgCode());
        if (uhDcPiDB == null) {
            empiId = "T_" + st204.getPidCode() + "_"
                    + st204.getPatientTypeCode();

            PatientMinimal patient = new PatientMinimal();

            patient.setEmpiId(st204.getEMPINo());
            patient.setPatientId(st204.getPidCode());
            patient.setOupatientNo(st204.getOutpatientNo());
            patient.setInpatientNo(st204.getInpatientNo());
            patient.setPatientName(st204.getPatientName());
            patient.setGenderCode(st204.getPatientSexCode());
            patient.setGenderName(st204.getPatientSexName());
            patient.setBirthDate(st204.getPatientBirthTime());
            patient.setAge(st204.getPatientAge());
            patient.setOrgCode(st204.getOrgCode());
            patient.setOrgName(st204.getOrgName());
            patient.setGroupCode(st204.getGroupCode());
            patient.setGroupName(st204.getGroupName());

            // 交叉索引
            patientService.saveUhPiCrossIndex(PatientConvertor.getPiCrossIndex(
                    patient, st204.getPatientTypeCode(), empiId, currentTime));
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
    public void businessWrite(ST204 st204) {


        if (Constant.getMsgActionAdd().equals(st204.getServiceType())) {
            // 新增入科
            //1、根據聯合主鍵查詢就診記錄是否存在（患者id+就診流水號+就診類型）
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st204.getPidCode(),
                    st204.getVisitNo(), st204.getVisitTimes(),
                    st204.getPatientTypeCode(), st204.getGroupCode(),
                    st204.getOrgCode());

            //2、消息中的就診信息轉換為數據庫實體對象
            //3、保存數據庫實體對象
            if (uhDcPvDB != null) {
                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST204(st204, uhDcPvDB, "deptIn");

                patientVisitService.saveOrUpdateTransDept(transdept);

                tables += "UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            } else {
                UhDcPv uhdcpv = VisitConvertor.getUhDcPv(st204, empiId,
                        pkPati, currentTime, uhDcPvDB);

                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST204(st204, uhDcPvDB, "deptIn");

                patientVisitService.saveOrUpdateDcPvAndTransDept(uhdcpv, transdept);

                tables += "UhDcPv;UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            }

        } else if (Constant.getMsgActionCancel().equals(st204.getServiceType())) {
            //取消入科
            //1、根據聯合主鍵查詢就診記錄是否存在（患者id+就診流水號+就診類型）
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st204.getPidCode(),
                    st204.getVisitNo(), st204.getVisitTimes(),
                    st204.getPatientTypeCode(), st204.getGroupCode(),
                    st204.getOrgCode());

            //2、消息中的就診信息轉換為數據庫實體對象
            //3、保存數據庫實體對象
            if (uhDcPvDB != null) {
                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST204(st204, uhDcPvDB, "cancelDeptIn");

                patientVisitService.saveOrUpdateTransDept(transdept);

                tables += "UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            } else {
                UhDcPv uhdcpv = VisitConvertor.getUhDcPv(st204, empiId,
                        pkPati, currentTime, uhDcPvDB);

                UhDcTransDept transdept = UhDcTransDeptConvertor
                        .getUhDcTransDeptForST204(st204, uhDcPvDB, "cancelDeptIn");

                patientVisitService.saveOrUpdateDcPvAndTransDept(uhdcpv, transdept);

                tables += "UhDcPv;UhDcTransDept";
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            }
        } else {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NOT_SUPPORT_ACTION));
            st204Logger.error("不支持的类型");
        }

    }


}
