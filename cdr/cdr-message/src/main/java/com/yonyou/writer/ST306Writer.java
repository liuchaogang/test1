package com.yonyou.writer;

 
import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

 
import com.yonyou.entity.UhAppLoopEvent;
 
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdExe;
import com.yonyou.hl7adapter.model.ST306.ST306;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.OrderService;
import com.yonyou.service.UhDcOrdExeService;
import com.yonyou.util.Constant;

/**
 * 
 * 
 */
@Component(value = "ST306")
public class ST306Writer implements BaseProcessWriter<ST306> {

    private static Logger logger = LoggerFactory.getLogger("ST306Logger");

    @Autowired
    private UhDcOrdExeService uhDcOrdExeService;
    
    @Autowired
    private OrderService orderService;

    @Override
    public boolean validation(ST306 st306, Object reMsg) {
        return true;
    }
    @Override
    public boolean checkPre(ST306 st306) {
        return true;
    }
    @Override
    @Transactional
    public void businessWrite(ST306 st306) {
    	UhDcOrd uhDcOrd = orderService.getOrderByNo(st306.getOrderInfo().getOrderNo());
    	if(uhDcOrd!=null){
    		logger.info("消息入库uh_dc_ord_exe（医嘱_执行），医嘱号："+st306.getOrderInfo().getOrderNo());
    		UhDcOrdExe ordExe = new UhDcOrdExe();
    		ordExe.setPkDcord(uhDcOrd.getPkDcord());
    		ordExe.setCodeGroup(Constant.getGroupCode());
    		ordExe.setCodeOrg(Constant.getOrgCode());
    		ordExe.setCodeOrd(st306.getOrderInfo().getOrderNo());
    		ordExe.setDatePlan(DateUtil.ToMinuteFormatter(st306.getOrderInfo().getPlanExecTime()));
    		ordExe.setDateEx(DateUtil.ToMinuteFormatter(st306.getOrderInfo().getPerformerTime()));
    		ordExe.setCodeOrgEx(st306.getOrderInfo().getExecRegionCode());
    		ordExe.setNameOrgEx(st306.getOrderInfo().getExecRegionName());
    		ordExe.setCodeDeptEx(st306.getOrderInfo().getExecOrgCode());
    		ordExe.setNameDeptEx(st306.getOrderInfo().getExecOrgName());
    		ordExe.setCodePsnEx(st306.getOrderInfo().getPerformerCode());
    		ordExe.setNamePsnEx(st306.getOrderInfo().getPerformerName());
    		ordExe.setCodeResultEx(st306.getOrderInfo().getOrderExecStatusCode());
    		ordExe.setNameResultEx(st306.getOrderInfo().getOrderExecStatusName());
    		ordExe.setNumEx(new BigDecimal(st306.getOrderInfo().getQuantity()));
    		ordExe.setUnitEx(st306.getOrderInfo().getQuantityUnit());
    		ordExe.setNote(st306.getOrderInfo().getRemark());
//    		ordExe.setStatus(st306.getOrderInfo().get);
    		ordExe.setDataSource(st306.getSenderId());
    		ordExe.setSourcePk(st306.getOrderInfo().getOrderNo());
    		ordExe.setCreateTime(new Date());
    		ordExe.setEditTime(new Date());
    		ordExe.setFlagDel(0);
    		uhDcOrdExeService.saveUhDcOrdExe(ordExe);
    		System.out.println(ordExe.getPkDcordex());
    	}else{
    		logger.info("消息入库uh_dc_ord_exe（医嘱_执行）失败，医嘱号："+st306.getOrderInfo().getOrderNo());
    	}
    	
    }

}
