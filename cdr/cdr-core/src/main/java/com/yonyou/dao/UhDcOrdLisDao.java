package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.yonyou.entity.UhDcOrdLis;

public interface UhDcOrdLisDao extends JpaRepository<UhDcOrdLis,String>{

	@Query("select lis from UhDcOrdLis lis " +
            "where lis.pkDcord=:pkDcord ")
	UhDcOrdLis getOrderLisByPkDcord(@Param("pkDcord") String pkDcord);
}
