package com.yonyou.writer;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdLis;
import com.yonyou.entity.UhDcOrdLisRecord;
import com.yonyou.entity.UhDcOrdLisitem;
import com.yonyou.entity.UhDcOrdRecord;
import com.yonyou.hl7adapter.model.SD007.LabItem;
import com.yonyou.hl7adapter.model.SD007.LabSubItem;
import com.yonyou.hl7adapter.model.SD007.SD007;
import com.yonyou.service.CheckApplicationService;
import com.yonyou.service.OrderService;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

/**
 * @author chenpana@yonyou.com
 * @ClassName: SD007Writer
 * @Description:
 * @date 2017/7/10 16:52
 */
@Component(value = "SD007")
public class SD007Writer implements BaseProcessWriter<SD007> {

	private static Logger sd007Logger = LoggerFactory.getLogger("SD007Logger");

	@Autowired
	private OrderService orderService;

	@Autowired
	private CheckApplicationService checkApplicationService;

	@Override
	public boolean validation(SD007 sd007, Object reMsg) {
		if (StringUtils.isEmpty(sd007.getVersionNo())) {
			reMsg = "CDA文档版本号不能为空";
			return false;
		}
		if (StringUtils.isEmpty(sd007.getDocumentNo())) {
			reMsg = "CDA文档流水号（报告号）不能为空";
			return false;
		}

		return true;
	}

	@Override
	public boolean checkPre(SD007 sd007) {
		return true;
	}

