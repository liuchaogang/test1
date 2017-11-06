package com.yonyou.writer;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.*;

import com.yonyou.hl7adapter.model.PatientMinimal;

import com.yonyou.hl7adapter.model.ST203.ST203;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.PatientService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

 
import java.util.Date;
import java.util.List;

/**
 * @author
 * @ClassName: ST203Writer
 * @Description: ST203住院就诊入院登记
 * @date 2017/6/30 10:39
 */
@Component(value = "ST203")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST203Writer implements BaseProcessWriter<ST203> {

    private static Logger st203Logger = LoggerFactory.getLogger("ST203Logger");

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientVisitService patientVisitService;

    @Autowired
    private MipMsgLogService msgLogService;

    private String orgCode;

    private String groupCode;

    private String pkPati;

    private Date currentTime;

    private String empiId;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;

    @Override
    public boolean validation(ST203 st203, Object reMsg) {

        msgId = st203.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st203Logger.error("ST103,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);

        if (StringUtils.isEmpty(st203.getPidCode())
                || StringUtils.isEmpty(st203.getPatientTypeCode())
                || StringUtils.isEmpty(st203.getVisitNo())) {

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
                    "非空项为空，patiCode:[" + st203.getPidCode() + "],pvCode:["
                            + st203.getVisitNo() + "],visitTypeCode:[" + st203.getPatientTypeCode() + "]", MessageStatus.NULL_FIELD));

            st203Logger
                    .error("ST203-[{}],非空项为空，patiCode:[{}],pvCode:[{}],visitTypeCode:[{}]",
                            st203.getMsgId(), st203.getPidCode(),
                            st203.getVisitNo(), st203.getPatientTypeCode());

            return false;
        }

        currentTime = new Date();

        orgCode = Constant.getOrgCode();
        groupCode = Constant.getGroupCode();

        if (StringUtils.isEmpty(st203.getGroupCode()))
            st203.setGroupCode(groupCode);
        if (StringUtils.isEmpty(st203.getOrgCode()))
            st203.setOrgCode(orgCode);

        return true;
    }

    @Override
    public boolean checkPre(ST203 st203) {

        // 查找患者基本信息是否存在
        // 不存在，直接从本消息中取出简单的患者信息，插入临时信息，在新建或更新主索引消息中再进行更新
        UhDcPi uhDcPiDB = patientService.getUhDcPiByCrossIndex(
                st203.getPidCode(), st203.getPatientTypeCode(),
                st203.getGroupCode(), st203.getOrgCode());
        if (uhDcPiDB == null) {
            empiId = "T_" + st203.getPidCode() + "_"
                    + st203.getPatientTypeCode();

            PatientMinimal patient = new PatientMinimal();

            
            patient.setPatientId(st203.getPidCode());
            patient.setOupatientNo(st203.getOutpatientNo());
            patient.setInpatientNo(st203.getInpatientNo());
            patient.setPatientName(st203.getPatientName());
            patient.setGenderCode(st203.getPatientSexCode());
            patient.setGenderName(st203.getPatientSexName());
            patient.setBirthDate(DateUtils.getDateStr2Str(st203.getPatientBirthTime()));
            patient.setAge(st203.getPatientAge());
            patient.setOrgCode(st203.getOrgCode());
            patient.setOrgName(st203.getOrgName());
            patient.setGroupCode(st203.getGroupCode());
            patient.setGroupName(st203.getGroupName());

            // 交叉索引
            patientService.saveUhPiCrossIndex(PatientConvertor.getPiCrossIndex(
                    patient, st203.getPatientTypeCode(), empiId, currentTime));
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
    public void businessWrite(ST203 st203) {

        if (Constant.getMsgActionAdd().equals(st203.getServiceType())) {
            // 新增
            //1、根據聯合主鍵查詢就診記錄是否存在（患者id+就診流水號+就診類型）
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st203.getPidCode(),
                    st203.getVisitNo(), st203.getVisitTimes(),
                    st203.getPatientTypeCode(), st203.getGroupCode(),
                    st203.getOrgCode());

            //2、消息中的就診信息轉換為數據庫實體對象
            //3、保存數據庫實體對象
            UhDcPv uhdcpv = VisitConvertor.getUhDcPv(st203, empiId,
                    pkPati, currentTime, uhDcPvDB);

            UhDcPvInp inp = VisitConvertor
                    .getUhDcPvInp(st203, empiId, pkPati, currentTime,
                            uhDcPvDB);
            List<UhDcPvDiag> diags = VisitConvertor.getUhDcPvDiag(st203, empiId,
                    pkPati, currentTime, uhDcPvDB);


            UhDcPv uhDcPvForSave = patientVisitService.saveOrUpdateInpInformation(uhdcpv, inp, diags);

			 

            tables += "UhDcPv;UhDcPvInp;UhDcPvDiag";
            
            if(ObjectUtils.isNotEmpty(uhDcPvForSave)){
            	
              msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvForSave.getPkDcpv(), MessageStatus.OK));

            }

        }else if(Constant.getMsgActionUpdate().equals(st203.getServiceType())){
        	  //查询要更新的就诊信息
        	 UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st203.getPidCode(),
                     st203.getVisitNo(), st203.getVisitTimes(),
                     st203.getPatientTypeCode(), st203.getGroupCode(),
                     st203.getOrgCode());
        	 
        	   if (ObjectUtils.isEmpty(uhDcPvDB)) {

                   msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pvCode：" + st203.getVisitNo(), MessageStatus.DEPEND_NOT_EXIST));
                   st203Logger.info("当前要更新就诊记录不存在，codePati:{},pvCode:{},pvTimes:{},codePvType:{}",
                           st203.getPidCode(), st203.getVisitNo(), st203.getVisitTimes(), st203.getPatientTypeCode());
               }else{
            	   
            	    UhDcPv uhdcpv = VisitConvertor.getUhDcPv(st203, empiId,
                            pkPati, currentTime, uhDcPvDB);

                    UhDcPvInp inp = VisitConvertor
                            .getUhDcPvInp(st203, empiId, pkPati, currentTime,
                                    uhDcPvDB);
                    List<UhDcPvDiag> diags = VisitConvertor.getUhDcPvDiag(st203, empiId,
                            pkPati, currentTime, uhDcPvDB);

                    UhDcPv uhDcPvForSave = patientVisitService.saveOrUpdateInpInformation(uhdcpv, inp, diags);

                    tables += "UhDcPv;UhDcPvInp;UhDcPvDiag";
                    
                    if(ObjectUtils.isNotEmpty(uhDcPvForSave)){
                    	
                      msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvForSave.getPkDcpv(), MessageStatus.OK));

                    }

            	   
               }
      	
        }else if(Constant.getMsgActionCancel().equals(st203.getServiceType())){
        	  //查询要取消的就诊信息
       	 UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(st203.getPidCode(),
                    st203.getVisitNo(), st203.getVisitTimes(),
                    st203.getPatientTypeCode(), st203.getGroupCode(),
                    st203.getOrgCode());
       	 
       	   if (ObjectUtils.isEmpty(uhDcPvDB)) {

                  msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pvCode：" + st203.getVisitNo(), MessageStatus.DEPEND_NOT_EXIST));
                  st203Logger.info("当前要取消就诊记录不存在，codePati:{},pvCode:{},pvTimes:{},codePvType:{}",
                          st203.getPidCode(), st203.getVisitNo(), st203.getVisitTimes(), st203.getPatientTypeCode());
              }else{
            	  
            	  patientVisitService.CancelUhDcPv(uhDcPvDB, st203.getRegistrationTime(), st203.getRegistrantCode(), st203.getRegistrantName());

                  tables += "UhDcPv";

                  mipMsgLog.setBusinessTables(tables);
                  msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + pkPati + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));
            	  
              }
        	
        }
        else {
        	 
        	st203Logger.debug("ST203没有该交互类型，msgID:" + msgId);
        	mipMsgLog.setBusinessTables(tables);
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NOT_SUPPORT_ACTION));
        }

    }

}
