package com.yonyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.dao.UhDcPvInpDao;
import com.yonyou.entity.UhDcPvInp;
import com.yonyou.service.UhDcPvInpService;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcPvInpServiceImpl.java
 * @Description: 
 * @date 2017年7月6日 下午7:48:57
 */
@Service
public class UhDcPvInpServiceImpl implements UhDcPvInpService {

	@Autowired
	private UhDcPvInpDao uhDcPvInpDao;
	
	@Override
	public UhDcPvInp findByPkDcpv(String pkDcpv) {
		
		return uhDcPvInpDao.findByPkDcpv(pkDcpv);
	}

	@Override
	public void saveUhDcPvInp(UhDcPvInp uhDcPvInp) {
		uhDcPvInpDao.saveAndFlush(uhDcPvInp);

	}

}
