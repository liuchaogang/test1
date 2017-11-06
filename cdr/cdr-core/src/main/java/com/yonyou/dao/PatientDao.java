package com.yonyou.dao;

import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientDao
 * @Description: 患者基本信息相关dao
 * @date 2017/6/28 14:11
 */

public interface PatientDao extends JpaRepository<UhDcPi, String> {

    @Procedure("proc_update_empiandpkpi_all")
    void updateEmpiAndPkpiAll(@Param("empi") String empi,
                              @Param("pkPati") String pkPati,
                              @Param("oldPkPati") String oldPkPati);

    @Query("select pi from UhDcPi pi " +
            "where pi.empi=:empiId " +
            "      and pi.codeGroup=:groupCode" +
            "      and pi.codeOrg=:orgCode" +
            "      and pi.flagDel='0'")
    UhDcPi findUhDCPi(@Param("empiId") String empiId,
                      @Param("groupCode") String groupCode,
                      @Param("orgCode") String orgCode);

    @Query("select pi from UhDcPi pi " +
            "where pi.empi=(select pcx.empi from UhDcPiCrossIndex pcx " +
            "where pcx.patiCode=:patientId " +
            "      and pcx.localTypeCode=:localTypeCode " +
            "      and pcx.codeGroup=:groupCode" +
            "      and pcx.codeOrg=:orgCode" +
            "      and pcx.flagDel='0')")
    UhDcPi findUhDCPiJoinCrossIndex(@Param("patientId") String patientId,
                                    @Param("localTypeCode") String localTypeCode,
                                    @Param("groupCode") String groupCode,
                                    @Param("orgCode") String orgCode);

    @Query("select pi from UhDcPi pi " +
            "where pi.empi=(select pcx.empi from UhDcPiCrossIndex pcx " +
            "where pcx.patiCode=:patientId " +
            "      and pcx.localTypeCode=:localTypeCode " +
            "      and pcx.codeGroup=:groupCode" +
            "      and pcx.codeOrg=:orgCode" +
            "      and pcx.flagDel='0')" +
            " and pi.empi<>:empiId")
    UhDcPi findUhDCPi(@Param("empiId") String empiId,
                      @Param("patientId") String patientId,
                      @Param("localTypeCode") String localTypeCode,
                      @Param("groupCode") String groupCode,
                      @Param("orgCode") String orgCode);

    UhDcPi findByEmpi(String empi);
}
