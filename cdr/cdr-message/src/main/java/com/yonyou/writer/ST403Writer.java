package com.yonyou.writer;

import java.io.UnsupportedEncodingException;

/**
 * 日志添加完成，整体过程整理完成
 */
 
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdOp;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST403.ST403;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcOrdOpService;
import com.yonyou.util.Constant;
import com.yonyou.util.ObjectUtils;

@Component(value = "ST403")
public class ST403Writer implements BaseProcessWriter<ST403> {
    private static Logger logger = LoggerFactory.getLogger("ST403Logger");

	@Autowired
	private OrderService orderService;
	@Autowired
	private UhDcOrdOpService uhDcOrdOpService;
	@Autowired
	private PatientVisitService patientVisitService;
	@Autowired
	private MipMsgLogService msgLogService;
	
	private String actionType;//执行状态：A：新增、U：更新 D：取消
	
	private UhDcMipMsgLog mipMsgLog;

	private String msgId;

	private String tables;
	
	@Override
	public boolean validation(ST403 t, Object reMsg) {
	 
		
		msgId = t.getMsgId();

		if (StringUtils.isEmpty(msgId)) {
			logger.error("ST403,msgId为空");
			return false;
		}

		mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
		actionType = t.getServiceType();

		if (ObjectUtils.isEmpty(t.getApplicationCode()) || ObjectUtils.isEmpty(t.getVisitNo())
				||ObjectUtils.isEmpty(t.getVisitTimes())|| ObjectUtils.isEmpty(t.getPidCode())) {
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));
			logger.error("ST403-{},患者信息获取失败，请检查xml格式", t.getMsgId());
			return false;
		}
		return true;

	}

	@Override
	public boolean checkPre(ST403 t) {
		 
		return true;
	}

	@Override
	public void businessWrite(ST403 t) {
 
		UhDcPv uhDcPv = patientVisitService.getUhDcPv(t.getPidCode(), t.getVisitNo(), t.getVisitTimes(),
				t.getPatientTypeCode(), t.getGroupCode(), t.getOrgCode());
		

    System.out.println(t.getPidCode()+"::"+ t.getVisitNo()+"::"+ t.getVisitTimes()+"::"+t.getPatientTypeCode()+"::"+ t.getGroupCode()+"::"+t.getOrgCode());
		

		if (ObjectUtils.isEmpty(uhDcPv)) {
			logger.info("st403没有找到就诊记录：就诊号pvcode:" + t.getVisitNo());
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此就诊信息", MessageStatus.DEPEND_NOT_EXIST));

			return;
		}
		//设置empi
		t.setEMPINo(uhDcPv.getEmpi());

		// 新增医嘱表和医嘱手术表
		if (Constant.getMsgActionAdd().equals(actionType)) {

			UhDcOrd transOrder = stTransformUhDcOrd(t);
			transOrder.setPkDcpv(uhDcPv.getPkDcpv());
			

			UhDcOrd saveOrder = orderService.saveOrder(transOrder);
			if (ObjectUtils.isNotEmpty(saveOrder)) {

				tables += "UhDcOrd";
				mipMsgLog.setBusinessTables(tables);
				logger.debug("消息入库uh_dc_ord（），医嘱号：" + t.getOrdersCode());
				msgLogService.saveMsgLog(
						CommonWriter.generateLog(mipMsgLog, "手术医嘱添加成功，codeOrd：" + t.getOrdersCode(), MessageStatus.OK));

				UhDcOrdOp uhDcOrdOp = stTransformUhDcOrdOp(t);
				uhDcOrdOp.setPkDcord(saveOrder.getPkDcord());
				

				UhDcOrdOp saveOrderOp = uhDcOrdOpService.saveOrderOp(uhDcOrdOp);

				if (ObjectUtils.isNotEmpty(saveOrderOp)) {
					tables += "UhDcOrdOP";
					mipMsgLog.setBusinessTables(tables);
					logger.debug("消息入库uh_dc_ord_op（），申请单号：" + t.getApplicationCode());
					msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
							"手术申请单添加成功，codeReq：" + t.getApplicationCode(), MessageStatus.OK));

				}

			}

		}else if(Constant.getMsgActionUpdate().equals(actionType)){
			// 更新医嘱表和医嘱手术表
			 

			UhDcOrd orderByVisitInfo = orderService.getUhDcOrderByVisitInfo(t.getOrdersCode(), t.getVisitNo(),
					t.getPatientTypeCode(), "O", t.getGroupCode(), t.getOrgCode());

			if (ObjectUtils.isEmpty(orderByVisitInfo)) {
				logger.info("st401没有找到该医嘱记录，医嘱号：" + t.getOrdersCode());
				msgLogService
						.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此医嘱信息", MessageStatus.DEPEND_NOT_EXIST));
				return;
			}

			UhDcOrd stTransformUhDcOrd = stTransformUhDcOrd(t);
			stTransformUhDcOrd.setPkDcord(orderByVisitInfo.getPkDcord());
			stTransformUhDcOrd.setCreateTime(orderByVisitInfo.getCreateTime());
			stTransformUhDcOrd.setPkDcpv(orderByVisitInfo.getPkDcpv());
			
			UhDcOrd saveOrder = orderService.saveOrder(stTransformUhDcOrd);
			
			if (ObjectUtils.isNotEmpty(saveOrder)) {

				tables += "UhDcOrd";
				mipMsgLog.setBusinessTables(tables);
				logger.debug("更新消息uh_dc_ord（），医嘱号：" + t.getOrdersCode());
				msgLogService.saveMsgLog(
						CommonWriter.generateLog(mipMsgLog, "手术医嘱更新成功，codeOrd：" + t.getOrdersCode(), MessageStatus.OK));

				UhDcOrdOp stTransformUhDcOrdOp = stTransformUhDcOrdOp(t);
				
				UhDcOrdOp orderOpByPkDcord = uhDcOrdOpService.getOrderOpByPkDcord(saveOrder.getPkDcord());

				stTransformUhDcOrdOp.setPkOpreq(orderOpByPkDcord.getPkOpreq());
				stTransformUhDcOrdOp.setPkDcord(orderOpByPkDcord.getPkDcord());
				stTransformUhDcOrdOp.setCreateTime(orderOpByPkDcord.getCreateTime());

				UhDcOrdOp saveOrderOp = uhDcOrdOpService.saveOrderOp(stTransformUhDcOrdOp);

				if (ObjectUtils.isNotEmpty(saveOrderOp)) {
					tables += "UhDcOrdOP";
					mipMsgLog.setBusinessTables(tables);
					logger.debug("消息更新uh_dc_ord_op（），申请单号：" + t.getApplicationCode());
					msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
							"手术申请单更新成功，codeReq：" + t.getApplicationCode(), MessageStatus.OK));

				}

			}
		 
		} else if ("D".equals(actionType)) {
			//取消，更新医嘱表

			UhDcOrd orderByNo = orderService.getUhDcOrderByVisitInfo(t.getOrdersCode(), t.getVisitNo(),
					t.getPatientTypeCode(), "O", t.getGroupCode(), t.getOrgCode());

			if (ObjectUtils.isNotEmpty(orderByNo)) {
				orderByNo.setFlagCancel(1);
				orderByNo.setBakCancel(t.getMemoInformation());
				orderByNo.setCodeCancelpesc(t.getApplyDoctorCode());
				orderByNo.setNameCancelpesc(t.getApplyDoctorName());

				orderByNo.setDateCancel(new Date());
				orderByNo.setEditTime(new Date());

				UhDcOrd uhDcOrd = orderService.saveOrder(orderByNo);

				if (ObjectUtils.isNotEmpty(uhDcOrd)) {

					tables += "UhDcOrd";
					mipMsgLog.setBusinessTables(tables);
					logger.debug("取消消息uh_dc_ord（），医嘱号：" + t.getOrdersCode());
					msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
							"手术医嘱取消成功，codeOrd：" + t.getOrdersCode(), MessageStatus.OK));

				}

			}
		}
	}
 
			 
				
 

	private UhDcOrd stTransformUhDcOrd(ST403 t) {
		UhDcOrd u = new UhDcOrd();
	 
		u.setEmpi(t.getEMPINo());
		u.setCodeGroup(t.getGroupCode());
		u.setCodeOrg(t.getOrgCode());
		u.setCodePati(t.getPidCode());
		u.setCodePvtype(t.getPatientTypeCode());
		u.setNamePvtype(t.getPatientTypeName());
		u.setPvcode(t.getVisitNo());
		u.setPatiname(t.getPatientName());
		u.setCodeSex(t.getPatientSexCode());
		u.setNameSex(t.getPatientSexName());
		u.setBirthday(t.getPatientBirthTime());
		u.setAddrPre(t.getPatientAddr());
		u.setTelenoPre(t.getPatientTel());
		u.setCodeDept(t.getDepartmentNo());
		u.setNameDept(t.getDepartmentName());
		u.setCodeArea(t.getInpatientAreaNo());
		u.setNameArea(t.getInpatientAreaName());
		u.setBed(t.getSickbedNo());
		u.setCodeOrd(t.getOrdersCode());
		//u.setCodeSrvtype("S"); 
		//u.setNameSrvtype("临时医嘱");
		u.setCodeSrvtype(Constant.getOrdTypeCodeS());  
		u.setNameSrvtype(Constant.getOrdTypeNameS()); 
		u.setCodeOrditemType("O");
		u.setNameOrditemType("手术");
		u.setCodeOrdStatus("0");
		u.setNameOrdStatus("开立");
		u.setCodeOrditem(t.getOperationProcedureCode());
		u.setNameOrditem(t.getOperationProcedureName());
		u.setNoteUsage(t.getOperationDescription());
		u.setCodePsnRec(t.getInputPersonCode());
		u.setNamePsnRec(t.getInputPersonName());
		u.setDateCreate(t.getApplyTime());
		u.setCodePsnPhy(t.getApplyDoctorCode());
		u.setNamePsnPhy(t.getApplyDoctorName());
		u.setCodeDetpPhy(t.getApplyDepartmentCode());
		u.setNameDeptPhy(t.getApplyDepartmentName());
		if(t.getVerifyTime()!=null){
			u.setFlagChk(0);

		}else{
			u.setFlagChk(1);
		}
		u.setDateChk(t.getVerifyTime());
		u.setCodePsnChk(t.getVerifierCode());
		u.setNamePsnChk(t.getVerifierName());
		u.setDateExPlan(t.getOperationStartTime());
		u.setCodePsnEx(t.getMainDoctorCode());
		u.setNamePsnEx(t.getMainDoctorName());
		u.setCodeDeptExec(t.getImplementDepartmentCode());
		u.setNameDeptExec(t.getImplementDepartmentName());
		
		if("true".equals(t.getUrgentLevelName())){
			u.setFlagUrgent(0);
		}else if("false".equals(t.getUrgentLevelName())){
			u.setFlagUrgent(1);
		}
		u.setCreateTime(new Date());
		u.setEditTime(new Date());
		u.setNoteOrd(t.getMemoInformation());
		u.setDataSource(t.getPatientTypeCode());
		u.setSourcePk(t.getOrdersCode());
		 u.setFlagDel(0);
		
		 
		return u;
	}
	
	private UhDcOrdOp stTransformUhDcOrdOp(ST403 t) {
		UhDcOrdOp o=new UhDcOrdOp();
		
		o.setEmpi(t.getEMPINo());
		o.setCodeGroup(t.getGroupName());
		o.setCodeOrg(t.getOrgName());
		o.setCodeOrd(t.getOrdersCode());
		o.setEmpi(t.getEMPINo());
		o.setCodePati(t.getPidCode());
		o.setPatiname(t.getPatientName());
		o.setCodeSex(t.getPatientSexCode());
		o.setNameSex(t.getPatientSexName());
		o.setBirthday(t.getPatientBirthTime());
		o.setAddrPre(t.getPatientAddr());
		o.setTelenoPre(t.getPatientTel());
		o.setCodeReq(t.getApplicationCode());
		o.setCodeDiagPre(t.getPreoperativeDiagnosisCode());
		o.setNameDiagPre(t.getPreoperativeDiagnosisName());
		o.setDescDiag(t.getDiagnosisDescription());
		o.setCodeOplevel(t.getOperationLevelCode());
		o.setNameOplevel(t.getOperationLevelName());
		o.setCodeOper(t.getOperationProcedureCode());
		o.setNameOper(t.getOperationProcedureName());
		o.setDescOper(t.getOperationDescription());
		o.setCodeAnae(t.getAnesthesiaMethodCode());
		o.setNameAnae(t.getAnesthesiaMethoName());
		o.setCodeAsepsis(t.getSterileLevelCode());
		o.setNameAsepsis(t.getSterileLevelName());
		o.setCodeBodypartOp(t.getOperationSiteCode());
		o.setNameBodypartOp(t.getOperationSiteName());
		o.setDateOpBegin(t.getOperationStartTime());
		o.setDateOpEnd(t.getOperationEndTime());
		o.setCodePhyMain(t.getMainDoctorCode());
		o.setNamePhyMain(t.getMainDoctorName());
		if("true".equals(t.getUrgentLevelName())){
			o.setFlagUrgent(1);
		}else if("false".equals(t.getUrgentLevelName())){
			o.setFlagUrgent(0);
		}
		
		o.setOpBodyCode(t.getOperationSiteCode());
		o.setOpBodyName(t.getOperationSiteName());
		o.setCodePsnReq(t.getApplyDoctorCode());
		o.setNamePsnReq(t.getApplyDoctorName());
		o.setDateReq(t.getApplyTime());
		o.setNote(t.getMemoInformation());
		o.setCreateTime(new Date());
		o.setEditTime(new Date());
		o.setDataSource(t.getPatientTypeCode());
		o.setSourcePk(t.getApplicationCode());
		o.setFlagDel(0);
		return o;
	}
}
