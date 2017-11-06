package com.yonyou.writer;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdPacsRecord;
import com.yonyou.entity.UhDcOrdRecord;
import com.yonyou.entity.UhDcOrdRis;
import com.yonyou.hl7adapter.model.SD006.SD006;
import com.yonyou.service.CheckApplicationService;
import com.yonyou.service.OrderService;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

@Component(value = "SD006")
public class SD006Writer implements BaseProcessWriter<SD006>{

	private static Logger logger = LoggerFactory.getLogger("SD006Logger");
	
 
	
	@Autowired
    private CheckApplicationService checkApplicationService;
	@Autowired
	private OrderService orderService;
	
	private String actionType; 
	
	public boolean validation(SD006 sd006, Object reMsg) {

		if (StringUtils.isEmpty(sd006.getActionType())) {
			reMsg = "CDA文档版本号不能为空";
			return false;
		}
		if (StringUtils.isEmpty(sd006.getDocumentNo())) {
			reMsg = "CDA文档流水号（报告号）不能为空";
			return false;
		}
		actionType = sd006.getActionType();
		return true;
	}

	public boolean checkPre(SD006 sd006) {
		return true;
	}
 
	public void businessWrite(SD006 sd006) {
		// 获取医嘱号
		String codrOrd = null;
		if (ObjectUtils.isNotEmpty(sd006.getPatient())) {
			codrOrd = sd006.getPatient().geteRequestId();
		}

		// 判断是新增还是修改
		if (Constant.getCDAVersionAdd().equals(actionType)) {

			// 根据医嘱号获取相应的医嘱
			UhDcOrd uhDcOrd = orderService.getOrderByNo(codrOrd);
			UhDcOrdRis uhDcOrdRis = checkApplicationService.getOrderRisByCordOrd(codrOrd);

			if (ObjectUtils.isEmpty(uhDcOrd) || ObjectUtils.isEmpty(uhDcOrdRis)) {
				logger.error("该报告对应的申请单不存在，codeOrd:{}", codrOrd);
			} else {
				UhDcOrdRecord record = convertUhDcOrdRecord(sd006);
				//检查报告里信息不全从检查医嘱里查找 
				record.setPkDcord(uhDcOrd.getPkDcord());
				record.setPkDcpv(uhDcOrd.getPkDcord());
				record.setPvcode(uhDcOrd.getPvcode());
				record.setEmpi(uhDcOrd.getEmpi());
				record.setCodePati(uhDcOrd.getCodePati());
				record.setBirthday(uhDcOrd.getBirthday());
				record.setAddrPre(uhDcOrd.getAddrPre());
				record.setTelenoPre(uhDcOrd.getTelenoPre());
			 
				record.setCodeRepType(uhDcOrdRis.getCodeEuType());
				record.setNameRepType(uhDcOrdRis.getNameEuType());
				record.setCodeEuType(uhDcOrdRis.getCodeEuType());
				record.setNameEuType(uhDcOrdRis.getNameEuType());
				record.setCodeEuItem(uhDcOrdRis.getCodeSrv());
				record.setNameEuItem(uhDcOrdRis.getNameSrv());
				record.setCodePart(uhDcOrdRis.getCodeEuBody());
				record.setNamePart(uhDcOrdRis.getNameEuBody());
				
				UhDcOrdRecord saveUhDcOrdRecord = checkApplicationService
						.saveUhDcOrdRecord(record);
				if (ObjectUtils.isNotEmpty(saveUhDcOrdRecord)) {
					logger.debug("消息入库uh_dc_ord_record（），医嘱号：" + codrOrd);
					UhDcOrdPacsRecord converUhDcOrdPacsRecord = converUhDcOrdPacsRecord(sd006);
					converUhDcOrdPacsRecord.setPkOrdRecord(saveUhDcOrdRecord.getPkOrdRecord());

					UhDcOrdPacsRecord pacsRecord = checkApplicationService
							.saveuhDcOrdPacsRecord(converUhDcOrdPacsRecord);
					if (ObjectUtils.isNotEmpty(pacsRecord)) {
						logger.debug("消息入库uh_dc_ord_pacs_record（），报告单号：" + pacsRecord.getCodeRep());
					}

				}

			}

		} else if (Constant.getCDAVersionModify().equals(actionType)) {
			// 修改
			
			//UhDcOrdRecord uhDcOrdRecordByCodeOrd = checkApplicationService.getUhDcOrdRecordByCodeOrd(codrOrd);
			if (ObjectUtils.isNotEmpty(sd006.getPatient())&&ObjectUtils.isNotEmpty(sd006.getPvOrgInfo())) {
				 
			
			UhDcOrdRecord uhDcOrdRecordByCodeOrd = checkApplicationService.getUhDcOrdRecord(sd006.getPatient().geteRequestId(),
					sd006.getPatient().getPatientId(), sd006.getPvOrgInfo().getPvSerialNum(), sd006.getPatient().getPatientTypeCode(),
					Constant.getGroupCode(), Constant.getOrgCode());
			
			if (ObjectUtils.isEmpty(uhDcOrdRecordByCodeOrd)) {
				logger.error("该报告不存在，codeOrd:{}", codrOrd);
			} else {
				UhDcOrdRecord record = convertUhDcOrdRecord(sd006);
				//检查报告里信息不全从原来的报告里获取
				record.setPkOrdRecord(uhDcOrdRecordByCodeOrd.getPkOrdRecord());
				record.setPkDcord(uhDcOrdRecordByCodeOrd.getPkDcord());
				record.setPkDcpv(uhDcOrdRecordByCodeOrd.getPkDcord());
				record.setPvcode(uhDcOrdRecordByCodeOrd.getPvcode());
				record.setEmpi(uhDcOrdRecordByCodeOrd.getEmpi());
				record.setCodePati(uhDcOrdRecordByCodeOrd.getCodePati());
				record.setBirthday(uhDcOrdRecordByCodeOrd.getBirthday());
				record.setAddrPre(uhDcOrdRecordByCodeOrd.getAddrPre());
				record.setTelenoPre(uhDcOrdRecordByCodeOrd.getTelenoPre());
				record.setCodeRepType(uhDcOrdRecordByCodeOrd.getCodeRepType());
				record.setNameRepType(uhDcOrdRecordByCodeOrd.getNameRepType());
				record.setCodeEuType(uhDcOrdRecordByCodeOrd.getCodeEuType());
				record.setNameEuType(uhDcOrdRecordByCodeOrd.getNameEuType());
				record.setCodeEuItem(uhDcOrdRecordByCodeOrd.getCodeEuItem());
				record.setNameEuItem(uhDcOrdRecordByCodeOrd.getNameEuItem());
				record.setCodePart(uhDcOrdRecordByCodeOrd.getCodePart());
				record.setNamePart(uhDcOrdRecordByCodeOrd.getNamePart());
				record.setCreateTime(uhDcOrdRecordByCodeOrd.getCreateTime());
				
				
				UhDcOrdRecord saveUhDcOrdRecord = checkApplicationService
						.saveUhDcOrdRecord(record);
				if (ObjectUtils.isNotEmpty(saveUhDcOrdRecord)) {
					logger.debug("消息更新入库uh_dc_ord_record（），医嘱号：" + codrOrd);
					
					UhDcOrdPacsRecord ordPacsRecord = checkApplicationService.getuhDcOrdPacsRecordByPkOrdRecord(saveUhDcOrdRecord.getPkOrdRecord());
					UhDcOrdPacsRecord converUhDcOrdPacsRecord = converUhDcOrdPacsRecord(sd006);
					converUhDcOrdPacsRecord.setPkOrdRecord(saveUhDcOrdRecord.getPkOrdRecord());
					converUhDcOrdPacsRecord.setPkPacs(ordPacsRecord.getPkPacs());
					converUhDcOrdPacsRecord.setCreateTime(ordPacsRecord.getCreateTime());

					UhDcOrdPacsRecord pacsRecord = checkApplicationService
							.saveuhDcOrdPacsRecord(converUhDcOrdPacsRecord);
					if (ObjectUtils.isNotEmpty(pacsRecord)) {
						logger.debug("消息更新uh_dc_ord_pacs_record（），报告单号：" + pacsRecord.getCodeRep());
					}

				}

			 
			}
			}
		} else {
			logger.error("不支持的操作类型：{}", actionType);
		}

	}
	
	
/*	if("0".equals(actionType)){
		
		logger.debug("消息入库uh_dc_ord_record（），医嘱号：" + "");
		UhDcOrdRecord record = saveUhDcOrdRecord(sd006);
		checkApplicationService.saveUhDcOrdRecord(record);
		
	} else if("1".equals(actionType)){
		logger.debug("更新消息uh_dc_ord_record（），医嘱号：" + "");
		
	}*/
	
	
	