	@Override
    public void businessWrite(SD007 sd007) {
        //判断是新增还是修改
		if (Constant.getCDAVersionAdd().equals(sd007.getVersionNo())) {

			// 新增
			// 1、查询是否有相应的医嘱

			UhDcOrd uhDcOrderByVisitInfo = orderService.getUhDcOrderByVisitInfo(sd007.getPatient().geteRequestId(),
					sd007.getVisitId(), sd007.getPatient().getPatientTypeCode(), "LIS", Constant.getGroupCode(),
					Constant.getOrgCode());

			// 2、如果没有相应的医嘱直接返回并日志记录
			if (ObjectUtils.isEmpty(uhDcOrderByVisitInfo)) {
				sd007Logger.error("该报告对应的申请单不存在，codeOrd:{}", sd007.getPatient().geteRequestId());

			} else {
				// sd007转换成UhDcOrdRecord
				UhDcOrdRecord convertUhDcOrdRecord = convertUhDcOrdRecord(sd007);
				convertUhDcOrdRecord.setPkDcord(uhDcOrderByVisitInfo.getPkDcord());
				convertUhDcOrdRecord.setPkDcpv(uhDcOrderByVisitInfo.getPkDcpv());
				convertUhDcOrdRecord.setEmpi(uhDcOrderByVisitInfo.getEmpi());
				UhDcOrdRecord saveUhDcOrdRecord = checkApplicationService.saveUhDcOrdRecord(convertUhDcOrdRecord);
				if (ObjectUtils.isNotEmpty(saveUhDcOrdRecord)) {
					sd007Logger.debug("消息入库uh_dc_ord_record（），医嘱号：" + sd007.getPatient().geteRequestId());
					// sd007转换成UhDcOrdLisRecord
					UhDcOrdLisRecord convertUhDcOrdLisRecord = convertUhDcOrdLisRecord(sd007);
					convertUhDcOrdLisRecord.setPkOrdRecord(saveUhDcOrdRecord.getPkOrdRecord());
					UhDcOrdLisRecord saveUhDcOrdLisRecord = checkApplicationService
							.saveUhDcOrdLisRecord(convertUhDcOrdLisRecord);

					if (ObjectUtils.isNotEmpty(saveUhDcOrdLisRecord)) {
						sd007Logger.debug("消息入库uh_dc_ord_lis_record（），结果报告主键：" + saveUhDcOrdLisRecord.getPkOrdRecord());

						if (ObjectUtils.isNotEmpty(sd007.getLabItem())) {
							List<LabSubItem> labSubItems = sd007.getLabItem().getLabSubItems();
							for (LabSubItem l : labSubItems) {
								// sd007转换成UhDcOrdLisitem
								UhDcOrdLisitem convertUhDcOrdLisitem = convertUhDcOrdLisitem(sd007);
								convertUhDcOrdLisitem.setPkRepLis(saveUhDcOrdLisRecord.getPkRepLis());
								convertUhDcOrdLisitem.setCodeIndexLis(l.getSubItemCode());
								convertUhDcOrdLisitem.setNameIndexLis(l.getSubItemName());
								if (ObjectUtils.isEmpty(l.getQualitativeResultName())) {
									convertUhDcOrdLisitem.setValueLis(l.getQualitativeResultName());
								} else if (ObjectUtils.isEmpty(l.getNumValue())) {
									convertUhDcOrdLisitem.setValueLis(l.getNumValue());
								}

								convertUhDcOrdLisitem.setNameQuantiUnit(l.getUnit());
								convertUhDcOrdLisitem.setLimitHigh(l.getRefHigh());
								convertUhDcOrdLisitem.setLimitLow(l.getRefHigh());
								convertUhDcOrdLisitem.setDescRrs(l.getRefText());
								convertUhDcOrdLisitem.setValueFlag(l.getQuantitativeResultFlagCode());
								convertUhDcOrdLisitem.setValueFlagName(l.getQuantitativeResultFlag());
								//cdr数据库中的仪器编码，现在用来存放序号，为后期查找记录
								convertUhDcOrdLisitem.setCodeInstrument(l.getSequenceNo());

								UhDcOrdLisitem saveUhDcOrdLisitem = checkApplicationService
										.saveUhDcOrdLisitem(convertUhDcOrdLisitem);
								if (ObjectUtils.isNotEmpty(saveUhDcOrdLisitem)) {
									sd007Logger.debug(
											"消息入库uh_dc_ord_lisitem（），检验结果主键：" + saveUhDcOrdLisitem.getPkOrdlab());
								}
							}

						}

					}
				}

			}

		} else if (Constant.getCDAVersionModify().equals(sd007.getVersionNo())) {
			// 修改
			UhDcOrdRecord uhDcOrdRecord = checkApplicationService.getUhDcOrdRecord(sd007.getPatient().geteRequestId(),
					sd007.getPatient().getPatientId(), sd007.getVisitId(), sd007.getPatient().getPatientTypeCode(),
					Constant.getGroupCode(), Constant.getOrgCode());

			if (ObjectUtils.isEmpty(uhDcOrdRecord)) {
				sd007Logger.error("该报告不存在，codeOrd:{}", sd007.getPatient().geteRequestId());

			} else {

				UhDcOrdRecord convertUhDcOrdRecord = convertUhDcOrdRecord(sd007);
				convertUhDcOrdRecord.setPkDcord(uhDcOrdRecord.getPkDcord());
				convertUhDcOrdRecord.setPkDcpv(uhDcOrdRecord.getPkDcpv());
				convertUhDcOrdRecord.setEmpi(uhDcOrdRecord.getEmpi());
				convertUhDcOrdRecord.setCreateTime(uhDcOrdRecord.getCreateTime());
				UhDcOrdRecord updateUhDcOrdRecord = checkApplicationService.saveUhDcOrdRecord(convertUhDcOrdRecord);
				if (ObjectUtils.isNotEmpty(updateUhDcOrdRecord)) {
					sd007Logger.debug("消息入库uh_dc_ord_record（），医嘱号：" + sd007.getPatient().geteRequestId());

					UhDcOrdLisRecord uhDcOrdLisRecordByPkOrdRecord = checkApplicationService
							.getUhDcOrdLisRecordByPkOrdRecord(updateUhDcOrdRecord.getPkOrdRecord());

					// sd007转换成UhDcOrdLisRecord
					UhDcOrdLisRecord convertUhDcOrdLisRecord = convertUhDcOrdLisRecord(sd007);
					if (ObjectUtils.isNotEmpty(uhDcOrdLisRecordByPkOrdRecord)) {
						convertUhDcOrdLisRecord.setPkRepLis(uhDcOrdLisRecordByPkOrdRecord.getPkRepLis());
						convertUhDcOrdLisRecord.setCreateTime(uhDcOrdLisRecordByPkOrdRecord.getCreateTime());
					}
					convertUhDcOrdLisRecord.setPkOrdRecord(updateUhDcOrdRecord.getPkOrdRecord());
					UhDcOrdLisRecord updateUhDcOrdLisRecord = checkApplicationService
							.saveUhDcOrdLisRecord(convertUhDcOrdLisRecord);

					if (ObjectUtils.isNotEmpty(updateUhDcOrdLisRecord)) {
						sd007Logger
								.debug("消息入库uh_dc_ord_lis_record（），结果报告主键：" + updateUhDcOrdLisRecord.getPkOrdRecord());
						
						if (ObjectUtils.isNotEmpty(sd007.getLabItem())) {
							List<LabSubItem> labSubItems = sd007.getLabItem().getLabSubItems();
							for (LabSubItem l : labSubItems) {
								// sd007转换成UhDcOrdLisitem
								UhDcOrdLisitem convertUhDcOrdLisitem = convertUhDcOrdLisitem(sd007);
								
								UhDcOrdLisitem uhDcOrdLisitem = checkApplicationService.getUhDcOrdLisitemByPkRepLisAndCodeInstrument(updateUhDcOrdLisRecord.getPkRepLis(), l.getSequenceNo());
								
								if(ObjectUtils.isNotEmpty(uhDcOrdLisitem)){
									convertUhDcOrdLisitem.setPkOrdlab(uhDcOrdLisitem.getPkOrdlab());
									convertUhDcOrdLisitem.setCreateTime(uhDcOrdLisitem.getCreateTime());
								}
								
								convertUhDcOrdLisitem.setPkRepLis(updateUhDcOrdLisRecord.getPkRepLis());
								convertUhDcOrdLisitem.setCodeIndexLis(l.getSubItemCode());
								convertUhDcOrdLisitem.setNameIndexLis(l.getSubItemName());
								if (ObjectUtils.isEmpty(l.getQualitativeResultName())) {
									convertUhDcOrdLisitem.setValueLis(l.getQualitativeResultName());
								} else if (ObjectUtils.isEmpty(l.getNumValue())) {
									convertUhDcOrdLisitem.setValueLis(l.getNumValue());
									
								}

								convertUhDcOrdLisitem.setNameQuantiUnit(l.getUnit());
								convertUhDcOrdLisitem.setLimitHigh(l.getRefHigh());
								convertUhDcOrdLisitem.setLimitLow(l.getRefHigh());
								convertUhDcOrdLisitem.setDescRrs(l.getRefText());
								convertUhDcOrdLisitem.setValueFlag(l.getQuantitativeResultFlagCode());
								convertUhDcOrdLisitem.setValueFlagName(l.getQuantitativeResultFlag());
								
								UhDcOrdLisitem updateUhDcOrdLisitem = checkApplicationService
										.saveUhDcOrdLisitem(convertUhDcOrdLisitem);
								if (ObjectUtils.isNotEmpty(updateUhDcOrdLisitem)) {
									sd007Logger.debug(
											"消息入库uh_dc_ord_lisitem（），检验结果主键：" + updateUhDcOrdLisitem.getPkOrdlab());
								}
						
					}

				} else {
					sd007Logger.error("该报告更新失败，PkOrdRecord:{}", uhDcOrdRecord.getPkOrdRecord());
				}

			}

		} else {
			sd007Logger.error("不支持的操作类型：{}", sd007.getVersionNo());
		}
			}
			}
	}

