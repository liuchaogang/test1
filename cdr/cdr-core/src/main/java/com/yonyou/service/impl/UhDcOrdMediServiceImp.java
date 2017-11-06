package com.yonyou.service.impl;

import com.yonyou.dao.UhDcOrdMediDao;
import com.yonyou.entity.*;
import com.yonyou.service.UhDcOrdMediService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The interface Order service.
 */
@Service
public class UhDcOrdMediServiceImp implements UhDcOrdMediService{
	
	@Autowired
	private UhDcOrdMediDao uhDcOrdMediDao;
	@Override
	public void saveUhDcOrdMedi(UhDcOrdMedi uhDcOrdMedi) {
		// TODO Auto-generated method stub
		uhDcOrdMediDao.saveAndFlush(uhDcOrdMedi);
	}
	@Override
	public List<UhDcOrdMedi> getUhDcOrdMediListByUhDcOrdPks(
			List<String> uhDcOrdPks) {
		// TODO Auto-generated method stub
		return uhDcOrdMediDao.getUhDcOrdMediListByUhDcOrdPks(uhDcOrdPks);
	}
	@Override
	public void deleteUhDcOrdMediList(List<UhDcOrdMedi> lstUhDcOrdMedi) {
		// TODO Auto-generated method stub
		uhDcOrdMediDao.delete(lstUhDcOrdMedi);
	}

}
