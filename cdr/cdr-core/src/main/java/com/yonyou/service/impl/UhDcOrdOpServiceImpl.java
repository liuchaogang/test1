package com.yonyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.dao.UhDcOrdOpDao;
import com.yonyou.entity.UhDcOrdOp;
import com.yonyou.service.UhDcOrdOpService;
/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcOrdOpServiceImpl.java
 * @Description: 
 * @date 2017年7月9日 上午11:34:52
 */
@Service
public class UhDcOrdOpServiceImpl implements UhDcOrdOpService {

	@Autowired
	private UhDcOrdOpDao uhDcOrdOpDao;
	@Override
	public UhDcOrdOp getOrderOpByPkDcord(String pkDcord) {
		 
		return uhDcOrdOpDao.getOrderOpByPkDcord(pkDcord);
	}

	@Override
	public UhDcOrdOp saveOrderOp(UhDcOrdOp uhDcOrdOp) {
		return uhDcOrdOpDao.saveAndFlush(uhDcOrdOp);
	}

}
