package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdOth;


public interface UhDcOrdOthDao  extends JpaRepository<UhDcOrdOth,String>{
	@Query("select oth from UhDcOrdOth oth " +
            "where oth.pkDcord=:pkDcord ")
	UhDcOrdOth getOrderOthByPkDcord(@Param("pkDcord") String pkDcord);
}
