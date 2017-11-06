package com.yonyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrdRecord;

public interface UhDcOrdRecordDao extends JpaRepository<UhDcOrdRecord,String>{
	@Query("select record from UhDcOrdRecord record " +
            "where record.pkDcord=:pkDcord  and record.flagDel='0'")
	UhDcOrdRecord getOrderRecordByPkDcord(@Param("pkDcord") String pkDcord);
	
	
	@Query("select record from UhDcOrdRecord record " +
            "where record.codeOrd=:codeOrd " +
			"and record.codePati=:codePati "+
            "and record.pvcode=:pvcode " +
			"and record.codePvtype=:codePvtype "+
            "and record.codeGroup=:codeGroup "+
			"and record.codeOrg=:codeOrg "+
            "and record.flagDel='0'")
	UhDcOrdRecord getUhDcOrdRecord(@Param("codeOrd") String codeOrd,
			@Param("codePati") String codePati,
			@Param("pvcode") String pvcode,
			@Param("codePvtype") String codePvtype,
			@Param("codeGroup") String codeGroup,
			@Param("codeOrg") String codeOrg
			);
	  
	UhDcOrdRecord findByCodeRepAndCodeGroupAndCodeOrgAndFlagDel(String codeRep, String codeGroup, String codeOrg, String flagDel);
}
