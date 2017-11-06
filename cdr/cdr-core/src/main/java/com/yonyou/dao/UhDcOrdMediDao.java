package com.yonyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdMedi;

public interface UhDcOrdMediDao  extends JpaRepository<UhDcOrdMedi,String>{
	@Query("select ordMedi from UhDcOrdMedi ordMedi " +
            "where ordMedi.pkDcord in (:uhDcOrdPks) " +
            "      and ordMedi.flagDel='0'")
	List<UhDcOrdMedi> getUhDcOrdMediListByUhDcOrdPks(@Param("uhDcOrdPks") String uhDcOrdPks);

	@Query("select ordMedi from UhDcOrdMedi ordMedi " +
            "where ordMedi.pkDcord in (:uhDcOrdPks) " +
            "      and ordMedi.flagDel='0'")
	List<UhDcOrdMedi> getUhDcOrdMediListByUhDcOrdPks(@Param("uhDcOrdPks") List<String> uhDcOrdPks);

}
