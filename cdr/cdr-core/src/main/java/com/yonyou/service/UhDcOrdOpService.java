package com.yonyou.service;


import com.yonyou.entity.UhDcOrdOp;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcOrdOpService.java
 * @Description: 
 * @date 2017年7月09日 上午9:44:22
 */
public interface UhDcOrdOpService {
	
	UhDcOrdOp getOrderOpByPkDcord(String pkDcord);
	
	UhDcOrdOp saveOrderOp(UhDcOrdOp uhDcOrdOp);

}
