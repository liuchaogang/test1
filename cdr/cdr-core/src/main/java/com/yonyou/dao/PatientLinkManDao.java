package com.yonyou.dao;

import com.yonyou.entity.UhDcPiLinkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientLinkManDao
 * @Description:
 * @date 2017/6/29 9:08
 */
public interface PatientLinkManDao extends JpaRepository<UhDcPiLinkman,String> {

    void deleteByPkPati(String pkPati);
}
