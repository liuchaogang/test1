package com.yonyou.writer;

import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdMedi;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST303.ChineseMedicine;
import com.yonyou.hl7adapter.model.ST303.ChineseMedicineSub;
import com.yonyou.hl7adapter.model.ST303.ST303;
import com.yonyou.hl7adapter.model.ST303.WesternMedicine;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcOrdMediService;
import com.yonyou.util.Constant;

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
@Component(value = "ST303")
public class ST303Writer implements BaseProcessWriter<ST303> {

    private static Logger logger = LoggerFactory.getLogger("ST303Logger");

    @Autowired
    private OrderService orderService;
    @Autowired
	private UhDcOrdMediService uhDcOrdMediService;
    @Autowired
    private PatientVisitService patientVisitService;
    
    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;
    
    
    @Override
    public boolean validation(ST303 st303, Object reMsg) {
    	 msgId = st303.getMsgId();

         if (StringUtils.isEmpty(msgId)) {
             logger.error("st209,msgId为空");
             return false;
         }

         mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
        return true;
    }
    @Override
    public boolean checkPre(ST303 st303) {
        return true;
    }
    @Override
    @Transactional
    public void businessWrite(ST303 st303) {
    	UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(st303.getPvInfo().getPvId());
    	if(null==uhDcPv){
    		logger.debug("st303没有找到就诊记录：就诊号pvcode:"+st303.getPvInfo().getPvId());
    		return;
    	}
    	boolean isWest = false;
    	if(st303.getWesternMedicine().size()>0){
    		isWest = true;
    	}else if(st303.getChineseMedicine().size()>0){
    		isWest = false;
    	}else{
    		return;
    	}

    	if("U".equals(st303.getActionType()) || "D".equals(st303.getActionType())){
    		List<String> ordNos = new ArrayList<String>();
    		if(isWest){
	    		for(WesternMedicine wm : st303.getWesternMedicine()){
	    			ordNos.add(wm.getId());
	    		}
    		}else{
    			for(ChineseMedicine cm : st303.getChineseMedicine()){
	    			ordNos.add(cm.getId());
	    		}
    		}
    		if(ordNos.size() > 0){
    			List<UhDcOrd> lstUhDcOrd = orderService.getUhDcOrdListByOrdNos(ordNos, isWest);
    			List<String> uhDcOrdPks = new ArrayList<String>();
    			for(UhDcOrd uhDcOrd : lstUhDcOrd){
    				uhDcOrdPks.add(uhDcOrd.getPkDcord());
    			}
    			if(uhDcOrdPks.size() > 0){
    				List<UhDcOrdMedi> lstUhDcOrdMedi = uhDcOrdMediService.getUhDcOrdMediListByUhDcOrdPks(uhDcOrdPks);
    				uhDcOrdMediService.deleteUhDcOrdMediList(lstUhDcOrdMedi);
    			}
    			orderService.deleteUhDcOrdList(lstUhDcOrd);
    		}else{
    			logger.info("st303消息没有医嘱号");
    			return;
    		}
    		if("D".equals(st303.getActionType())){
    			return;
    		}
    	}
    	
    	 
		if(isWest){
			List<WesternMedicine> lstWesternMedicine = st303.getWesternMedicine();
			for(WesternMedicine wm : lstWesternMedicine){
				UhDcOrd uhDcOrd = new UhDcOrd();
				setUhDcOrd(uhDcOrd, wm, st303);
				uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
				orderService.saveOrder(uhDcOrd);
				
				UhDcOrdMedi uhDcOrdMedi = new UhDcOrdMedi();
				setUhDcOrdMedi(uhDcOrdMedi, wm, st303);
				uhDcOrdMedi.setPkDcord(uhDcOrd.getPkDcord());
				uhDcOrdMediService.saveUhDcOrdMedi(uhDcOrdMedi);
			}
		}else{
			List<ChineseMedicine> lstChineseMedicine = st303.getChineseMedicine();
			for(ChineseMedicine cm : lstChineseMedicine){
				List<ChineseMedicineSub> lstChineseMedicineSub = cm.getChineseMedicineSub();
				for(ChineseMedicineSub cms : lstChineseMedicineSub){
					UhDcOrd uhDcOrd = new UhDcOrd();
					setUhDcOrd(uhDcOrd, cm, st303, cms);
					uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
					orderService.saveOrder(uhDcOrd);
					
					UhDcOrdMedi uhDcOrdMedi = new UhDcOrdMedi();
					setUhDcOrdMedi(uhDcOrdMedi, cm, st303, cms);
					uhDcOrdMedi.setPkDcord(uhDcOrd.getPkDcord());
					uhDcOrdMediService.saveUhDcOrdMedi(uhDcOrdMedi);
				}
			}
		}
    }
    
