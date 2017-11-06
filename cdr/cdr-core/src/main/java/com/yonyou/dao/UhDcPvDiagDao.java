package com.yonyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcPvDiag;

public interface UhDcPvDiagDao extends JpaRepository <UhDcPvDiag,String>{

	UhDcPvDiag findByPkDcpv(String pkDcpv);

	@Query("select diag from UhDcPvDiag diag " +
	            "where diag.pvcode = :pvId " +
	            "      and diag.flagDel='0'")
	List<UhDcPvDiag> getUhDcPvDiagListByPvcode(@Param("pvId") String pvId);
}
