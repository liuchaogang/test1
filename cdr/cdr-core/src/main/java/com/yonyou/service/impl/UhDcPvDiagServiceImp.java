package com.yonyou.service.impl;

import java.util.List;

import com.yonyou.dao.UhDcPvDiagDao;
import com.yonyou.entity.*;
import com.yonyou.service.UhDcPvDiagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The interface Order service.
 */
@Service
public class UhDcPvDiagServiceImp implements UhDcPvDiagService{
	
	@Autowired
	private UhDcPvDiagDao uhDcPvDiagDao;
	@Override
	public void saveUhDcPvDiag(UhDcPvDiag uhDcPvDiag) {
		// TODO Auto-generated method stub
		uhDcPvDiagDao.saveAndFlush(uhDcPvDiag);
	}
	@Override
	public List<UhDcPvDiag> getUhDcPvDiagListByPvcode(String pvId) {
		// TODO Auto-generated method stub
		return uhDcPvDiagDao.getUhDcPvDiagListByPvcode(pvId);
	}
	@Override
	public void deleteUhDcPvDiagList(List<UhDcPvDiag> lstUhDcPvDiag) {
		// TODO Auto-generated method stub
		uhDcPvDiagDao.delete(lstUhDcPvDiag);
	}

}
