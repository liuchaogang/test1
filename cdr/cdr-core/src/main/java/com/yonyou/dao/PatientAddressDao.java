package com.yonyou.dao;

import com.yonyou.entity.UhDcPiAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientAddressDao
 * @Description:
 * @date 2017/6/29 9:06
 */
public interface PatientAddressDao extends JpaRepository<UhDcPiAddress,String> {

    void deleteByPkPati(String pkPati);
}