	private void setUhDcOrdMedi(UhDcOrdMedi uhDcOrdMedi, ChineseMedicine cm, ST303 st303, ChineseMedicineSub cms) {
		// TODO Auto-generated method stub
		uhDcOrdMedi.setCodeOrd(cm.getId()+"_"+cms.getId());
		uhDcOrdMedi.setBaseMediCode(cm.getBaseTypeCode());
		uhDcOrdMedi.setBaseMediName(cm.getBaseTypeName());
		uhDcOrdMedi.setDuration(Integer.parseInt(cm.getRepeatNumber()));
		uhDcOrdMedi.setDurationUnits(cm.getRepeatUnit());
		uhDcOrdMedi.setCodeMediWay(cm.getRouteCode());
		uhDcOrdMedi.setNameMediWay(cm.getRouteName());
		uhDcOrdMedi.setDosage(cm.getDoseQuantity());
		uhDcOrdMedi.setDosageUnits(cm.getDoseUnit());
		uhDcOrdMedi.setNumTotal(cm.getDoseCheckQuantity());
		uhDcOrdMedi.setDosageTake(cm.getMaxDoseQuantity());
		uhDcOrdMedi.setTakeUnit(cm.getMaxDoseQuantityUnit());
		uhDcOrdMedi.setCodeForm(cm.getUnitCode());
		uhDcOrdMedi.setNameForm(cm.getUnitName());
		uhDcOrdMedi.setIsAuxiMedi("false".equals(cm.getAncillaryDrugFlag())?"0":"1");
		uhDcOrdMedi.setDrugtest("false".equals(cm.getSkinTestFlag())?"0":"1");
		uhDcOrdMedi.setWeight(new BigDecimal(cms.getQuantity()));
		uhDcOrdMedi.setUnitWight(cms.getQuantityUnit());
		uhDcOrdMedi.setCodeMake(cms.getHandlingCode());
		uhDcOrdMedi.setNameMake(cms.getHandlingName());
		
		uhDcOrdMedi.setCodeGroup(Constant.getGroupCode());
		uhDcOrdMedi.setCodeOrg(Constant.getOrgCode());
		uhDcOrdMedi.setDataSource(st303.getSenderId());
		uhDcOrdMedi.setSourcePk(st303.getPvInfo().getPvId());
		uhDcOrdMedi.setCreateTime(new Date());
		uhDcOrdMedi.setEditTime(new Date());
		uhDcOrdMedi.setFlagDel(0);
	}
	
