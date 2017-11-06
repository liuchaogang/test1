package com.yonyou.writer;


import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdTrans;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST404.ST404;
import com.yonyou.service.CheckApplicationService;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcOrdTransService;

@Component(value = "ST404")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST404Writer implements BaseProcessWriter<ST404>{

    private static Logger logger = LoggerFactory.getLogger("ST404Logger");

    @Autowired
    private CheckApplicationService checkApplicationService;
    @Autowired
    private PatientVisitService patientVisitService;
    @Autowired
    private UhDcOrdTransService uhDcOrdTransService;
    @Autowired
    private OrderService orderService;
    
    private String serviceType;
    
	@Override
	public boolean validation(ST404 st404, Object reMsg) {
		serviceType = st404.getServiceType();
		if(StringUtils.isEmpty(serviceType)){
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPre(ST404 st404) {
		return true;
	}

	@Override
	@Transactional
	public void businessWrite(ST404 st404) {
		String pvcode = st404.getVisitNo();
		if("A".equals(serviceType)){
			//新增医嘱表和医嘱手术表
			logger.debug("消息入库uh_dc_ord（），医嘱号：" + st404.getOrdersCode());
			UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(pvcode);
			if(uhDcPv !=null ){
				logger.debug("消息入库uh_dc_ord，医嘱号：" + st404.getOrdersCode());
				UhDcOrd uhDcOrd = saveUhDcOrd(st404);
				uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
				
				checkApplicationService.saveUhDcOrd(uhDcOrd);
				
				logger.debug("消息入库uh_dc_ord_trans，医嘱号：" + st404.getOrdersCode());
				UhDcOrdTrans uhDcOrdTrans = saveUhDcOrdTrans(st404,uhDcOrd);
				uhDcOrdTransService.saveUhDcOrdTrans(uhDcOrdTrans);
			}
		} else if("U".equals(serviceType)){
			
			UhDcOrd ordNo = orderService.getOrderByNo(st404.getOrdersCode());
			if(ordNo != null){
				UhDcOrd ord = saveUhDcOrd(st404);
				ord.setPkDcord(ordNo.getPkDcord());
				ord.setPkDcpv(ordNo.getPkDcpv());
				ord.setEditTime(new Date());
				checkApplicationService.saveUhDcOrd(ord);
				
				UhDcOrdTrans uhDcOrdTrans = checkApplicationService.getUhDcOrdTrans(ordNo.getPkDcord());
				if(uhDcOrdTrans != null){
					UhDcOrdTrans trans = saveUhDcOrdTrans(st404,ord);
					trans.setPkDcord(uhDcOrdTrans.getPkDcord());
					trans.setPkOrdBt(uhDcOrdTrans.getPkOrdBt());
					trans.setEditTime(new Date());
					uhDcOrdTransService.saveUhDcOrdTrans(trans);
				}
			}
			
		} else if("D".equals(serviceType)){
			
			String ordersCode = st404.getOrdersCode();   // 医嘱号
			
			logger.debug("取消输血申请，消息更改uh_dc_ord，医嘱号：" + ordersCode);
			UhDcOrd uhDcOrd = orderService.getOrderByNo(ordersCode);
			
			if(uhDcOrd != null){
				UhDcOrd ord = saveUhDcOrd(st404);
				ord.setPkDcord(uhDcOrd.getPkDcord());
				ord.setFlagCancel(1);     // 取消标记
				ord.setEditTime(new Date());
				ord.setNameCancelpesc("");
				checkApplicationService.saveUhDcOrd(ord);				
			}
		}
	}

	private UhDcOrd saveUhDcOrd(ST404 st404) {
		UhDcOrd uhDcOrd = new UhDcOrd();
		//uhDcOrd.setPkDcord("");
		//uhDcOrd.setPkDcpv(st404.getEMPINo());
		uhDcOrd.setCodeGroup(st404.getGroupCode());
		uhDcOrd.setCodeOrg(st404.getOrgCode());
		uhDcOrd.setEmpi(st404.getEMPINo());
		uhDcOrd.setCodePati(st404.getPidCode());
		uhDcOrd.setCodePvtype(st404.getPatientTypeCode());
		uhDcOrd.setNamePvtype(st404.getPatientTypeName());
		uhDcOrd.setPvcode(st404.getVisitNo());
		uhDcOrd.setPatiname(st404.getPatientName());
		uhDcOrd.setCodeSex(st404.getPatientSexCode());
		uhDcOrd.setNameSex(st404.getPatientSexName());
		uhDcOrd.setBirthday(st404.getPatientBirthTime());
		uhDcOrd.setAddrPre(st404.getPatientAddr());
		uhDcOrd.setTelenoPre(st404.getPatientTel());
		uhDcOrd.setCodeDept(st404.getDepartmentNo());
		uhDcOrd.setNameDept(st404.getDepartmentName());
		uhDcOrd.setCodeArea(st404.getInpatientAreaNo());
		uhDcOrd.setNameArea(st404.getInpatientAreaName());
		uhDcOrd.setBed(st404.getSickbedNo());
		uhDcOrd.setCodeOrd(st404.getOrdersCode());
		//uhDcOrd.setCodeOrdStatus("");
		if(st404.getVerifyTime() !=null){		
			uhDcOrd.setFlagChk(0);
		} else{
			uhDcOrd.setFlagChk(1);		
		}
		
		uhDcOrd.setCodeOrditem(st404.getTestProCode());
		uhDcOrd.setNameOrditem(st404.getTestProName());
		uhDcOrd.setCodePsnRec(st404.getInputPersonCode());
		uhDcOrd.setNamePsnRec(st404.getInputPersonName());
		uhDcOrd.setDateCreate(st404.getApplyTime());
		uhDcOrd.setDateBegin(st404.getApplyTime());
		uhDcOrd.setCodePsnPhy(st404.getApplyDoctorCode());
		uhDcOrd.setNamePsnPhy(st404.getApplyDoctorName());
		uhDcOrd.setCodeDetpPhy(st404.getImplementDepartmentCode());
		uhDcOrd.setNameDeptPhy(st404.getImplementDepartmentName());
		uhDcOrd.setDateChk(st404.getVerifyTime());
		uhDcOrd.setCodePsnChk(st404.getVerifierCode());
		uhDcOrd.setNamePsnChk(st404.getVerifierName());
		uhDcOrd.setCodePsnEx(st404.getImplementDepartmentCode());
		uhDcOrd.setNamePsnEx(st404.getImplementDepartmentName());
		uhDcOrd.setDateEnd(st404.getApplyTime());
		uhDcOrd.setCodePsnEnd(st404.getApplyDoctorCode());
		uhDcOrd.setNamePsnEnd(st404.getApplyDoctorName());
		String urgentLevelCode = st404.getUrgentLevelCode();
		if("true".equals(urgentLevelCode)){
			uhDcOrd.setFlagUrgent(0);			
		} else if("false".equals(urgentLevelCode)){
			uhDcOrd.setFlagUrgent(1);
		}
		
		if("D".equals(serviceType)){
			uhDcOrd.setFlagCancel(1);
		} else {
			uhDcOrd.setFlagCancel(0);
		}
		
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		return uhDcOrd;
	}

	private UhDcOrdTrans saveUhDcOrdTrans(ST404 st404,UhDcOrd uhDcOrd) {
		UhDcOrdTrans trans = new UhDcOrdTrans();
		trans.setPkDcord(uhDcOrd.getPkDcord());
		trans.setCodeGroup(st404.getGroupCode());
		trans.setCodeOrg(st404.getOrgCode());
		trans.setCodeOrd(st404.getOrdersCode());
		trans.setEmpi(st404.getEMPINo());
		trans.setCodePati(st404.getPidCode());
		trans.setPatiname(st404.getPatientName());
		trans.setCodeSex(st404.getPatientSexCode());
		trans.setNameSex(st404.getPatientSexName());
		trans.setBirthday(st404.getPatientBirthTime());
		trans.setAddrPre(st404.getPatientAddr());
		trans.setTelenoPre(st404.getPatientTel());
		trans.setCodeReq(st404.getApplicationCode());
		trans.setPvTime(Integer.parseInt(st404.getVisitTimes()));
		trans.setCodeDiag(st404.getBloodDiagnosisCode());
		trans.setNameDiag(st404.getBloodDiagnosisName());
		trans.setDescDiag(st404.getDiagnosisDescription());
		trans.setDiagDate(st404.getBloodDiagnosisTime());
		trans.setCodeBttype(st404.getBloodTransfusionNatureCode());
		trans.setNameBttype(st404.getBloodTransfusionNatureName());
		trans.setCodeBloodAbo(st404.getApplyABOCode());
		trans.setNameBloodAbo(st404.getApplyABOValue());
		trans.setCodeBloodRh(st404.getApplyRhCode());
		trans.setNameBloodRh(st404.getApplyRhValue());
		trans.setFlagLab(Integer.parseInt(st404.getTestCode()));
		trans.setFlagBthist(Integer.parseInt(st404.getTransfusionHisCode()));
		trans.setQuanBt(Integer.parseInt(st404.getDosage()));
		trans.setDateBpApp(st404.getBloodTransfusionTime());
		trans.setFlagPreghist(Integer.parseInt(st404.getPregnantHisCode()));
		trans.setFlagAllergy(Integer.parseInt(st404.getAllergyHisCode()));
		trans.setCodeBloodState(st404.getBloodTransfusionDemandCode());
		trans.setNameBloodState(st404.getBloodTransfusionDemandName());
		trans.setUsePurp(st404.getBloodGoal());
		trans.setBloodType(st404.getBloodTransfusionTypeName());
		trans.setCodeDeptReq(st404.getApplyDepartmentCode());
		trans.setNameDeptReq(st404.getApplyDepartmentName());
		trans.setCodePsnReq(st404.getApplyDoctorCode());
		trans.setNamePsnReq(st404.getApplyDoctorName());
		trans.setDateApply(st404.getVerifyTime());
		trans.setCreateTime(new Date());
		trans.setEditTime(new Date());
		return trans;
	}
}
