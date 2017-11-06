package com.yonyou.writer;

 /**
  * lcg修改第一版
  */
import java.util.Date;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdLis;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST402.CheckItem;
import com.yonyou.hl7adapter.model.ST402.PvInfo;
import com.yonyou.hl7adapter.model.ST402.RequestNote;
import com.yonyou.hl7adapter.model.ST402.ST402;
import com.yonyou.service.CheckApplicationService;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

@Component(value = "ST402")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST402Writer implements BaseProcessWriter<ST402> {

	private static Logger logger = LoggerFactory.getLogger("ST402Logger");

	@Autowired
	private CheckApplicationService checkApplicationService;
	@Autowired
	private PatientVisitService patientVisitService;
	@Autowired
	private OrderService orderService;

	@Autowired
	private MipMsgLogService msgLogService;

	private String actionType; // 执行状态：A：新增、U：更新 D：取消

	private UhDcMipMsgLog mipMsgLog;

	private String msgId;

	private String tables;
 

	@Override
	public boolean validation(ST402 st402, Object reMsg) {

   
		msgId = st402.getMsgId();

		if (StringUtils.isEmpty(msgId)) {
			logger.error("ST402,msgId为空");
			return false;
		}

		mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
		actionType = st402.getActionType();

		if (ObjectUtils.isEmpty(st402.getRequestNote()) || ObjectUtils.isEmpty(st402.getRequestNote().getPvInfo())
				|| st402.getRequestNote().getCheckItem().size() == 0) {
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));
			logger.error("ST402-{},患者信息获取失败，请检查xml格式", st402.getMsgId());
			return false;
		}
		return true;

	}

	@Override
	public boolean checkPre(ST402 st402) {
		return true;
	}

	@Override
	public void businessWrite(ST402 st402) {

		// 就诊号
		String pvCode = st402.getRequestNote().getPvInfo().getPvSerialNo();
		
		
		UhDcPv uhDcPv = patientVisitService.getUhDcPv(st402.getRequestNote().getPvInfo().getPatientId(), pvCode,
				st402.getRequestNote().getPvInfo().getPvTime(), st402.getRequestNote().getPvInfo().getPvTypeCode(),
				st402.getRequestNote().getPvInfo().getGroupCode(), st402.getRequestNote().getPvInfo().getHisOrgCode());
		if (ObjectUtils.isEmpty(uhDcPv)) {

			logger.info("st402没有找到就诊记录：就诊号pvcode:" + pvCode);
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此就诊信息", MessageStatus.DEPEND_NOT_EXIST));

			return;
		}

		st402.getRequestNote().getPvInfo().setEmpiId(uhDcPv.getEmpi());

		if (Constant.getMsgActionAdd().equals(actionType)) {

			for (CheckItem checkItem : st402.getRequestNote().getCheckItem()) {

				UhDcOrd uhDcOrd = convertUhDcOrd(st402);
				// 医嘱编码
				// String codeOrd = st402.getRequestNote().getRequestNoteNo() +
				// "_" + checkItem.getSerialNum(); 一个申请单号中有多个检查申请，用这个
				String codeOrd = st402.getRequestNote().getRequestNoteNo();
				uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
				uhDcOrd.setCodeOrd(codeOrd);
				uhDcOrd.setCodePres(codeOrd);
				uhDcOrd.setCodeOrditem(checkItem.getCheckItemCode());
				uhDcOrd.setNameOrditem(checkItem.getCheckItemName());

				UhDcOrd saveUhDcOrd = checkApplicationService.saveUhDcOrd(uhDcOrd);

				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					logger.debug("消息入库uh_dc_ord（），医嘱号：" + codeOrd);

					tables += "UhDcOrd";
					mipMsgLog.setBusinessTables(tables);
					msgLogService.saveMsgLog(
							CommonWriter.generateLog(mipMsgLog, "检验医嘱添加成功，codeOrd：" + codeOrd, MessageStatus.OK));

				}

				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {
					logger.debug("消息入库uh_dc_ord_lis（），申请单号：" + st402.getRequestNote().getRequestNoteNo());
					UhDcOrdLis uhDcOrdLis = convertUhDcOrdLis(st402);

					uhDcOrdLis.setPkDcord(uhDcOrd.getPkDcord());
					uhDcOrdLis.setCodeOrd(codeOrd);
					uhDcOrdLis.setCodeSrv(checkItem.getCheckItemCode());
					uhDcOrdLis.setNameSrv(checkItem.getCheckItemName());

					UhDcOrdLis saveUhDcOrdLis = checkApplicationService.saveUhDcOrdLis(uhDcOrdLis);

					if (ObjectUtils.isNotEmpty(saveUhDcOrdLis)) {
						tables += "UhDcOrdLis";
						mipMsgLog.setBusinessTables(tables);

						msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
								"检验申请添加成功，code_req：" + st402.getRequestNote().getRequestNoteNo(), MessageStatus.OK));

					}

				}

			}

		} else if (Constant.getMsgActionUpdate().equals(actionType)) {

			for (CheckItem checkItem : st402.getRequestNote().getCheckItem()) {

				// 医嘱编码
				//String codeOrd = st402.getRequestNote().getRequestNoteNo() + "_" + checkItem.getSerialNum();
				

				UhDcOrd uhDcOrd = orderService.getUhDcOrderByVisitInfo(st402.getRequestNote().getRequestNoteNo(), st402.getRequestNote().getPvInfo().getPvSerialNo(),
						 st402.getRequestNote().getPvInfo().getPvTypeCode(), st402.getRequestNote().getRequestNoteTypeCode(), st402.getRequestNote().getPvInfo().getGroupCode(), st402.getRequestNote().getPvInfo().getHisOrgCode());
			 
				
				String codeOrd = st402.getRequestNote().getRequestNoteNo();

			 

				if (ObjectUtils.isEmpty(uhDcOrd)) {
					logger.info("st402没有找到该医嘱记录，医嘱号：" + codeOrd);
					msgLogService
							.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此医嘱信息", MessageStatus.DEPEND_NOT_EXIST));
					return;
				}

				UhDcOrd uhDcOrdUpdate = convertUhDcOrd(st402);

				uhDcOrdUpdate.setPkDcord(uhDcOrd.getPkDcord());
				uhDcOrdUpdate.setPkDcpv(uhDcOrd.getPkDcpv());
				uhDcOrdUpdate.setCodeOrd(uhDcOrd.getCodeOrd());
				uhDcOrdUpdate.setCodePres(uhDcOrd.getCodeOrd());
				uhDcOrdUpdate.setCreateTime(uhDcOrd.getCreateTime());
				uhDcOrdUpdate.setCodeOrditem(checkItem.getCheckItemCode());
				uhDcOrdUpdate.setNameOrditem(checkItem.getCheckItemName());

				UhDcOrd saveUhDcOrd = checkApplicationService.saveUhDcOrd(uhDcOrdUpdate);

	
				
				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {
					tables += "UhDcOrd";
					 mipMsgLog.setBusinessTables(tables);
					logger.debug("更新消息uh_dc_ord（），医嘱号：" + codeOrd);
					msgLogService.saveMsgLog(
							CommonWriter.generateLog(mipMsgLog, "检验医嘱更新成功，codeOrd：" + codeOrd, MessageStatus.OK));

				}

				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					logger.debug("更新消息uh_dc_ord_lis（），医嘱主键：" + saveUhDcOrd.getPkDcord());

					UhDcOrdLis uhDcOrdLis = checkApplicationService.getUhDcOrdLis(saveUhDcOrd.getPkDcord());

					if (ObjectUtils.isEmpty(uhDcOrd)) {
						logger.info("st402没有找到该医嘱检验申请记录，医嘱主键：" + saveUhDcOrd.getPkDcord());
						msgLogService.saveMsgLog(
								CommonWriter.generateLog(mipMsgLog, "没有此医嘱检验信息", MessageStatus.DEPEND_NOT_EXIST));
						return;
					}

					UhDcOrdLis uhDcOrdLisUpdate = convertUhDcOrdLis(st402);
					uhDcOrdLisUpdate.setPkOrdlab(uhDcOrdLis.getPkOrdlab());
					uhDcOrdLisUpdate.setPkDcord(uhDcOrdLis.getPkDcord());
					uhDcOrdLisUpdate.setCodeOrd(uhDcOrdLis.getCodeOrd());
					uhDcOrdLisUpdate.setCodeSrv(checkItem.getCheckItemCode());
					uhDcOrdLisUpdate.setNameSrv(checkItem.getCheckItemName());
					uhDcOrdLisUpdate.setCreateTime(uhDcOrdLis.getCreateTime());

					UhDcOrdLis saveUhDcOrdLis = checkApplicationService.saveUhDcOrdLis(uhDcOrdLis);

					

					if (ObjectUtils.isNotEmpty(saveUhDcOrdLis)) {

						tables += "UhDcOrdLis";
						 mipMsgLog.setBusinessTables(tables);
						msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
								"检验申请更新成功，code_req：" + st402.getRequestNote().getRequestNoteNo(), MessageStatus.OK));

					}

				}

			}

		} else if (Constant.getMsgActionCancel().equals(actionType)) {

			for (CheckItem checkItem : st402.getRequestNote().getCheckItem()) {
				 
				// 医嘱编码
				//String codeOrd = st402.getRequestNote().getRequestNoteNo() + "_" + checkItem.getSerialNum();
				String codeOrd = st402.getRequestNote().getRequestNoteNo();
				UhDcOrd uhDcOrd = orderService.getUhDcOrderByVisitInfo(st402.getRequestNote().getRequestNoteNo(), st402.getRequestNote().getPvInfo().getPvSerialNo(),
						 st402.getRequestNote().getPvInfo().getPvTypeCode(), st402.getRequestNote().getRequestNoteTypeCode(), st402.getRequestNote().getPvInfo().getGroupCode(), st402.getRequestNote().getPvInfo().getHisOrgCode());

				if (ObjectUtils.isEmpty(uhDcOrd)) {
					logger.info("st402没有找到该医嘱记录，医嘱号：" + codeOrd);
					msgLogService
							.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此医嘱信息", MessageStatus.DEPEND_NOT_EXIST));
					return;
				}

				uhDcOrd.setFlagCancel(1);
				uhDcOrd.setCodeCancelpesc(st402.getRequestNote().getRequestDoctorCode());
				uhDcOrd.setNameCancelpesc(st402.getRequestNote().getRequestDoctorName());
				String canlDate=DateUtils.getDateStr2Str(st402.getRequestNote().getRequestTime());
		 
				uhDcOrd.setDateCancel(DateUtils.covertDateTime(canlDate));
			 
				uhDcOrd.setEditTime(new Date());

				UhDcOrd saveUhDcOrd = checkApplicationService.saveUhDcOrd(uhDcOrd);

			

				
				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					logger.debug("取消消息uh_dc_ord（），医嘱号：" + codeOrd);
					tables += "UhDcOrd";
					 mipMsgLog.setBusinessTables(tables);
					msgLogService.saveMsgLog(
							CommonWriter.generateLog(mipMsgLog, "检验医嘱取消成功，codeOrd：" + codeOrd, MessageStatus.OK));

				}

			}

		} else {
			logger.debug("ST402没有该交互类型，msgID:" + msgId);
			mipMsgLog.setBusinessTables(tables);
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NOT_SUPPORT_ACTION));
		}

	}

	private UhDcOrdLis convertUhDcOrdLis(ST402 st402) {

		UhDcOrdLis lis = new UhDcOrdLis();

		PvInfo pvInfo = st402.getRequestNote().getPvInfo();
		RequestNote requestNote = st402.getRequestNote();
	   
		lis.setCodeGroup(pvInfo.getGroupCode());
		lis.setCodeOrg(pvInfo.getHisOrgCode());

		lis.setEmpi(pvInfo.getEmpiId());
		lis.setCodePati(pvInfo.getEmpiId());
		lis.setPatiname(pvInfo.getName());
		lis.setCodeSex(pvInfo.getSexCode());
		lis.setNameSex(pvInfo.getSex());
		lis.setBirthday(pvInfo.getBirth());
		lis.setAddrPre(pvInfo.getAddress());
		lis.setTelenoPre(pvInfo.getContact());
		lis.setCodeReq(requestNote.getRequestNoteNo());
		lis.setCodeDiag(requestNote.getDiagnosisCode());
		lis.setNameDiag(requestNote.getDiagnosisName());
		lis.setDescDiag(requestNote.getSymptomName());
		lis.setDiagDate(requestNote.getDiagnosisTime());
		lis.setPurpLis(requestNote.getNowDiseaseHistoryCode());
		lis.setCodeDeptReq(requestNote.getRequestDeptCode());
		lis.setNameDeptReq(requestNote.getRequestDeptName());
		lis.setCodeEuType(requestNote.getRequestNoteTypeCode());
		lis.setNameEuType(requestNote.getRequestNoteTypeName());
	
		lis.setCodePsnReq(requestNote.getRequestDoctorCode());
		lis.setNamePsnReq(requestNote.getRequestDoctorName());
		lis.setCodeSamptype(requestNote.getSampleTypeCode());
		lis.setNameSamptype(requestNote.getSampleTypeName());
		lis.setDateLab(requestNote.getRequestTime());
		lis.setCodeCurryPsn(requestNote.getInspectionPersonId());
		lis.setNameCurryPsn(requestNote.getInspectionPersonName());
		lis.setDateCurry(requestNote.getInspectionTime());
		lis.setCodePsnRec(requestNote.getSampleReceivePersonId());
		lis.setNamePsnRec(requestNote.getSampleReceivePersonName());
		lis.setDateRec(requestNote.getSampleReceiveTime());
		String isUrgentValue = requestNote.getIsUrgentValue();
		if ("true".equals(isUrgentValue)) {
			lis.setFlagUrgent(0);
		} else {
			lis.setFlagUrgent(1);
		}
		lis.setCreateTime(new Date());
		lis.setEditTime(new Date());
		return lis;
	}

	private UhDcOrd convertUhDcOrd(ST402 st402) {
		UhDcOrd ord = new UhDcOrd();
		PvInfo pvInfo = st402.getRequestNote().getPvInfo();
		RequestNote requestNote = st402.getRequestNote();
		
		ord.setCodeGroup(pvInfo.getGroupCode());
		ord.setCodeOrg(pvInfo.getHisOrgCode());
	 
		ord.setEmpi(pvInfo.getEmpiId());
		ord.setCodePati(pvInfo.getPatientId());
		ord.setCodePvtype(pvInfo.getPvTypeCode());
		ord.setNamePvtype(pvInfo.getPvTypeName());
		ord.setPvcode(pvInfo.getPvSerialNo());
		ord.setPatiname(pvInfo.getName());
		ord.setCodeSex(pvInfo.getSexCode());
		ord.setNameSex(pvInfo.getSex());
		ord.setBirthday(DateUtils.getDateStr2Str(pvInfo.getBirth()));
		ord.setAddrPre(pvInfo.getAddress());
		ord.setTelenoPre(pvInfo.getContact());
		ord.setCodeDept(pvInfo.getDeptCode());
		ord.setNameDept(pvInfo.getDeptName());
		ord.setCodeArea(pvInfo.getLesionCode());
		ord.setNameArea(pvInfo.getLesionName());
		ord.setBed(pvInfo.getBedNo());
	    //
		ord.setCodeSrvtype(Constant.getOrdTypeCodeS());  
		ord.setNameSrvtype(Constant.getOrdTypeNameS());  
		
		ord.setCodeOrditemType(requestNote.getRequestNoteTypeCode());
		ord.setNameOrditemType(requestNote.getRequestNoteTypeName());

		ord.setNamePsnRec(requestNote.getEntryPersonName());
		ord.setDateCreate(requestNote.getExecDeptName());
		ord.setDateBegin(requestNote.getRequestTime());
		ord.setCodePsnPhy(requestNote.getRequestDoctorCode());
		ord.setNamePsnPhy(requestNote.getRequestDoctorName());
		ord.setCodeDetpPhy(requestNote.getRequestDeptCode());
		ord.setNameDeptPhy(requestNote.getRequestDeptName());

		if (requestNote.getEntryTime() != null) {
			ord.setFlagChk(0); // 存在确认时间就表示核对
		} else {
			ord.setFlagChk(1);
		}

		ord.setDateChk(requestNote.getEntryTime());
		ord.setCodePsnChk(requestNote.getConfirmPersonNo());
		ord.setNamePsnChk(requestNote.getConfirmPersonName());

		ord.setCodeDeptExec(requestNote.getExecDeptCode());
		ord.setNameDeptExec(requestNote.getExecDeptName());
		ord.setDateEnd(requestNote.getRequestTime());
		ord.setCodePsnEnd(requestNote.getRequestDoctorCode());
		ord.setNamePsnEnd(requestNote.getRequestDoctorName());
		String isUrgentValue = requestNote.getIsUrgentValue();

		if ("true".equals(isUrgentValue)) {
			ord.setFlagUrgent(0);
		} else if ("false".equals(isUrgentValue)) {
			ord.setFlagUrgent(1);
		}
		if (requestNote.getChargeStatus() != null) {
			ord.setKindFlag(Integer.parseInt(requestNote.getChargeStatus()));
		}

		String action = st402.getActionType();
		if (Constant.getMsgActionCancel().equals(action)) {
			ord.setFlagCancel(1); // 取消标志
		} else {
			ord.setFlagCancel(0);
		}
		ord.setFlagStopChk(0); // 默认核对
		ord.setCreateTime(new Date());
		ord.setEditTime(new Date());
		return ord;
	}
}
