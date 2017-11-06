package com.yonyou.writer;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.ST304.OrderInfo;
import com.yonyou.hl7adapter.model.ST304.ST304;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.Constant;

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
@Component(value = "ST304")
public class ST304Writer implements BaseProcessWriter<ST304> {

    private static Logger logger = LoggerFactory.getLogger("ST304Logger");

    @Autowired
    private OrderService orderService;
    @Autowired
    private PatientVisitService patientVisitService;
    
    @Override
    public boolean validation(ST304 st304, Object reMsg) {
        return true;
    }
    @Override
    public boolean checkPre(ST304 st304) {
        return true;
    }
    @Override
    @Transactional
    public void businessWrite(ST304 st304) {
    	
    	if("U".equals(st304.getActionType()) || "D".equals(st304.getActionType())){
    		List<String> ordNos = new ArrayList<String>();
    		for(OrderInfo oi : st304.getOrderInfo()){
    			ordNos.add(oi.getId());
    		}
    		if(ordNos.size() > 0){
    			List<UhDcOrd> lstUhDcOrd = orderService.getUhDcOrdListByOrdNos(ordNos, true);
    			orderService.deleteUhDcOrdList(lstUhDcOrd);
    		}else{
    			logger.info("st302消息没有医嘱号");
    			return;
    		}
    		if("D".equals(st304.getActionType())){
    			return;
    		}
    	}
    	
    	
    	UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(st304.getPvInfo().getPvId());
    	if(null==uhDcPv){
    		logger.debug("st304没有找到就诊记录：就诊号pvcode:"+st304.getPvInfo().getPvId());
    		return;
    	}
    	
    	List<UhDcOrd> lstUhDcOrd = new ArrayList<UhDcOrd>();
		List<OrderInfo> lstOrderInfo = st304.getOrderInfo();
		for(OrderInfo oi : lstOrderInfo){
			UhDcOrd uhDcOrd = new UhDcOrd();
			setUhDcOrd(uhDcOrd, oi, st304);
			uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
			lstUhDcOrd.add(uhDcOrd);
		}
		orderService.saveUhDcOrdList(lstUhDcOrd);
    }
    
	private void setUhDcOrd(UhDcOrd uhDcOrd, OrderInfo oi, ST304 st304) {
		// TODO Auto-generated method stub
		uhDcOrd.setCodeOrd(oi.getId());
		uhDcOrd.setCodeSrvtype(oi.getOrderTypeCode());
		uhDcOrd.setNameSrvtype(oi.getOrderTypeName());
		uhDcOrd.setCodeOrditemType(oi.getOrderItemTypeCode());
		uhDcOrd.setNameOrditemType(oi.getOrderItemTypeName());
		uhDcOrd.setCodeOrditem(oi.getOrderItemCode());
		uhDcOrd.setNameOrditem(oi.getOrderItemName());
		uhDcOrd.setNoteOrd(oi.getRemark());
		uhDcOrd.setCodeOrdStatus(oi.getOrderStatus());
		uhDcOrd.setDateBegin(DateUtil.ToSecondFormatter(oi.getOrderStartTime()));
		uhDcOrd.setDateOrderEffe(DateUtil.ToSecondFormatter(oi.getOrderEndTime()));
		uhDcOrd.setCodeFreq(oi.getFrequenceCode());
		uhDcOrd.setNameFreq(oi.getFrequenceName());
		uhDcOrd.setCodeOrditem(oi.getItemCode());
		uhDcOrd.setNameOrditem(oi.getItemName());
		uhDcOrd.setDescOrd(oi.getItemName());
		uhDcOrd.setAmountSrv(new BigDecimal(oi.getMoneyTotal()));
		uhDcOrd.setAmountSelf(new BigDecimal(oi.getMoneySelf()));
		uhDcOrd.setDateCreate(DateUtil.ToSecondFormatter(oi.getAuthorTime()));
		uhDcOrd.setCodePsnPhy(oi.getAuthorCode());
		uhDcOrd.setNamePsnPhy(oi.getAuthorName());
		uhDcOrd.setCodeDetpPhy(oi.getAuthorOrgcode());
		uhDcOrd.setNameDeptPhy(oi.getAuthorOrgName());
		uhDcOrd.setCodePsnRec(oi.getTranscriberCode());
		uhDcOrd.setNamePsnRec(oi.getTranscriberName());
//		uhDcOrd.setDateChk(DateUtil.ToSecondFormatter(oi.getVerifierNurseTime()));
		uhDcOrd.setCodePsnChk(oi.getVerifierNurseCode());
		uhDcOrd.setNamePsnChk(oi.getVerifierNurseName());
		uhDcOrd.setCodeDeptExec(oi.getExecOrgCode());
		uhDcOrd.setNameDeptExec(oi.getExecOrgName());
		uhDcOrd.setParentCode(oi.getParentOrderId());
		uhDcOrd.setCodeUsage(oi.getReasonUseCode());
		uhDcOrd.setNameUsage(oi.getReasonUseName());
		uhDcOrd.setCodeUsageReq(oi.getReasonUseReqCode());
		uhDcOrd.setNameUsageReq(oi.getReasonUseReqName());
		uhDcOrd.setFlagUrgent("false".equals(oi.getUrgentFlag())?0:1);
		uhDcOrd.setIsSpareOrd("false".equals(oi.getReserveFlag())?0:1);
		uhDcOrd.setDescSpareOrd(oi.getReserveRemark());
		uhDcOrd.setOrdEntrust(oi.getEntrust());
		
		uhDcOrd.setCodeGroup(Constant.getGroupCode());
		uhDcOrd.setCodeOrg(Constant.getOrgCode());
		uhDcOrd.setEmpi(st304.getPvInfo().getPatient().getEmpiId());
		uhDcOrd.setCodePati(st304.getPvInfo().getPatient().getPatientId());
		uhDcOrd.setCodePvtype(st304.getPvInfo().getPvTypeCode());
		uhDcOrd.setNamePvtype(st304.getPvInfo().getPvTypeName());
		uhDcOrd.setPvcode(st304.getPvInfo().getPvId());
		uhDcOrd.setPatiname(st304.getPvInfo().getPatient().getPatientName());
		uhDcOrd.setCodeSex(st304.getPvInfo().getPatient().getGenderCode());
		uhDcOrd.setNameSex(st304.getPvInfo().getPatient().getGenderName());
		uhDcOrd.setBirthday(DateUtil.BirthTimeFormatter(st304.getPvInfo().getPatient().getBirthDate()));
		uhDcOrd.setCodeDept(st304.getPvInfo().getPatient().getOrgCode());
		uhDcOrd.setNameDept(st304.getPvInfo().getPatient().getOrgName());
		uhDcOrd.setCodeArea(st304.getPvInfo().getAreaCode());
		uhDcOrd.setNameArea(st304.getPvInfo().getAreaName());
		uhDcOrd.setDataSource(st304.getSenderId());
		uhDcOrd.setSourcePk(st304.getPvInfo().getPvId());
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		uhDcOrd.setFlagDel(0);
	}
	
}
