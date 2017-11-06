package com.yonyou.dao;

import com.yonyou.entity.UhDcPv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcPvDao
 * @Description:
 * @date 2017/7/3 9:33
 */
public interface UhDcPvDao extends JpaRepository<UhDcPv, String> {


    @Query("SELECT pv FROM UhDcPv pv WHERE pv.codePati=:patientId" +
            " AND (pv.pvcode=:visitId OR pv.pvTimes=:visitTimes )" +
            " AND pv.codePvtype=:visitTypeCode" +
            " AND pv.codeGroup=:groupCode" +
            " AND pv.codeOrg=:orgCode")
    UhDcPv getUhDcPvByVisitInfo(@Param("patientId") String patientId,
                                @Param("visitId") String visitId,
                                @Param("visitTimes") Integer visitTimes,
                                @Param("visitTypeCode") String visitTypeCode,
                                @Param("groupCode") String groupCode,
                                @Param("orgCode") String orgCode);

    @Modifying
    @Query("update UhDcPv pv set pv.dateCanc=:registerTime," +
            "pv.codePsnCanc=:registrantCode," +
            "pv.namePsnCanc=:registrantName," +
            "pv.flagCanc='1' "+
            "where pv.pkDcpv=:pkDcpv")
    void updateUhDcPv(@Param("pkDcpv")String pkDcpv,
                      @Param("registerTime")String registerTime,
                      @Param("registrantCode")String registrantCode,
                      @Param("registrantName")String registrantName);
 
    @Modifying
    @Query("update UhDcPv pv set pv.dateEnd=:leaveDate " +
            "where pv.pkDcpv=:pkDcpv")
    void updateUhDcPvDateEnd(@Param("pkDcpv")String pkDcpv,
                      @Param("leaveDate")String leaveDate);
 
    
    @Query("SELECT pv FROM UhDcPv pv WHERE pv.pvcode=:pvcode ")
    UhDcPv getUhDcPvByPvcode(@Param("pvcode") String pvcode);
 
}
