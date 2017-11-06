package com.yonyou.dao;

import com.yonyou.entity.UhDcPvOutp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcPvOutpDao
 * @Description:
 * @date 2017/7/3 11:24
 */
public interface UhDcPvOutpDao extends JpaRepository<UhDcPvOutp,String>{

    UhDcPvOutp findByPkDcpv(String pkDcpv);
}
