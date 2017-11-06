package com.yonyou.service;
 
import com.yonyou.entity.UhDcPvInp;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcPvInpService.java
 * @Description: 
 * @date 2017年7月6日 下午4:46:38
 */
public interface UhDcPvInpService {

	 UhDcPvInp findByPkDcpv(String pkDcpv);
	 
	 void saveUhDcPvInp(UhDcPvInp uhDcPvInp);
	 
	 
	 
}
