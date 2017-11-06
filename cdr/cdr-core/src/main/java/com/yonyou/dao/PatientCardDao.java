package com.yonyou.dao;

import com.yonyou.entity.UhDcPiCard;
import org.springframework.data.jpa.repository.JpaRepository;
 

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientCardDao
 * @Description:
 * @date 2017/6/29 9:04
 */
public interface PatientCardDao extends JpaRepository<UhDcPiCard,String> {

    void deleteByPkPati(String pkPati);
}
