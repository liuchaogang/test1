package com.yonyou.dao;

import com.yonyou.entity.UhDcPiCrossIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientCrossIndexDao
 * @Description:
 * @date 2017/6/28 14:25
 */
public interface PatientCrossIndexDao extends JpaRepository<UhDcPiCrossIndex,String> {

    @Query("select pcx from UhDcPiCrossIndex pcx " +
            "where pcx.patiCode=:patiCode " +
            "      and pcx.localTypeCode=:localTypeCode " +
            "      and pcx.codeGroup=:groupCode" +
            "      and pcx.codeOrg=:orgCode" +
            "      and pcx.flagDel='0'")
    UhDcPiCrossIndex findPiCrossIndex(@Param("patiCode") String patiCode, @Param("localTypeCode")String localTypeCode, @Param("groupCode")String groupCode, @Param("orgCode")String orgCode);

    void deleteByEmpi(String empi);
}
