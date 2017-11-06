package com.yonyou.dao;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdOp;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcOrdOpDao.java
 * @Description: 
 * @date 2017年7月9日 上午10:46:44
 */
public interface UhDcOrdOpDao extends JpaRepository<UhDcOrdOp,String> {

	@Query("select op from UhDcOrdOp op " +
            "where op.pkDcord=:pkDcord ")
	UhDcOrdOp getOrderOpByPkDcord(@Param("pkDcord") String pkDcord);
}
