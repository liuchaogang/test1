package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdTrans;

public interface UhDcOrdTransDao extends JpaRepository<UhDcOrdTrans,String>{
	@Query("select trans from UhDcOrdTrans trans " +
            "where trans.pkDcord=:pkDcord ")
	UhDcOrdTrans getOrderTransByPkDcord(@Param("pkDcord") String pkDcord);
}