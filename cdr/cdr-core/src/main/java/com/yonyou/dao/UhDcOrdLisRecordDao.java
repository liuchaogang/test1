package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdLisRecord;
 

 
public interface UhDcOrdLisRecordDao  extends JpaRepository<UhDcOrdLisRecord,String> {

	@Query("select record from UhDcOrdLisRecord record " +
            "where record.pkOrdRecord=:pkOrdRecord  and record.flagDel='0'")
	UhDcOrdLisRecord getUhDcOrdLisRecordByPkOrdRecord(@Param("pkOrdRecord") String pkOrdRecord);
	
	
 ;

}
