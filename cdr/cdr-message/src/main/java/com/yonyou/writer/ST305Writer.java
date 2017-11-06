package com.yonyou.writer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.entity.UhAppLoopEvent;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.hl7adapter.model.ST305.ST305;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.OrderService;
import com.yonyou.service.UhAppLoopEventService;

/**
 * 
 * 
 */
@Component(value = "ST305")
public class ST305Writer implements BaseProcessWriter<ST305> {

    private static Logger logger = LoggerFactory.getLogger("ST305Logger");

    @Autowired
    private UhAppLoopEventService uhAppLoopEventService;
    
    @Autowired
    private OrderService orderService;

    @Override
    public boolean validation(ST305 st305, Object reMsg) {
        return true;
    }
    @Override
    public boolean checkPre(ST305 st305) {
        return true;
    }
    @Override
    @Transactional
    public void businessWrite(ST305 st305) {
    	logger.info("消息入库uh_app_loop_event（事件执行记录），医嘱号："+st305.getOrderInfo().getOrderNo());
    	UhAppLoopEvent uale = new UhAppLoopEvent();
    	uale.setCodeEventType("HIS_IP_ORDER_EXECUTE");
    	uale.setNameEventType("医嘱执行");
    	uale.setCodePati(st305.getPvInfo().getPatient().getPatientId());
    	uale.setPvcode(st305.getPvInfo().getPvId());
    	uale.setPatiname(st305.getPvInfo().getPatient().getPatientName());
    	uale.setCodeSex(st305.getPvInfo().getPatient().getGenderCode());
    	uale.setNameSex(st305.getPvInfo().getPatient().getGenderName());
    	uale.setBirthday(DateUtil.BirthTimeFormatter(st305.getPvInfo().getPatient().getBirthDate()));
    	uale.setCodeOrd(st305.getOrderInfo().getOrderNo());
    	uale.setEmpi(st305.getPvInfo().getPatient().getEmpiId());
    	uale.setCodeRis(st305.getOrderInfo().getReportNo());
    	uale.setCodeReq(st305.getOrderInfo().getApplyNo());
    //	uale.setTimeActual(DateUtil.ToMinuteFormatter(st305.getOrderInfo().getPerformerTime()));
    	uale.setCodePharm(st305.getOrderInfo().getPerformerCode());
    	uale.setNamePharm(st305.getOrderInfo().getPerformerName());
    	uale.setDeptPhyCode(st305.getOrderInfo().getExecOrgCode());
    	uale.setDeptPhyName(st305.getOrderInfo().getExecOrgName());
    	uale.setEventSource(st305.getSenderId());
    	uale.setCreateTime(new Date());
    	uale.setEditTime(new Date());
    	uale.setFlagDel(0);
    	uhAppLoopEventService.saveUhAppLoopEvent(uale);
    	System.out.println(uale.getPkEvent());
    	
    	logger.info("消息更新库uh_dc_ord（就诊_医嘱），医嘱号："+st305.getOrderInfo().getOrderNo());
    	UhDcOrd uhDcOrd = orderService.getOrderByNo(uale.getCodeOrd());
    	if(null!=uhDcOrd){
	    	uhDcOrd.setCodeOrdStatus(st305.getOrderInfo().getOrderExecStatusCode());
	    	uhDcOrd.setNameOrdStatus(st305.getOrderInfo().getOrderExecStatusName());
	    	uhDcOrd.setDateEx(DateUtil.ToMinuteFormatter(st305.getOrderInfo().getPerformerTime()));
	    	uhDcOrd.setCodePsnEx(st305.getOrderInfo().getPerformerCode());
	    	uhDcOrd.setNamePsnEx(st305.getOrderInfo().getPerformerName());
	    	uhDcOrd.setCodeDeptExec(st305.getOrderInfo().getExecOrgCode());
	    	uhDcOrd.setNameDeptExec(st305.getOrderInfo().getExecOrgName());
	    	uhDcOrd.setEditTime(new Date());
	    	orderService.saveOrder(uhDcOrd);
    	}
    }

}
