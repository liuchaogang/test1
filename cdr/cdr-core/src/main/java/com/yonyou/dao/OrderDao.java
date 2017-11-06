package com.yonyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcPv;

public interface OrderDao extends JpaRepository<UhDcOrd,String>{
	@Query("select ord from UhDcOrd ord " +
            "where ord.codeOrd=:orderNo ")
	UhDcOrd getOrderByNo(@Param("orderNo") String orderNo);

	@Query("select ord from UhDcOrd ord " +
            "where ord.codePres in (:presIds) " +
            "      and ord.flagDel='0'")
	List<UhDcOrd> getUhDcOrdListByPresNos(@Param("presIds") List<String> presIds);

	@Query("select ord from UhDcOrd ord " +
            "where ord.codeOrd in (:ordNos) " +
            "      and ord.flagDel='0'")
	List<UhDcOrd> getUhDcOrdListByordNos(@Param("ordNos") List<String> ordNos);

	@Query("select ord from UhDcOrd ord " +
            "where ord.codeOrd like :ordNoUseLike +'\\_%' ESCAPE '\\'" +
            "      and ord.flagDel='0'")
	List<UhDcOrd> getUhDcOrdListByordNoUseLike(@Param("ordNoUseLike") String ordNoUseLike);
	
	

    @Query("select ord from UhDcOrd ord WHERE ord.codeOrd=:orderNo " +
            " AND ord.pvcode=:visitId" +
            " AND ord.codePvtype=:visitTypeCode" +
            " AND ord.codeOrditemType=:codeOrditemType" +
            " AND ord.codeGroup=:groupCode" +
            " AND ord.codeOrg=:orgCode"+
            "  AND ord.flagDel='0'")
    UhDcOrd getUhDcOrderByVisitInfo(@Param("orderNo") String orderNo,
                                @Param("visitId") String visitId,
                                @Param("visitTypeCode") String visitTypeCode,
                                @Param("codeOrditemType") String codeOrditemType,
                                @Param("groupCode") String groupCode,
                                @Param("orgCode") String orgCode);

}
