package com.yonyou.writer;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.*;
import com.yonyou.hl7adapter.model.ST301.ChineseMedicine;
import com.yonyou.hl7adapter.model.ST301.ChineseMedicineSub;
import com.yonyou.hl7adapter.model.ST301.Prescription;
import com.yonyou.hl7adapter.model.ST301.ST301;
import com.yonyou.hl7adapter.model.ST301.WesternMedicine;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.*;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *
 */
@Component(value = "ST301")
public class ST301Writer implements BaseProcessWriter<ST301> {

    private static Logger st301Logger = LoggerFactory.getLogger("ST301Logger");

    @Autowired
    private OrderService orderService;
    @Autowired
    private UhDcOrdMediService uhDcOrdMediService;
    @Autowired
    private UhDcPvDiagService uhDcPvDiagService;
    @Autowired
    private UhDcPvPresService uhDcPvPresService;
    @Autowired
    private PatientVisitService patientVisitService;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;

    @Override
    public boolean validation(ST301 st301, Object reMsg) {
    	
        msgId = st301.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st301Logger.error("st301,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
        
        if (ObjectUtils.isEmpty(st301.getPvInfo())||ObjectUtils.isEmpty(st301.getDiagnosis())||st301.getPrescription().size()==0 ) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));
             st301Logger.error("ST301-{},患者信息获取失败，请检查xml格式", st301.getMsgId());
            return false;
        }
        
        return true;
    }

    @Override
    public boolean checkPre(ST301 st301) {
        return true;
    }

    @Override
    @Transactional
    public void businessWrite(ST301 st301) {
    	
        UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(st301.getPvInfo().getPvId());
        if (ObjectUtils.isEmpty(uhDcPv)) {
            st301Logger.info("st301没有找到就诊记录：就诊号pvcode:" + st301.getPvInfo().getPvId());
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此就诊信息", MessageStatus.DEPEND_NOT_EXIST));

            return;
        }
        
        st301.getPvInfo().getPatient().setEmpiId(uhDcPv.getEmpi());
        
    	//更新和取消
        if ("U".equals(st301.getActionType()) || "D".equals(st301.getActionType())) {
            List<Prescription> lstPrescription = st301.getPrescription();
            List<String> presIds = new ArrayList<String>();
            for (Prescription pres : lstPrescription) {
                presIds.add(pres.getId());
            }
            if (presIds.size() > 0) {
//    			List<UhDcPvDiag> lstUhDcPvDiag = uhDcPvDiagService.getUhDcPvDiagListByPvcode(st301.getPvInfo().getPvId());
                List<UhDcPvPres> lstUhDcPvPres = uhDcPvPresService.getUhDcPvPresListByPresNos(presIds);
                List<UhDcOrd> lstUhDcOrd = orderService.getUhDcOrdListByPresNos(presIds);
                List<String> uhDcOrdPks = new ArrayList<String>();
                for (UhDcOrd uhDcOrd : lstUhDcOrd) {
                    uhDcOrdPks.add(uhDcOrd.getPkDcord());
                }
                if (uhDcOrdPks.size() > 0) {
                    List<UhDcOrdMedi> lstUhDcOrdMedi = uhDcOrdMediService.getUhDcOrdMediListByUhDcOrdPks(uhDcOrdPks);
                    tables+="UhDcOrdMedi";
                    uhDcOrdMediService.deleteUhDcOrdMediList(lstUhDcOrdMedi);
                }
                tables+="UhDcPvPres";
                uhDcPvPresService.deleteUhDcPvPresList(lstUhDcPvPres);
//    			uhDcPvDiagService.deleteUhDcPvDiagList(lstUhDcPvDiag);
                tables+="UhDcOrd";
                orderService.deleteUhDcOrdList(lstUhDcOrd);
                
                mipMsgLog.setBusinessTables(tables);
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPv.getPkPati() + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));
            } else {
                st301Logger.info("st301消息没有处方号");
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "st301消息没有处方号", MessageStatus.NULL_FIELD));
                 
                return;
            }
            if ("D".equals(st301.getActionType())) {
                return;
            }
        }
 

        List<Prescription> lstPrescription = st301.getPrescription();
        boolean isWest = false;
        if (lstPrescription.size() > 0) {
            if (lstPrescription.get(0).getWesternMedicine().size() > 0) {
                isWest = true;
            }
        } else {
            return;
        }

        UhDcPvDiag diag = new UhDcPvDiag();
        setUhDcPvDiag(diag, st301);
        diag.setPkDcpv(uhDcPv.getPkDcpv());
        uhDcPvDiagService.saveUhDcPvDiag(diag);
        tables+="uhdcpvdiag";

        List<UhDcPvPres> lstUhDcPvPres = new ArrayList<UhDcPvPres>();
        for (Prescription pres : lstPrescription) {
            UhDcPvPres uhDcPvPres = new UhDcPvPres();
            setUhDcPvPres(uhDcPvPres, pres, st301);
            uhDcPvPres.setPkDcpv(uhDcPv.getPkDcpv());
            lstUhDcPvPres.add(uhDcPvPres);

            if (isWest) {
                List<WesternMedicine> lstWesternMedicine = pres.getWesternMedicine();
                for (WesternMedicine wm : lstWesternMedicine) {
                    UhDcOrd uhDcOrd = new UhDcOrd();
                    setUhDcOrd(uhDcOrd, pres, wm, st301);
                    uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
                    orderService.saveOrder(uhDcOrd);
                    tables+="uhDcOrd";
                    UhDcOrdMedi uhDcOrdMedi = new UhDcOrdMedi();
                    setUhDcOrdMedi(uhDcOrdMedi, pres, wm, st301);
                    uhDcOrdMedi.setPkDcord(uhDcOrd.getPkDcord());
                    uhDcOrdMediService.saveUhDcOrdMedi(uhDcOrdMedi);
                    tables+="uhDcOrdMedi";
                 }
            } else {
                List<ChineseMedicine> lstChineseMedicine = pres.getChineseMedicine();
                for (ChineseMedicine cm : lstChineseMedicine) {
                    List<ChineseMedicineSub> lstChineseMedicineSub = cm.getChineseMedicineSub();
                    for (ChineseMedicineSub cms : lstChineseMedicineSub) {
                        UhDcOrd uhDcOrd = new UhDcOrd();
                        setUhDcOrd(uhDcOrd, pres, cm, st301, cms);
                        uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
                        orderService.saveOrder(uhDcOrd);
                        tables+="uhDcOrd";
                        UhDcOrdMedi uhDcOrdMedi = new UhDcOrdMedi();
                        setUhDcOrdMedi(uhDcOrdMedi, pres, cm, st301, cms);
                        uhDcOrdMedi.setPkDcord(uhDcOrd.getPkDcord());
                        tables+="uhDcOrdMedi";
                        uhDcOrdMediService.saveUhDcOrdMedi(uhDcOrdMedi);
 
                    }
                }
            }
        }
        tables+="uhDcPvPres";
        uhDcPvPresService.saveUhDcPvPresList(lstUhDcPvPres);
        mipMsgLog.setBusinessTables(tables);
        msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPv.getPkPati() + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));

    }

    private void setUhDcOrdMedi(UhDcOrdMedi uhDcOrdMedi, Prescription pres, ChineseMedicine cm, ST301 st301, ChineseMedicineSub cms) {
        // TODO Auto-generated method stub
        uhDcOrdMedi.setCodeOrd(cm.getId() + "_" + cms.getId());
        uhDcOrdMedi.setBaseMediCode(cm.getTypeCode());
        uhDcOrdMedi.setBaseMediName(cm.getTypeName());
        
        if(ObjectUtils.isNotEmpty(cm.getRepeatNumber())){
        	  uhDcOrdMedi.setDuration(Integer.parseInt(cm.getRepeatNumber()));
        }
      
        uhDcOrdMedi.setDurationUnits(cm.getRepeatUnit());
        uhDcOrdMedi.setCodeMediWay(cm.getRouteCode());
        uhDcOrdMedi.setNameMediWay(cm.getRouteName());
        uhDcOrdMedi.setDosage(cm.getDoseQuantity());
        uhDcOrdMedi.setDosageUnits(cm.getDoseUnit());
        uhDcOrdMedi.setNumTotal(cm.getDoseCheckQuantity());
        uhDcOrdMedi.setCodeForm(cm.getUnitCode());
        uhDcOrdMedi.setNameForm(cm.getUnitName());
        uhDcOrdMedi.setIsAuxiMedi("false".equals(cm.getAncillaryDrugFlag()) ? "0" : "1");
        uhDcOrdMedi.setDrugtest("false".equals(cm.getSkinTestFlag()) ? "0" : "1");
        uhDcOrdMedi.setWeight(new BigDecimal(cms.getQuantity()));
        uhDcOrdMedi.setUnitWight(cms.getQuantityUnit());
        uhDcOrdMedi.setCodeMake(cms.getHandlingCode());
        uhDcOrdMedi.setNameMake(cms.getHandlingName());

        uhDcOrdMedi.setCodeGroup(Constant.getGroupCode());
        uhDcOrdMedi.setCodeOrg(Constant.getOrgCode());
        uhDcOrdMedi.setDataSource(st301.getSenderId());
        uhDcOrdMedi.setSourcePk(st301.getPvInfo().getPvId());
        uhDcOrdMedi.setCreateTime(new Date());
        uhDcOrdMedi.setEditTime(new Date());
        uhDcOrdMedi.setFlagDel(0);
    }

    private void setUhDcOrd(UhDcOrd uhDcOrd, Prescription pres, ChineseMedicine cm, ST301 st301, ChineseMedicineSub cms) {
        // TODO Auto-generated method stub
        uhDcOrd.setCodePres(pres.getId());
        uhDcOrd.setCodeOrd(cm.getId() + "_" + cms.getId());
        uhDcOrd.setCodeOrditemType(pres.getTypeCode());
        uhDcOrd.setNameOrditemType(pres.getTypeName());
        uhDcOrd.setNoteOrd(pres.getRemark());
        uhDcOrd.setDateCreate(DateUtils.getDateStr2Str(pres.getAuthorTime()));
        uhDcOrd.setCodePsnPhy(pres.getAuthorCode());
        uhDcOrd.setNamePsnPhy(pres.getAuthorName());
        uhDcOrd.setCodeDetpPhy(pres.getAuthorOrgcode());
        uhDcOrd.setNameDeptPhy(pres.getAuthorOrgName());
        uhDcOrd.setCodePsnRec(pres.getTranscriberCode());
        uhDcOrd.setNamePsnRec(pres.getTranscriberName());
        uhDcOrd.setCodeFreq(cm.getFrequenceCode());
        uhDcOrd.setNameFreq(cm.getFrequenceName());
        uhDcOrd.setCodeDeptExec(cm.getExecOrgCode());
        uhDcOrd.setNameDeptExec(cm.getExecOrgName());
        uhDcOrd.setCodeOrditem(cms.getDrugCode());
        uhDcOrd.setNameOrditem(cms.getDrugName());
        uhDcOrd.setFlagUrgent("false".equals(cm.getUrgentFlag()) ? 0 : 1);
        uhDcOrd.setOrdEntrust(cm.getEntrust());

        uhDcOrd.setCodeGroup(Constant.getGroupCode());
        uhDcOrd.setCodeOrg(Constant.getOrgCode());
        uhDcOrd.setEmpi(st301.getPvInfo().getPatient().getEmpiId());
        uhDcOrd.setCodePati(st301.getPvInfo().getPatient().getPatientId());
        uhDcOrd.setCodePvtype(st301.getPvInfo().getPvTypeCode());
        uhDcOrd.setNamePvtype(st301.getPvInfo().getPvTypeName());
        uhDcOrd.setPvcode(st301.getPvInfo().getPvId());
        uhDcOrd.setPatiname(st301.getPvInfo().getPatient().getPatientName());
        uhDcOrd.setCodeSex(st301.getPvInfo().getPatient().getGenderCode());
        uhDcOrd.setNameSex(st301.getPvInfo().getPatient().getGenderName());
        uhDcOrd.setBirthday(DateUtil.BirthTimeFormatter(st301.getPvInfo().getPatient().getBirthDate()));
        uhDcOrd.setCodeDept(st301.getPvInfo().getPatient().getOrgCode());
        uhDcOrd.setNameDept(st301.getPvInfo().getPatient().getOrgName());
        uhDcOrd.setCodeArea(st301.getPvInfo().getAreaCode());
        uhDcOrd.setNameArea(st301.getPvInfo().getAreaName());
        uhDcOrd.setDataSource(st301.getSenderId());
        uhDcOrd.setSourcePk(st301.getPvInfo().getPvId());
        uhDcOrd.setCreateTime(new Date());
        uhDcOrd.setEditTime(new Date());
        uhDcOrd.setFlagDel(0);
    }

    private void setUhDcOrdMedi(UhDcOrdMedi uhDcOrdMedi, Prescription pres, WesternMedicine wm, ST301 st301) {
        // TODO Auto-generated method stub
        uhDcOrdMedi.setCodeOrd(wm.getId());
        uhDcOrdMedi.setCodeMediType(wm.getCategoryCode());
        uhDcOrdMedi.setNameMediType(wm.getCategoryName());
        uhDcOrdMedi.setBaseMediCode(wm.getTypeCode());
        uhDcOrdMedi.setBaseMediName(wm.getTypeName());
        uhDcOrdMedi.setDuration(Integer.parseInt(wm.getRepeatNumber()));
        uhDcOrdMedi.setDurationUnits(wm.getRepeatUnit());
        uhDcOrdMedi.setCodeMediWay(wm.getRouteCode());
        uhDcOrdMedi.setNameMediWay(wm.getRouteName());
        uhDcOrdMedi.setDosage(wm.getDoseQuantity());
        uhDcOrdMedi.setDosageUnits(wm.getDoseUnit());
        uhDcOrdMedi.setNumTotal(wm.getDoseCheckQuantity());
        uhDcOrdMedi.setDosageTake(wm.getMaxDoseQuantity());
        uhDcOrdMedi.setTakeUnit(wm.getMaxDoseQuantityUnit());
        uhDcOrdMedi.setCodeForm(wm.getUnitCode());
        uhDcOrdMedi.setNameForm(wm.getUnitName());
        uhDcOrdMedi.setSpecSrv(wm.getFormCode());
        uhDcOrdMedi.setPackUnit(wm.getFormName());
        uhDcOrdMedi.setCodeLevelAnti(wm.getAntibioticCode());
        uhDcOrdMedi.setNameLevelAnti(wm.getAntibioticName());
        uhDcOrdMedi.setCodeAntiReason(wm.getAntibioticReasonCode());
        uhDcOrdMedi.setNameAntiReason(wm.getAntibioticReasonName());
        uhDcOrdMedi.setCodeDrugType(wm.getPoisonCode());
        uhDcOrdMedi.setNameDrugType(wm.getPoisonName());
        uhDcOrdMedi.setIsAuxiMedi("false".equals(wm.getAncillaryDrugFlag()) ? "0" : "1");
        uhDcOrdMedi.setDrugtest("false".equals(wm.getSkinTestFlag()) ? "0" : "1");
   
        uhDcOrdMedi.setCodePresType(Constant.getPresTypeD());
        uhDcOrdMedi.setNamePresType(Constant.getPresNameD());
        
        uhDcOrdMedi.setCodeGroup(Constant.getGroupCode());
        uhDcOrdMedi.setCodeOrg(Constant.getOrgCode());
        uhDcOrdMedi.setDataSource(st301.getSenderId());
        uhDcOrdMedi.setSourcePk(st301.getPvInfo().getPvId());
        uhDcOrdMedi.setCreateTime(new Date());
        uhDcOrdMedi.setEditTime(new Date());
        uhDcOrdMedi.setFlagDel(0);
    }

    private void setUhDcOrd(UhDcOrd uhDcOrd, Prescription pres, WesternMedicine wm, ST301 st301) {
        // TODO Auto-generated method stub
        uhDcOrd.setCodePres(pres.getId());
        uhDcOrd.setCodeOrd(wm.getId());
        uhDcOrd.setCodeOrditemType(pres.getTypeCode());
        uhDcOrd.setNameOrditemType(pres.getTypeName());
        uhDcOrd.setNoteOrd(pres.getRemark());
        uhDcOrd.setDateCreate(DateUtil.ToSecondFormatter(pres.getAuthorTime()));
        uhDcOrd.setCodePsnPhy(pres.getAuthorCode());
        uhDcOrd.setNamePsnPhy(pres.getAuthorName());
        uhDcOrd.setCodeDetpPhy(pres.getAuthorOrgcode());
        uhDcOrd.setNameDeptPhy(pres.getAuthorOrgName());
        uhDcOrd.setCodePsnRec(pres.getTranscriberCode());
        uhDcOrd.setNamePsnRec(pres.getTranscriberName());
        uhDcOrd.setCodeFreq(wm.getFrequenceCode());
        uhDcOrd.setNameFreq(wm.getFrequenceName());
        uhDcOrd.setCodeUsage(wm.getRouteCode());
        uhDcOrd.setNameUsage(wm.getRouteName());
        uhDcOrd.setCodeOrditem(wm.getDrugCode());
        uhDcOrd.setNameOrditem(wm.getNormalName());
        uhDcOrd.setCodeDeptExec(wm.getExecOrgCode());
        uhDcOrd.setNameDeptExec(wm.getExecOrgName());
        uhDcOrd.setFlagUrgent("false".equals(wm.getUrgentFlag()) ? 0 : 1);
        uhDcOrd.setOrdEntrust(wm.getEntrust());

        uhDcOrd.setCodeGroup(Constant.getGroupCode());
        uhDcOrd.setCodeOrg(Constant.getOrgCode());
        uhDcOrd.setEmpi(st301.getPvInfo().getPatient().getEmpiId());
        uhDcOrd.setCodePati(st301.getPvInfo().getPatient().getPatientId());
        uhDcOrd.setCodePvtype(st301.getPvInfo().getPvTypeCode());
        uhDcOrd.setNamePvtype(st301.getPvInfo().getPvTypeName());
        uhDcOrd.setPvcode(st301.getPvInfo().getPvId());
        uhDcOrd.setPatiname(st301.getPvInfo().getPatient().getPatientName());
        uhDcOrd.setCodeSex(st301.getPvInfo().getPatient().getGenderCode());
        uhDcOrd.setNameSex(st301.getPvInfo().getPatient().getGenderName());
        uhDcOrd.setBirthday(DateUtil.BirthTimeFormatter(st301.getPvInfo().getPatient().getBirthDate()));
        uhDcOrd.setCodeDept(st301.getPvInfo().getPatient().getOrgCode());
        uhDcOrd.setNameDept(st301.getPvInfo().getPatient().getOrgName());
        uhDcOrd.setCodeArea(st301.getPvInfo().getAreaCode());
        uhDcOrd.setNameArea(st301.getPvInfo().getAreaName());
        uhDcOrd.setDataSource(st301.getSenderId());
        uhDcOrd.setSourcePk(st301.getPvInfo().getPvId());
        uhDcOrd.setCreateTime(new Date());
        uhDcOrd.setEditTime(new Date());
        uhDcOrd.setFlagDel(0);
    }

    private void setUhDcPvPres(UhDcPvPres uhDcPvPres, Prescription pres, ST301 st301) {
        // TODO Auto-generated method stub
        uhDcPvPres.setCodePres(pres.getId());
        uhDcPvPres.setCodePresType(pres.getCategoryCode());
        uhDcPvPres.setNamePresType(pres.getCategoryName());
        uhDcPvPres.setCodeOrdmediType(pres.getTypeCode());
        uhDcPvPres.setNameOrdmediType(pres.getTypeName());
        uhDcPvPres.setNote(pres.getRemark());
        uhDcPvPres.setDateCreate(DateUtils.getDateStr2Str(pres.getAuthorTime()));
        uhDcPvPres.setCodePsnPhy(pres.getAuthorCode());
        uhDcPvPres.setNamePsnPhy(pres.getAuthorName());
        uhDcPvPres.setCodeDetpPhy(pres.getAuthorOrgcode());
        uhDcPvPres.setNameDeptPhy(pres.getAuthorOrgName());
        uhDcPvPres.setCodePsnAudit(pres.getReviewerCode());
        uhDcPvPres.setNamePsnAudit(pres.getReviewerName());
        uhDcPvPres.setCodeDiag(st301.getDiagnosis().getDiagCode());
        uhDcPvPres.setNameDiag(st301.getDiagnosis().getDiagName());

        uhDcPvPres.setCodeGroup(Constant.getGroupCode());
        uhDcPvPres.setCodeOrg(Constant.getOrgCode());
        uhDcPvPres.setEmpi(st301.getPvInfo().getPatient().getEmpiId());
        uhDcPvPres.setCodePati(st301.getPvInfo().getPatient().getPatientId());
        uhDcPvPres.setCodePvtype(st301.getPvInfo().getPvTypeCode());
        uhDcPvPres.setNamePvtype(st301.getPvInfo().getPvTypeName());
        uhDcPvPres.setPvcode(st301.getPvInfo().getPvId());
        uhDcPvPres.setPatiname(st301.getPvInfo().getPatient().getPatientName());
        uhDcPvPres.setCodeSex(st301.getPvInfo().getPatient().getGenderCode());
        uhDcPvPres.setNameSex(st301.getPvInfo().getPatient().getGenderName());
        uhDcPvPres.setBirthday(DateUtil.BirthTimeFormatter(st301.getPvInfo().getPatient().getBirthDate()));
        uhDcPvPres.setDataSource(st301.getSenderId());
        uhDcPvPres.setSourcePk(st301.getPvInfo().getPvId());
        uhDcPvPres.setCreateTime(new Date());
        uhDcPvPres.setEditTime(new Date());
        uhDcPvPres.setFlagDel(0);
    }


    private void setUhDcPvDiag(UhDcPvDiag diag, ST301 st301) {
        // TODO Auto-generated method stub
        diag.setCodeDiagtype(st301.getDiagnosis().getDiagTypeCode());
        diag.setNameDiagtype(st301.getDiagnosis().getDiagTypeName());
        diag.setCodeDiag(st301.getDiagnosis().getDiagCode());
        diag.setNameDiag(st301.getDiagnosis().getDiagName());
        diag.setDateDiag(DateUtil.ToSecondFormatter(st301.getDiagnosis().getDiagTime()));
        diag.setCodePsnDiag(st301.getDiagnosis().getDiagDocCode());
        diag.setNamePsnDiag(st301.getDiagnosis().getDiagDocName());
        diag.setCodeDeptDiag(st301.getPvInfo().getOrgCode());
        diag.setNameDeptDiag(st301.getPvInfo().getOrgName());
        diag.setFlagMain(st301.getDiagnosis().getDiagMainFlag());
        diag.setFlagUncertainty(st301.getDiagnosis().getDiagUncertaintyCode());

        diag.setCodeGroup(Constant.getGroupCode());
        diag.setCodeOrg(Constant.getOrgCode());
        diag.setPvcode(st301.getPvInfo().getPvId());
        diag.setEmpi(st301.getPvInfo().getPatient().getEmpiId());
        diag.setCodePati(st301.getPvInfo().getPatient().getPatientId());
        diag.setCodePvtype(st301.getPvInfo().getPvTypeCode());
        diag.setNamePvtype(st301.getPvInfo().getPvTypeName());
        diag.setDataSource(st301.getSenderId());
        diag.setSourcePk(st301.getPvInfo().getPvId());
        diag.setCreateTime(new Date());
        diag.setEditTime(new Date());
        diag.setFlagDel(0);
    }

}
