package com.yonyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.dao.UhDcPvPresDao;
import com.yonyou.entity.*;
import com.yonyou.service.UhDcPvPresService;

/**
 * The interface Order service.
 */
@Service
public class UhDcPvPresServiceImpl implements UhDcPvPresService{

	@Autowired
	private UhDcPvPresDao uhDcPvPresDao;
	
	@Override
	public void saveUhDcPvPresList(List<UhDcPvPres> lstUhDcPvPres) {
		// TODO Auto-generated method stub
		uhDcPvPresDao.save(lstUhDcPvPres);
	}

	@Override
	public void saveUhDcPvPres(UhDcPvPres uhDcPvPres) {
		// TODO Auto-generated method stub
		uhDcPvPresDao.saveAndFlush(uhDcPvPres);
	}

	@Override
	public List<UhDcPvPres> getUhDcPvPresListByPresNos(List<String> presIds) {
		// TODO Auto-generated method stub
		return uhDcPvPresDao.getUhDcPvPresListByPresNos(presIds);
	}

	@Override
	public void deleteUhDcPvPresList(List<UhDcPvPres> lstUhDcPvPres) {
		// TODO Auto-generated method stub
		uhDcPvPresDao.delete(lstUhDcPvPres);
	}

}
