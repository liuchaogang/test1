package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdPacsRecord;

public interface UhDcOrdPacsRecordDao extends JpaRepository<UhDcOrdPacsRecord,String> {
	
	

	@Query("select uhDcOrdPacsRecord from UhDcOrdPacsRecord uhDcOrdPacsRecord " +
            "where uhDcOrdPacsRecord.pkOrdRecord=:pkOrdRecord")
	UhDcOrdPacsRecord getuhDcOrdPacsRecordByPkOrdRecord(@Param("pkOrdRecord") String pkOrdRecord);
 
}
