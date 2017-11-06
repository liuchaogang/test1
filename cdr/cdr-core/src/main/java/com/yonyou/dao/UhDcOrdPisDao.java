package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdPis;

public interface UhDcOrdPisDao extends JpaRepository<UhDcOrdPis,String>{
	@Query("select pis from UhDcOrdPis pis " +
            "where pis.pkDcord=:pkDcord ")
	UhDcOrdPis getOrderPisByPkDcord(@Param("pkDcord") String pkDcord);
}