	private void setUhDcOrd(UhDcOrd uhDcOrd, ChineseMedicine cm, ST303 st303, ChineseMedicineSub cms) {
		// TODO Auto-generated method stub
		uhDcOrd.setCodeOrd(cm.getId()+"_"+cms.getId());
		uhDcOrd.setCodeSrvtype(cm.getOrderTypeCode());
		uhDcOrd.setNameSrvtype(cm.getOrderTypeName());
		uhDcOrd.setCodeOrditemType(cm.getOrderItemTypeCode());
		uhDcOrd.setNameOrditemType(cm.getOrderItemTypeName());
		uhDcOrd.setCodeOrditem(cm.getOrderItemCode());
		uhDcOrd.setNameOrditem(cm.getOrderItemName());
		uhDcOrd.setNoteOrd(cm.getRemark());
		uhDcOrd.setCodeOrdStatus(cm.getOrderStatus());
		uhDcOrd.setDateBegin(DateUtil.ToSecondFormatter(cm.getOrderStartTime()));
		uhDcOrd.setDateOrderEffe(DateUtil.ToSecondFormatter(cm.getOrderEndTime()));
		uhDcOrd.setCodeFreq(cm.getFrequenceCode());
		uhDcOrd.setNameFreq(cm.getFrequenceName());
		uhDcOrd.setDateCreate(DateUtil.ToSecondFormatter(cm.getAuthorTime()));
		uhDcOrd.setCodePsnPhy(cm.getAuthorCode());
		uhDcOrd.setNamePsnPhy(cm.getAuthorName());
		uhDcOrd.setCodeDetpPhy(cm.getAuthorOrgcode());
		uhDcOrd.setNameDeptPhy(cm.getAuthorOrgName());
		uhDcOrd.setCodePsnRec(cm.getTranscriberCode());
		uhDcOrd.setNamePsnRec(cm.getTranscriberName());
		uhDcOrd.setDateChk(DateUtil.ToSecondFormatter(cm.getVerifierNurseTime()));
		uhDcOrd.setCodePsnChk(cm.getVerifierNurseCode());
		uhDcOrd.setNamePsnChk(cm.getVerifierNurseName());
		uhDcOrd.setCodeDeptExec(cm.getExecOrgCode());
		uhDcOrd.setNameDeptExec(cm.getExecOrgName());
		uhDcOrd.setParentCode(cm.getParentOrderId());
		uhDcOrd.setCodeUsage(cm.getReasonUseCode());
		uhDcOrd.setNameUsage(cm.getReasonUseName());
		uhDcOrd.setCodeUsageReq(cm.getReasonUseReqCode());
		uhDcOrd.setNameUsageReq(cm.getReasonUseReqName());
		uhDcOrd.setFlagUrgent("false".equals(cm.getUrgentFlag())?0:1);
		uhDcOrd.setIsSpareOrd("false".equals(cm.getReserveFlag())?0:1);
		uhDcOrd.setDescSpareOrd(cm.getReserveRemark());
		uhDcOrd.setOrdEntrust(cm.getEntrust());
		uhDcOrd.setCodeOrditem(cms.getDrugCode());
		uhDcOrd.setNameOrditem(cms.getDrugName());
		
		uhDcOrd.setCodeGroup(Constant.getGroupCode());
		uhDcOrd.setCodeOrg(Constant.getOrgCode());
		uhDcOrd.setEmpi(st303.getPvInfo().getPatient().getEmpiId());
		uhDcOrd.setCodePati(st303.getPvInfo().getPatient().getPatientId());
		uhDcOrd.setCodePvtype(st303.getPvInfo().getPvTypeCode());
		uhDcOrd.setNamePvtype(st303.getPvInfo().getPvTypeName());
		uhDcOrd.setPvcode(st303.getPvInfo().getPvId());
		uhDcOrd.setPatiname(st303.getPvInfo().getPatient().getPatientName());
		uhDcOrd.setCodeSex(st303.getPvInfo().getPatient().getGenderCode());
		uhDcOrd.setNameSex(st303.getPvInfo().getPatient().getGenderName());
		uhDcOrd.setBirthday(DateUtil.BirthTimeFormatter(st303.getPvInfo().getPatient().getBirthDate()));
		uhDcOrd.setCodeDept(st303.getPvInfo().getPatient().getOrgCode());
		uhDcOrd.setNameDept(st303.getPvInfo().getPatient().getOrgName());
		uhDcOrd.setCodeArea(st303.getPvInfo().getAreaCode());
		uhDcOrd.setNameArea(st303.getPvInfo().getAreaName());
		uhDcOrd.setDataSource(st303.getSenderId());
		uhDcOrd.setSourcePk(st303.getPvInfo().getPvId());
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		uhDcOrd.setFlagDel(0);
	}
	
	private void setUhDcOrdMedi(UhDcOrdMedi uhDcOrdMedi, WesternMedicine wm, ST303 st303) {
		// TODO Auto-generated method stub
		uhDcOrdMedi.setCodeOrd(wm.getId());
		uhDcOrdMedi.setCodeMediType(wm.getClinicTypeCode());
		uhDcOrdMedi.setNameMediType(wm.getClinicTypeName());
		uhDcOrdMedi.setBaseMediCode(wm.getBaseTypeCode());
		uhDcOrdMedi.setBaseMediName(wm.getBaseTypeName());
 	//	uhDcOrdMedi.setDuration(Integer.parseInt(wm.getRepeatNumber()));
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
		uhDcOrdMedi.setIsAuxiMedi("false".equals(wm.getAncillaryDrugFlag())?"0":"1");
		uhDcOrdMedi.setDrugtest("false".equals(wm.getSkinTestFlag())?"0":"1");
		
		uhDcOrdMedi.setCodeGroup(Constant.getGroupCode());
		uhDcOrdMedi.setCodeOrg(Constant.getOrgCode());
		uhDcOrdMedi.setDataSource(st303.getSenderId());
		uhDcOrdMedi.setSourcePk(st303.getPvInfo().getPvId());
		uhDcOrdMedi.setCreateTime(new Date());
		uhDcOrdMedi.setEditTime(new Date());
		uhDcOrdMedi.setFlagDel(0);
	}
	
