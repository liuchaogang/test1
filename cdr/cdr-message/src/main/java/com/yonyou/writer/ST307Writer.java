package com.yonyou.writer;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.hl7adapter.model.ST307.OrderInfo;
import com.yonyou.hl7adapter.model.ST307.ST307;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.OrderService;
import com.yonyou.service.UhDcOrdExeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 */
@Component(value = "ST307")
public class ST307Writer implements BaseProcessWriter<ST307> {

    private static Logger logger = LoggerFactory.getLogger("ST307Logger");

    @Autowired
    private OrderService orderService;

    @Override
    public boolean validation(ST307 st307, Object reMsg) {
        return true;
    }
    @Override
    public boolean checkPre(ST307 st307) {
        return true;
    }
    @Override
    @Transactional
    public void businessWrite(ST307 st307) {
    	List<UhDcOrd> ordLst = new ArrayList<UhDcOrd>();
    	if("C".equals(st307.getActionType())){
    		List<OrderInfo> lst = st307.getOrderInfo();
    		for(OrderInfo oi : lst){
    			UhDcOrd uhDcOrd = orderService.getOrderByNo(oi.getOrderNo());
    			if(uhDcOrd!=null){
    				Date cancelDate=null;
    				try{
    					cancelDate = new SimpleDateFormat("yyyyMMddHHmm").parse(oi.getPerformerTime());
    				}catch(ParseException e){
    					cancelDate = new Date();
    				}
    				uhDcOrd.setDateCancel(cancelDate);
    				uhDcOrd.setCodeCancelpesc(oi.getPerformerCode());
    				uhDcOrd.setNameCancelpesc(oi.getPerformerName());
    				uhDcOrd.setBakCancel(oi.getReason());
    				uhDcOrd.setFlagCancel(1);
    				ordLst.add(uhDcOrd);
    				logger.info("消息更新库uh_dc_ord（就诊_医嘱），医嘱号："+oi.getOrderNo());
    			}else{
    				logger.info("消息更新库uh_dc_ord（就诊_医嘱）失败，医嘱号："+oi.getOrderNo());
    			}
    			
    		}
    	}else if("S".equals(st307.getActionType())){
    		List<OrderInfo> lst = st307.getOrderInfo();
    		for(OrderInfo oi : lst){
    			UhDcOrd uhDcOrd = orderService.getOrderByNo(oi.getOrderNo());
    			if(uhDcOrd!=null){
    				uhDcOrd.setDateEnd(DateUtil.ToMinuteFormatter(oi.getPerformerTime()));
    				uhDcOrd.setCodePsnEnd(oi.getPerformerCode());
    				uhDcOrd.setNamePsnEnd(oi.getPerformerName());
    				uhDcOrd.setFlagStopPhy(1);
    				ordLst.add(uhDcOrd);
    				logger.info("消息更新库uh_dc_ord（就诊_医嘱），医嘱号："+oi.getOrderNo());
    			}else{
    				logger.info("消息更新库uh_dc_ord（就诊_医嘱）失败，医嘱号："+oi.getOrderNo());
    			}
    			
    		}
    	}
    	
    	orderService.saveUhDcOrdList(ordLst);
    }

}
