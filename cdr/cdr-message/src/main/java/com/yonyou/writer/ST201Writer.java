package com.yonyou.writer;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST201.ST201;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.PatientService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.Constant;
import com.yonyou.util.ObjectUtils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenpana@yonyou.com
 * @ClassName: ST201Writer
 * @Description: ST201门诊就诊登记
 * @date 2017/6/30 10:39
 */
@Component(value = "ST201")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST201Writer implements BaseProcessWriter<ST201> {

    private static Logger st201Logger = LoggerFactory.getLogger("ST201Logger");

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientVisitService patientVisitService;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;


    private String orgCode;

    private String groupCode;

    private String pkPati;

    private Date currentTime;

    private String empiId;

    private String msgId;

    private String tables;

    @Override
    public boolean validation(ST201 st201, Object reMsg) {

        msgId = st201.getMsgId();
        if (StringUtils.isEmpty(msgId)) {
            st201Logger.error("ST201-{},msgId为空");
            return false;
        }
        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
        
        if (ObjectUtils.isEmpty(st201.getPatient())) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));
            st201Logger.error("ST201-{},患者信息获取失败，请检查xml格式", st201.getMsgId());
            return false;
        }

        if (StringUtils.isEmpty(st201.getPatient().getPatientId())
                || StringUtils.isEmpty(st201.getVisitTypeCode())
                || StringUtils.isEmpty(st201.getVisitId())) {

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
                    "patiCode:[" + st201.getPatient().getPatientId() + "],pvCode:[" +
                            st201.getVisitId() + "],visitTypeCode:[" + st201.getVisitTypeCode() + "]", MessageStatus.NULL_FIELD));

            st201Logger.error("ST201-[{}],非空项为空，patiCode:[{}],pvCode:[{}],visitTypeCode:[{}]",
                    msgId,
                    st201.getPatient().getPatientId(),
                    st201.getVisitId(),
                    st201.getVisitTypeCode());

            return false;
        }

        currentTime = new Date();

        orgCode = Constant.getOrgCode();
        groupCode = Constant.getGroupCode();

        if (StringUtils.isEmpty(st201.getPatient().getGroupCode()))
            st201.getPatient().setGroupCode(groupCode);
        if (StringUtils.isEmpty(st201.getPatient().getOrgCode()))
            st201.getPatient().setOrgCode(orgCode);

        return true;
    }

    @Override
    public boolean checkPre(ST201 st201) {

        //查找患者基本信息是否存在
        //不存在，直接从本消息中取出简单的患者信息，插入临时信息，在新建或更新主索引消息中再进行更新
        UhDcPi uhDcPiDB = patientService.getUhDcPiByCrossIndex(st201.getPatient().getPatientId(),
                st201.getVisitTypeCode(),
                st201.getPatient().getGroupCode(),
                st201.getPatient().getOrgCode());
        if (ObjectUtils.isEmpty(uhDcPiDB)) {
            empiId = "T_" + st201.getPatient().getPatientId() + "_" + st201.getVisitTypeCode();

            //交叉索引
             patientService.saveUhPiCrossIndex(PatientConvertor.getPiCrossIndex(st201.getPatient(),
                    st201.getVisitTypeCode(),
                    empiId, currentTime));
            //基本信息
            UhDcPi uhDcPi = patientService.savePatientInfo(PatientConvertor.getMiniPi(st201.getPatient(), empiId, currentTime));
     
            pkPati = uhDcPi.getPkPati();

            tables = "UhDcPiCrossIndex;UhDcPi;";
        } else {
            pkPati = uhDcPiDB.getPkPati();
            empiId = uhDcPiDB.getEmpi();
        }
        return true;
    }

    @Override
    public void businessWrite(ST201 st201) {

        if (Constant.getMsgActionAdd().equals(st201.getEventFlag())) {
            //挂号
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st201.getPatient().getPatientId(),
                    st201.getVisitId(), st201.getVisitTimes(), st201.getVisitTypeCode(),
                    st201.getPatient().getGroupCode(), st201.getPatient().getOrgCode());

            UhDcPv uhDcPv = patientVisitService.saveOrUpdate(VisitConvertor.getUhDcPv(st201, empiId, pkPati, currentTime, uhDcPvDB),
                    VisitConvertor.getUhDcPvOutp(st201, empiId, pkPati, currentTime, uhDcPvDB));

            tables += "UhDcPv;UhDcPvOutp";

            mipMsgLog.setBusinessTables(tables);
            
            if(ObjectUtils.isNotEmpty(uhDcPv)){
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));

            }
            
        } else if (Constant.getMsgActionCancel().equals(st201.getEventFlag())) {
            //退号
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st201.getPatient().getPatientId(),
                    st201.getVisitId(), st201.getVisitTimes(), st201.getVisitTypeCode(),
                    st201.getPatient().getGroupCode(), st201.getPatient().getOrgCode());
            if (ObjectUtils.isEmpty(uhDcPvDB)) {

                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.DEPEND_NOT_EXIST));
                st201Logger.info("当前要退的就诊记录不存在，codePati:{},pvCode:{},pvTimes:{},codePvType:{}",
                        st201.getPatient().getPatientId(), st201.getVisitId(), st201.getVisitTimes(), st201.getVisitTypeCode());
            } else {
                //退号，更新退诊标识
                //patientVisitService.CancelUhDcPv(uhDcPvDB.getPkDcpv(),st201.getRegisterTime(),st201.getRegistrantCode(),st201.getRegistrantName(),groupCode,orgCode);
                patientVisitService.CancelUhDcPv(uhDcPvDB, st201.getRegisterTime(), st201.getRegistrantCode(), st201.getRegistrantName());

                tables += "UhDcPv";

                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            }
        }


    }
}