	private void setUhDcOrd(UhDcOrd uhDcOrd, WesternMedicine wm, ST303 st303) {
		// TODO Auto-generated method stub
		uhDcOrd.setCodeOrd(wm.getId());
		uhDcOrd.setCodeSrvtype(wm.getOrderTypeCode());
		uhDcOrd.setNameSrvtype(wm.getOrderTypeName());
		uhDcOrd.setCodeOrditemType(wm.getOrderItemTypeCode());
		uhDcOrd.setNameOrditemType(wm.getOrderItemTypeName());
		uhDcOrd.setCodeOrditem(wm.getOrderItemCode());
		uhDcOrd.setNameOrditem(wm.getOrderItemName());
		uhDcOrd.setNoteOrd(wm.getRemark());
		uhDcOrd.setCodeOrdStatus(wm.getOrderStatus());
		uhDcOrd.setDateBegin(DateUtil.ToSecondFormatter(wm.getOrderStartTime()));
		uhDcOrd.setDateOrderEffe(DateUtil.ToSecondFormatter(wm.getOrderEndTime()));
		uhDcOrd.setCodeFreq(wm.getFrequenceCode());
		uhDcOrd.setNameFreq(wm.getFrequenceName());
		uhDcOrd.setCodeOrditem(wm.getDrugCode());
		uhDcOrd.setNameOrditem(wm.getNormalName());
		uhDcOrd.setAmountSrv(new BigDecimal(wm.getMoneyTotal()));
		uhDcOrd.setAmountSelf(new BigDecimal(wm.getMoneySelf()));
		uhDcOrd.setDateCreate(DateUtil.ToSecondFormatter(wm.getAuthorTime()));
		uhDcOrd.setCodePsnPhy(wm.getAuthorCode());
		uhDcOrd.setNamePsnPhy(wm.getAuthorName());
		uhDcOrd.setCodeDetpPhy(wm.getAuthorOrgcode());
		uhDcOrd.setNameDeptPhy(wm.getAuthorOrgName());
		uhDcOrd.setCodePsnRec(wm.getTranscriberCode());
		uhDcOrd.setNamePsnRec(wm.getTranscriberName());
	//	uhDcOrd.setDateChk(DateUtil.ToSecondFormatter(wm.getVerifierNurseTime()));
		uhDcOrd.setCodePsnChk(wm.getVerifierNurseCode());
		uhDcOrd.setNamePsnChk(wm.getVerifierNurseName());
		uhDcOrd.setCodeDeptExec(wm.getExecOrgCode());
		uhDcOrd.setNameDeptExec(wm.getExecOrgName());
		uhDcOrd.setParentCode(wm.getParentOrderId());
		uhDcOrd.setFlagUrgent("false".equals(wm.getUrgentFlag())?0:1);
		uhDcOrd.setIsSpareOrd("false".equals(wm.getReserveFlag())?0:1);
		uhDcOrd.setDescSpareOrd(wm.getReserveRemark());
		uhDcOrd.setOrdEntrust(wm.getEntrust());
		
		uhDcOrd.setCodeGroup(Constant.getGroupCode());
		uhDcOrd.setCodeOrg(Constant.getOrgCode());
		uhDcOrd.setEmpi(st303.getPvInfo().getPatient().getEmpiId());
		uhDcOrd.setCodePati(st303.getPvInfo().getPatient().getPatientId());
		uhDcOrd.setCodePvtype(st303.getPvInfo().getPvTypeCode());
		uhDcOrd.setNamePvtype(st303.getPvInfo().getPvTypeName());
		uhDcOrd.setPvcode(st303.getPvInfo().getPvId());
		uhDcOrd.setPatiname(st303.getPvInfo().getPatient().getPatientName());
		uhDcOrd.setCodeSex(st303.getPvInfo().getPatient().getGenderCode());
		uhDcOrd.setNameSex(st303.getPvInfo().getPatient().getGenderName());
		uhDcOrd.setBirthday(DateUtil.BirthTimeFormatter(st303.getPvInfo().getPatient().getBirthDate()));
		uhDcOrd.setCodeDept(st303.getPvInfo().getPatient().getOrgCode());
		uhDcOrd.setNameDept(st303.getPvInfo().getPatient().getOrgName());
		uhDcOrd.setCodeArea(st303.getPvInfo().getAreaCode());
		uhDcOrd.setNameArea(st303.getPvInfo().getAreaName());
		uhDcOrd.setDataSource(st303.getSenderId());
		uhDcOrd.setSourcePk(st303.getPvInfo().getPvId());
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		uhDcOrd.setFlagDel(0);
	}
	
}