	private UhDcOrdRecord convertUhDcOrdRecord(SD007 sd007) {
		UhDcOrdRecord record = new UhDcOrdRecord();

		record.setCodeGroup(Constant.getGroupCode());
		record.setCodeOrg(Constant.getOrgCode());
		//
		record.setPvcode(sd007.getVisitId());

		if (ObjectUtils.isNotEmpty(sd007.getPatient())) {
			record.setCodePvtype(sd007.getPatient().getPatientTypeCode());
			record.setNamePvtype(sd007.getPatient().getPatientTypeName());
			record.setCodeOrd(sd007.getPatient().geteRequestId());
			record.setPatiname(sd007.getPatient().getName());
			record.setCodeSex(sd007.getPatient().getSex());

			record.setCodePati(sd007.getPatient().getPatientId());
			record.setAge(sd007.getPatient().getAge());
			record.setPkDcordrisreq(sd007.getPatient().geteRequestId());
			record.setCodeReq(sd007.getPatient().geteRequestId());
			record.setCodeRep(sd007.getPatient().getCheckReportId());

		}

		record.setCodeDept(sd007.getDeptCode());
		record.setNameDept(sd007.getDeptName());
		record.setCodeArea(sd007.getWardCode());
		record.setNameArea(sd007.getWardName());
		record.setBed(sd007.getBedNo());

		record.setCodeRepType("LIS");
		record.setNameRepType("检验");

		if (ObjectUtils.isNotEmpty(sd007.getLabItem())) {
			record.setCodeEuType(sd007.getLabItem().getLabItemCode());
			record.setNameEuType(sd007.getLabItem().getLabItemName());
			record.setCodeEuItem(sd007.getLabItem().getLabItemCode());
			record.setNameEuItem(sd007.getLabItem().getLabItemName());
			// 检验时间
			record.setDateRis(DateUtils.getDateStr2Str(sd007.getLabItem().getTestTime()));
		}

		record.setCodeEuOrg(Constant.getOrgCode());
		record.setNameEuOrg(Constant.getOrgName());

		record.setCodeEuDep(sd007.getCheckOrgCode());
		record.setNameEuDep(sd007.getCheckOrgName());
		record.setCodeEuPsnPis(sd007.getCheckPhysicianId());
		record.setNameEuPsnPis(sd007.getCheckPhysicianName());

		record.setCodePsnRep(sd007.getAssignedPersonCode());
		record.setNamePsnRep(sd007.getAssignedPersonName());
		record.setDateRep(DateUtils.getDateStr2Str(sd007.getReportTime()));

		record.setCodePsnCheck(sd007.getReviewPhysicianId());
		record.setNamePsnCheck(sd007.getReviewPhysicianName());
		record.setDateCheck(DateUtils.getDateStr2Str(sd007.getLegalAuthenticatorTime()));

		record.setCreateTime(new Date());
		record.setEditTime(new Date());
		record.setFlagDel(0);

		return record;
	}

