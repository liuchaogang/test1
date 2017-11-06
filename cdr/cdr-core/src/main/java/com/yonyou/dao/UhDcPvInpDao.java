package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.yonyou.entity.UhDcPvInp;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcPvInpDao.java
 * @Description: 
 * @date 2017年7月6日 下午4:42:55
 */
public interface UhDcPvInpDao extends JpaRepository<UhDcPvInp,String> {
	
    UhDcPvInp findByPkDcpv(String pkDcpv);
    


}
