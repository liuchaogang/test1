package com.yonyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.dao.UhDcOrdTransDao;
import com.yonyou.entity.UhDcOrdTrans;
import com.yonyou.service.UhDcOrdTransService;

@Service
public class UhDcOrdTransServiceImpl implements UhDcOrdTransService {

	@Autowired
	private UhDcOrdTransDao uhDcOrdTransDao;
	
	@Override
	public void saveUhDcOrdTrans(UhDcOrdTrans uhDcOrdTrans) {
		uhDcOrdTransDao.saveAndFlush(uhDcOrdTrans);
	}
}
