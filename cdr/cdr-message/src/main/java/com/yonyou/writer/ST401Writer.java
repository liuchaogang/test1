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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdRis;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST401.CheckItem;
import com.yonyou.hl7adapter.model.ST401.PvInfo;
import com.yonyou.hl7adapter.model.ST401.RequestNote;
import com.yonyou.hl7adapter.model.ST401.ST401;
import com.yonyou.service.CheckApplicationService;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

@Component(value = "ST401")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ST401Writer implements BaseProcessWriter<ST401>{

    private static Logger logger = LoggerFactory.getLogger("ST401Logger");

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
	public boolean validation(ST401 st401, Object reMsg) {
		
		msgId = st401.getMsgId();

		if (StringUtils.isEmpty(msgId)) {
			logger.error("st401,msgId为空");
			return false;
		}
	       
		mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
		actionType = st401.getActionType();

		if (ObjectUtils.isEmpty(st401.getRequestNote()) || ObjectUtils.isEmpty(st401.getRequestNote().getPvInfo())
				|| st401.getRequestNote().getCheckItem().size() == 0) {
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));
			logger.error("st401-{},患者信息获取失败，请检查xml格式", st401.getMsgId());
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPre(ST401 st401) {
		return true;
	}

	@Override
	@Transactional
	public void businessWrite(ST401 st401) {
		
 
		// 就诊号
		String pvCode = st401.getRequestNote().getPvInfo().getPvSerialNo();
		 
		UhDcPv uhDcPv = patientVisitService.getUhDcPv(st401.getRequestNote().getPvInfo().getPatientId(), pvCode,
				st401.getRequestNote().getPvInfo().getPvTime(), st401.getRequestNote().getPvInfo().getPvTypeCode(),
				st401.getRequestNote().getPvInfo().getGroupCode(), st401.getRequestNote().getPvInfo().getHisOrgCode());
		
		System.out.println(st401.getRequestNote().getPvInfo().getPatientId()+"::"+ pvCode+"::"+ st401.getRequestNote().getPvInfo().getPvTime()+"::"+  st401.getRequestNote().getPvInfo().getPvTypeCode()+"::"+st401.getRequestNote().getPvInfo().getGroupCode()+"::"+  st401.getRequestNote().getPvInfo().getHisOrgCode());		
		if (ObjectUtils.isEmpty(uhDcPv)) {

			logger.info("st401没有找到就诊记录：就诊号pvcode:" + pvCode);
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此就诊信息", MessageStatus.DEPEND_NOT_EXIST));

			return;
		}
		
        //对st401对象设置empi值
		st401.getRequestNote().getPvInfo().setEmpiId(uhDcPv.getEmpi());
		

		if (Constant.getMsgActionAdd().equals(actionType)) {

			for (CheckItem checkItem : st401.getRequestNote().getCheckItem()) {

				UhDcOrd uhDcOrd = convertUhDcOrd(st401);
				// 医嘱编码
				//String codeOrd = st401.getRequestNote().getRequestNoteNo() + "_" + checkItem.getSerialNum(); 一个申请单号中有多个检查申请，用这个
				String codeOrd = st401.getRequestNote().getRequestNoteNo();
				uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
				uhDcOrd.setCodeOrd(codeOrd);
				uhDcOrd.setCodePres(codeOrd);
				uhDcOrd.setCodeOrditem(checkItem.getCheckItemCode());
				uhDcOrd.setNameOrditem(checkItem.getCheckItemName());
				
			 

				UhDcOrd saveUhDcOrd = checkApplicationService.saveUhDcOrd(uhDcOrd);

				logger.debug("消息入库uh_dc_ord（），医嘱号：" + codeOrd);

				
				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					tables += "UhDcOrd";
					 mipMsgLog.setBusinessTables(tables);
					msgLogService.saveMsgLog(
							CommonWriter.generateLog(mipMsgLog, "检查医嘱添加成功，codeOrd：" + codeOrd, MessageStatus.OK));

				}

				if (saveUhDcOrd != null) {
					logger.debug("消息入库uh_dc_ord_lis（），申请单号：" + st401.getRequestNote().getRequestNoteNo());
					UhDcOrdRis uhDcOrdRis = convertUhDcOrdRis(st401);

					uhDcOrdRis.setPkDcord(uhDcOrd.getPkDcord());
					uhDcOrdRis.setCodeOrd(codeOrd);
					uhDcOrdRis.setCodeEuType(checkItem.getCheckItemCode());
					uhDcOrdRis.setNameEuType(checkItem.getCheckItemName());
					UhDcOrdRis saveuhDcOrdRis = checkApplicationService.saveUhDcOrdRis(uhDcOrdRis);

					tables += "uhDcOrdRis";
					 mipMsgLog.setBusinessTables(tables);
					if (ObjectUtils.isNotEmpty(saveuhDcOrdRis)) {

						msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
								"检查申请添加成功，code_req：" + st401.getRequestNote().getRequestNoteNo(), MessageStatus.OK));

					}

				}

			}

		} else if (Constant.getMsgActionUpdate().equals(actionType)) {

			for (CheckItem checkItem : st401.getRequestNote().getCheckItem()) {

				// 医嘱编码
				//String codeOrd = st401.getRequestNote().getRequestNoteNo() + "_" + checkItem.getSerialNum();
				String codeOrd = st401.getRequestNote().getRequestNoteNo(); 

				UhDcOrd uhDcOrd = orderService.getUhDcOrderByVisitInfo(st401.getRequestNote().getRequestNoteNo(), st401.getRequestNote().getPvInfo().getPvSerialNo(),
						 st401.getRequestNote().getPvInfo().getPvTypeCode(), st401.getRequestNote().getRequestNoteTypeCode(), st401.getRequestNote().getPvInfo().getGroupCode(), st401.getRequestNote().getPvInfo().getHisOrgCode());
			 
				if (ObjectUtils.isEmpty(uhDcOrd)) {
					logger.info("st401没有找到该医嘱记录，医嘱号：" + codeOrd);
					msgLogService
							.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此医嘱信息", MessageStatus.DEPEND_NOT_EXIST));
					return;
				}

				UhDcOrd uhDcOrdUpdate = convertUhDcOrd(st401);

				uhDcOrdUpdate.setPkDcord(uhDcOrd.getPkDcord());
				uhDcOrdUpdate.setPkDcpv(uhDcOrd.getPkDcpv());
				uhDcOrdUpdate.setCodeOrd(uhDcOrd.getCodeOrd());
				uhDcOrdUpdate.setCodePres(uhDcOrd.getCodeOrd());
				uhDcOrdUpdate.setCreateTime(uhDcOrd.getCreateTime());

				UhDcOrd saveUhDcOrd = checkApplicationService.saveUhDcOrd(uhDcOrdUpdate);

				logger.debug("更新消息uh_dc_ord（），医嘱号：" + codeOrd);

				tables += "UhDcOrd";
				 mipMsgLog.setBusinessTables(tables);
				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					msgLogService.saveMsgLog(
							CommonWriter.generateLog(mipMsgLog, "检查医嘱更新成功，codeOrd：" + codeOrd, MessageStatus.OK));

				}

				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					logger.debug("更新消息uh_dc_ord_lis（），医嘱主键：" + saveUhDcOrd.getPkDcord());

					UhDcOrdRis uhDcOrdRis = checkApplicationService.getUhDcOrdRis(saveUhDcOrd.getPkDcord());

					if (ObjectUtils.isEmpty(uhDcOrd)) {
						logger.info("st401没有找到该医嘱检查记录，医嘱主键：" + saveUhDcOrd.getPkDcord());
						msgLogService.saveMsgLog(
								CommonWriter.generateLog(mipMsgLog, "没有此医嘱检查信息", MessageStatus.DEPEND_NOT_EXIST));
						return;
					}

					UhDcOrdRis uhDcOrdRisUpdate = convertUhDcOrdRis(st401);
					//uhDcOrdRisUpdate.setPkOrdlab(uhDcOrdRis.getPkOrdlab());
					uhDcOrdRisUpdate.setPkDcord(uhDcOrdRis.getPkDcord());
					uhDcOrdRisUpdate.setCodeOrd(uhDcOrdRis.getCodeOrd());
				
					uhDcOrdRisUpdate.setCreateTime(uhDcOrdRis.getCreateTime());
					uhDcOrdRisUpdate.setCodeEuBody(checkItem.getCheckItemPartCode());
					uhDcOrdRisUpdate.setNameEuBody(checkItem.getCheckItemPartName());
					uhDcOrdRisUpdate.setCodeSrv(checkItem.getCheckItemCode());
					uhDcOrdRisUpdate.setNameSrv(checkItem.getCheckItemName());

					UhDcOrdRis saveuhDcOrdRis = checkApplicationService.saveUhDcOrdRis(uhDcOrdRis);

					tables += "uhDcOrdRis";
					 mipMsgLog.setBusinessTables(tables);
					if (ObjectUtils.isNotEmpty(saveuhDcOrdRis)) {

						msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog,
								"检查申请更新成功，code_req：" + st401.getRequestNote().getRequestNoteNo(), MessageStatus.OK));

					}

				}

			}

		} else if (Constant.getMsgActionDel().equals(actionType)) {

			for (CheckItem checkItem : st401.getRequestNote().getCheckItem()) {
				logger.debug("取消消息uh_dc_ord（），医嘱号：" + checkItem.getOrdNo());
				// 医嘱编码
				//String codeOrd = st401.getRequestNote().getRequestNoteNo() + "_" + checkItem.getSerialNum();
				String codeOrd = st401.getRequestNote().getRequestNoteNo();
				
				UhDcOrd uhDcOrd = orderService.getUhDcOrderByVisitInfo(st401.getRequestNote().getRequestNoteNo(), st401.getRequestNote().getPvInfo().getPvSerialNo(),
						 st401.getRequestNote().getPvInfo().getPvTypeCode(), st401.getRequestNote().getRequestNoteTypeCode(), st401.getRequestNote().getPvInfo().getGroupCode(), st401.getRequestNote().getPvInfo().getHisOrgCode());
			 
		 

				if (ObjectUtils.isEmpty(uhDcOrd)) {
					logger.info("st401没有找到该医嘱记录，医嘱号：" + codeOrd);
					msgLogService
							.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此医嘱信息", MessageStatus.DEPEND_NOT_EXIST));
					return;
				}

				uhDcOrd.setFlagCancel(1);
				uhDcOrd.setCodeCancelpesc(st401.getRequestNote().getRequestDoctorCode());
				uhDcOrd.setNameCancelpesc(st401.getRequestNote().getRequestDoctorName());
				String canlDate=DateUtils.getDateStr2Str(st401.getRequestNote().getRequestTime());
		 
				uhDcOrd.setDateCancel(DateUtils.covertDateTime(canlDate));
			 
				uhDcOrd.setEditTime(new Date());

				UhDcOrd saveUhDcOrd = checkApplicationService.saveUhDcOrd(uhDcOrd);

				logger.debug("取消消息uh_dc_ord（），医嘱号：" + codeOrd);

				tables += "UhDcOrd";
				 mipMsgLog.setBusinessTables(tables);
				if (ObjectUtils.isNotEmpty(saveUhDcOrd)) {

					msgLogService.saveMsgLog(
							CommonWriter.generateLog(mipMsgLog, "检查医嘱取消成功，codeOrd：" + codeOrd, MessageStatus.OK));

				}

			}

		} else {
			logger.debug("ST402没有该交互类型，msgID:" + msgId);
			mipMsgLog.setBusinessTables(tables);
			msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NOT_SUPPORT_ACTION));
		}
	}
		
		
		
		
		
		
		
		
		
	 
	private UhDcOrdRis convertUhDcOrdRis(ST401 st401) {
		UhDcOrdRis ris = new UhDcOrdRis();
	 
		PvInfo pvInfo = st401.getRequestNote().getPvInfo();
		RequestNote requestNote = st401.getRequestNote();
		ris.setCodeGroup(pvInfo.getGroupCode());
		ris.setCodeOrg(pvInfo.getHisOrgCode());
	
 
		ris.setCodeEuType(requestNote.getRequestNoteTypeCode());
		ris.setNameEuType(requestNote.getRequestNoteTypeName());
	 
		ris.setEmpi(pvInfo.getEmpiId());
		ris.setCodePati(pvInfo.getPatientId());
		ris.setPatiname(pvInfo.getName());
		ris.setCodeSex(pvInfo.getSexCode());
		ris.setNameSex(pvInfo.getSex());
		ris.setBirthday(DateUtils.getDateStr2Str(pvInfo.getBirth()));
		ris.setAddrPre(pvInfo.getAddress());
		ris.setTelenoPre(pvInfo.getContact());
		ris.setCodeReq(requestNote.getRequestNoteNo());

		ris.setCodeOrgReq(pvInfo.getGroupCode());   // 默认医院编码
		ris.setNameOrgReq(pvInfo.getGroupName());   // 默认医院名称
		
		ris.setCodeDeptReq(requestNote.getRequestDeptCode());
		ris.setNameDeptReq(requestNote.getRequestDeptName());
		ris.setCodePsnReq(requestNote.getRequestDoctorCode());
		ris.setNamePsnReq(requestNote.getRequestDoctorName());
		ris.setDateLab(DateUtils.getDateStr2Str(requestNote.getRequestTime()));
		ris.setDescIllness(requestNote.getDiseaseDesc());
		ris.setCodeDiag(requestNote.getSymptomCode());
		ris.setNameDiag(requestNote.getSymptomName());
		ris.setDescDiag(requestNote.getSymptomDesc());

		ris.setDiagDate(DateUtils.getDateStr2Str(requestNote.getDiagnosisTime()));
		ris.setDiseasePre(requestNote.getNowDiseaseHistoryName());
		
		ris.setPurpRis(requestNote.getCheckGoal());
		

		// ris.setNote("");  备注
		ris.setCreateTime(new Date());
		ris.setEditTime(new Date());
		return ris;
	}