	private UhDcOrdRecord  convertUhDcOrdRecord(SD006 sd006) {
		UhDcOrdRecord record = new UhDcOrdRecord();
		
		
		record.setCodeGroup(Constant.getGroupCode());
		record.setCodeOrg(Constant.getOrgCode());
		if(ObjectUtils.isNotEmpty(sd006.getPatient())){
			record.setCodePvtype(sd006.getPatient().getPatientTypeCode());
			record.setNamePvtype(sd006.getPatient().getPatientTypeName());
			record.setCodeOrd(sd006.getPatient().geteRequestId());
			record.setPatiname(sd006.getPatient().getName());
			record.setCodeSex(sd006.getPatient().getSexCode());
			record.setNameSex(sd006.getPatient().getSex());
			record.setAge(sd006.getPatient().getAge());
			
		}
		

		if(ObjectUtils.isNotEmpty(sd006.getPvOrgInfo())){
			record.setCodeDept(sd006.getPvOrgInfo().getDeptCode());
			record.setNameDept(sd006.getPvOrgInfo().getDeptName());
			record.setCodeArea(sd006.getPvOrgInfo().getLesionCode());
			record.setNameArea(sd006.getPvOrgInfo().getLesionName());
			record.setBed(sd006.getPvOrgInfo().getBed());
			record.setPkDcordrisreq(sd006.getPatient().geteRequestId());
			record.setCodeReq(sd006.getPatient().geteRequestId());
			record.setCodeRep(sd006.getPatient().getCheckReportId());
			
		}
		
		if(ObjectUtils.isNotEmpty(sd006.getDocumentBaseInfo())){
	         record.setCodeEuDep(sd006.getDocumentBaseInfo().getCheckOrgCode());
	         record.setNameEuDep(sd006.getDocumentBaseInfo().getCheckOrgName());
	         record.setCodeEuPsnPis(sd006.getDocumentBaseInfo().getCheckPhysicianId());
	         record.setNameEuPsnPis(sd006.getDocumentBaseInfo().getCheckPhysicianName());
	         
	 		record.setCodePsnRep(sd006.getDocumentBaseInfo().getReportDoctor().get(0).getAssignedPersonCode());
			record.setNamePsnRep(sd006.getDocumentBaseInfo().getReportDoctor().get(0).getAssignedPersonName());
			record.setDateRep(DateUtils.getDateStr2Str(sd006.getDocumentBaseInfo().getReportDoctor().get(0).getReportTime()));
		 
			record.setCodePsnCheck(sd006.getDocumentBaseInfo().getReviewPhysicianId());
			record.setNamePsnCheck(sd006.getDocumentBaseInfo().getReviewPhysicianName());
			record.setDateCheck(DateUtils.getDateStr2Str(sd006.getDocumentBaseInfo().getLegalAuthenticatorTime()));
		}
		
		if(ObjectUtils.isNotEmpty(sd006.getDocumentBody())){
	 
	         record.setDateRis(DateUtils.getDateStr2Str(sd006.getDocumentBody().getCheckItemTime()));
			
		}
		
        
		record.setCreateTime(new Date());
		record.setEditTime(new Date());
		record.setFlagDel(0);

		
		return record;
	}
	
	
	 
	
	private UhDcOrdPacsRecord converUhDcOrdPacsRecord(SD006 sd006){
		
		UhDcOrdPacsRecord uhDcOrdPacsRecord=new UhDcOrdPacsRecord();
		uhDcOrdPacsRecord.setCodeGroup(Constant.getGroupCode());
		uhDcOrdPacsRecord.setCodeOrg(Constant.getOrgCode());
		
		
		if(ObjectUtils.isNotEmpty(sd006.getPvOrgInfo())){
			uhDcOrdPacsRecord.setCodeRep(sd006.getPatient().getCheckReportId());
			uhDcOrdPacsRecord.setSourcePk(sd006.getPatient().getCheckReportId());
			
		}
		
		if(ObjectUtils.isNotEmpty(sd006.getDocumentBaseInfo())){

			uhDcOrdPacsRecord.setDataSource(sd006.getDocumentBaseInfo().getCheckOrgCode());
			 
		}
		
		if(ObjectUtils.isNotEmpty(sd006.getDocumentBody())){
			 
			uhDcOrdPacsRecord.setCodeDiag(sd006.getDocumentBody().getPvCode());
			uhDcOrdPacsRecord.setNameDiag(sd006.getDocumentBody().getPvName());
			uhDcOrdPacsRecord.setResultObj(sd006.getDocumentBody().getObjectiveCheckReportResultName());
			uhDcOrdPacsRecord.setResultSubj(sd006.getDocumentBody().getSubjectiveCheckReportResultName());
			
			//检查结论
			uhDcOrdPacsRecord.setEuResult(sd006.getDocumentBody().getSubjectiveCheckReportResultName());
			//影像地址
			uhDcOrdPacsRecord.setAddrImg(sd006.getDocumentBody().getCheckImageUrl());
			//检查备注
			uhDcOrdPacsRecord.setNote(sd006.getDocumentBody().getCheckNoteName());
			
		}
		//结果类型编码 目前在文档中没有找到相应的节点
		//uhDcOrdPacsRecord.setCodeResultType("");
		//uhDcOrdPacsRecord.setNameResultType("");
		
		
		uhDcOrdPacsRecord.setCreateTime(new Date());
		uhDcOrdPacsRecord.setEditTime(new Date());
		uhDcOrdPacsRecord.setFlagDel(0);
		return uhDcOrdPacsRecord;
	}
	
	
}
