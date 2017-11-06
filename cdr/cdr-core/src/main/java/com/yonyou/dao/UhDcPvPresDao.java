package com.yonyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcPvPres;

/**
 */
public interface UhDcPvPresDao extends JpaRepository<UhDcPvPres, String> {

	@Query("select pres from UhDcPvPres pres " +
            "where pres.codePres in (:presIds) " +
            "      and pres.flagDel='0'")
	List<UhDcPvPres> getUhDcPvPresListByPresNos(@Param("presIds") List<String> presIds);

}
