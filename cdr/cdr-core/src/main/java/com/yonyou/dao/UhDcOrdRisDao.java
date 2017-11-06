package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdRis;

public interface UhDcOrdRisDao extends JpaRepository<UhDcOrdRis,String>{
	@Query("select ris from UhDcOrdRis ris " +
            "where ris.pkDcord=:pkDcord ")
	UhDcOrdRis getOrderRisByPkDcord(@Param("pkDcord") String pkDcord);
	
	@Query("select ris from UhDcOrdRis ris " +
            "where ris.codeOrd=:orderNo")
	UhDcOrdRis getOrderRisByCordOrd(@Param("orderNo") String orderNo);
}