	private UhDcOrdLisRecord convertUhDcOrdLisRecord(SD007 sd007) {
		UhDcOrdLisRecord uhDcOrdLisRecord = new UhDcOrdLisRecord();

		uhDcOrdLisRecord.setCodeGroup(Constant.getGroupCode());
		uhDcOrdLisRecord.setCodeOrg(Constant.getOrgCode());

		if (ObjectUtils.isNotEmpty(sd007.getPatient())) {
			uhDcOrdLisRecord.setCodeRep(sd007.getPatient().getCheckReportId());
			uhDcOrdLisRecord.setSourcePk(sd007.getPatient().getCheckReportId());

		}

		if (ObjectUtils.isNotEmpty(sd007.getLabItem())) {
			// 检验时间
			uhDcOrdLisRecord.setDateLab(DateUtils.getDateStr2Str(sd007.getLabItem().getTestTime()));
			uhDcOrdLisRecord.setNameTypeLis(sd007.getLabType());
			uhDcOrdLisRecord.setNameMethodLis(sd007.getLabMethodName());
		}

		if (ObjectUtils.isNotEmpty(sd007.getDiagnoses().get(0))) {
			uhDcOrdLisRecord.setCodeDiag(sd007.getDiagnoses().get(0).getDiagCode());
			uhDcOrdLisRecord.setNameDiag(sd007.getDiagnoses().get(0).getDiagName());
			uhDcOrdLisRecord.setDiagDate(DateUtils.getDateStr2Str(sd007.getDiagnoses().get(0).getDiagnosisTime()));
		}

		uhDcOrdLisRecord.setResultRep(sd007.getReportConclusion());
		uhDcOrdLisRecord.setNoteRep(sd007.getReportMemo());
		uhDcOrdLisRecord.setDataSource("LIS");

		uhDcOrdLisRecord.setCreateTime(new Date());

		uhDcOrdLisRecord.setEditTime(new Date());
		uhDcOrdLisRecord.setFlagDel("0");
		return uhDcOrdLisRecord;

	}

	private UhDcOrdLisitem convertUhDcOrdLisitem(SD007 sd007) {
		UhDcOrdLisitem uhDcOrdLisitem = new UhDcOrdLisitem();

		uhDcOrdLisitem.setCodeGroup(Constant.getGroupCode());
		uhDcOrdLisitem.setCodeOrg(Constant.getOrgCode());

		if (ObjectUtils.isNotEmpty(sd007.getPatient())) {
			uhDcOrdLisitem.setCodeRep(sd007.getPatient().getCheckReportId());
			uhDcOrdLisitem.setSourcePk(sd007.getPatient().getCheckReportId());
			uhDcOrdLisitem.setSpecimenid(sd007.getPatient().getSampleId());
			uhDcOrdLisitem.setUniqSerialNo(sd007.getPatient().getCheckReportId());

		}
		uhDcOrdLisitem.setDataSource("LIS");

		return uhDcOrdLisitem;

	}
}