//ST401转换成UhDcOrd
	private UhDcOrd convertUhDcOrd(ST401 st401) {
 
		UhDcOrd uhDcOrd = new UhDcOrd();
	 
		PvInfo pvInfo = st401.getRequestNote().getPvInfo();
		RequestNote requestNote = st401.getRequestNote();
 
		uhDcOrd.setCodeGroup(pvInfo.getGroupCode());
		uhDcOrd.setCodeOrg(pvInfo.getHisOrgCode());
	 
		uhDcOrd.setEmpi(pvInfo.getEmpiId());
		uhDcOrd.setCodePati(pvInfo.getPatientId());
		uhDcOrd.setCodePvtype(pvInfo.getPvTypeCode());
		uhDcOrd.setNamePvtype(pvInfo.getPvTypeName());
		uhDcOrd.setPvcode(pvInfo.getPvSerialNo());
		uhDcOrd.setPatiname(pvInfo.getName());
		uhDcOrd.setCodeSex(pvInfo.getSexCode());
		uhDcOrd.setNameSex(pvInfo.getSex());
		uhDcOrd.setBirthday(DateUtils.getDateStr2Str(pvInfo.getBirth()));
		uhDcOrd.setAddrPre(pvInfo.getAddress());
		uhDcOrd.setTelenoPre(pvInfo.getContact());
		uhDcOrd.setCodeDept(pvInfo.getDeptCode());
		uhDcOrd.setNameDept(pvInfo.getDeptName());
		uhDcOrd.setCodeArea(pvInfo.getLesionCode());
		uhDcOrd.setNameArea(pvInfo.getLesionName());
		uhDcOrd.setBed(pvInfo.getBedNo());	
		
	 
		uhDcOrd.setCodeSrvtype(Constant.getOrdTypeCodeS());  
		uhDcOrd.setNameSrvtype(Constant.getOrdTypeNameS()); 
		uhDcOrd.setCodeOrditemType(requestNote.getRequestNoteTypeCode());
		uhDcOrd.setNameOrditemType(requestNote.getRequestNoteTypeName());
		uhDcOrd.setCodeOrdStatus("0");
		uhDcOrd.setNameOrdStatus("开立");
		uhDcOrd.setCodePsnRec(requestNote.getEntryPersonNo());
		uhDcOrd.setNamePsnRec(requestNote.getEntryPersonName());
		
		uhDcOrd.setDateCreate(DateUtils.getDateStr2Str(requestNote.getRequestTime()));
		uhDcOrd.setDateBegin(DateUtils.getDateStr2Str(requestNote.getRequestTime()));
		uhDcOrd.setCodePsnPhy(requestNote.getRequestDoctorCode());
		uhDcOrd.setNamePsnPhy(requestNote.getRequestDoctorName());
		uhDcOrd.setCodeDetpPhy(requestNote.getRequestDeptCode());
		uhDcOrd.setNameDeptPhy(requestNote.getRequestDeptName());
		String entryTime = requestNote.getEntryTime();
		if(!StringUtils.isEmpty(entryTime)){			
			uhDcOrd.setFlagChk(0);  // 存在确认时间就表示核对
		} else {
			uhDcOrd.setFlagChk(1);
		}
		uhDcOrd.setDateChk(DateUtils.getDateStr2Str(requestNote.getEntryTime()));
		uhDcOrd.setCodePsnChk(requestNote.getConfirmPersonNo());
		uhDcOrd.setNamePsnChk(requestNote.getConfirmPersonName());
		
		uhDcOrd.setCodeDeptExec(requestNote.getExecDeptCode());
		uhDcOrd.setNameDeptExec(requestNote.getExecDeptName());
		uhDcOrd.setDateEnd(DateUtils.getDateStr2Str(requestNote.getRequestTime()));
		uhDcOrd.setCodePsnEnd(requestNote.getRequestDoctorCode());
		uhDcOrd.setNamePsnEnd(requestNote.getRequestDoctorName());
		uhDcOrd.setFlagStopChk(0);   // 默认核对
		if(requestNote.getChargeStatus()!=null){
			uhDcOrd.setKindFlag(Integer.parseInt(requestNote.getChargeStatus()));
		}
		
		// 取消标记
		if(Constant.getMsgActionCancel().equals(actionType)){
			uhDcOrd.setFlagCancel(1);
		} else{
			uhDcOrd.setFlagCancel(0);
		}
		
		String isUrgentValue = requestNote.getIsUrgentValue();
		if("true".equals(isUrgentValue)){
			uhDcOrd.setFlagUrgent(0);
		} else{
			uhDcOrd.setFlagUrgent(1);
		}
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		
		return uhDcOrd;
	}
}
