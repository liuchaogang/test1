package com.yonyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.dao.UhDcTransDeptDao;
import com.yonyou.entity.UhDcTransDept;
import com.yonyou.service.UhDcTransDeptService;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcTransDeptServiceimpl.java
 * @Description: 
 * @date 2017年7月5日 上午9:44:45
 */
@Service
public class UhDcTransDeptServiceimpl implements UhDcTransDeptService {

	    @Autowired
	    private UhDcTransDeptDao uhDcTransDeptDao;
	@Override
	public UhDcTransDept saveUhDcTransDept(UhDcTransDept uhDcTransDept) {
 
		return uhDcTransDeptDao.saveAndFlush(uhDcTransDept);
	}

}
