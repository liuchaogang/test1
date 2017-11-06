package com.yonyou.service.impl;

import com.yonyou.dao.*;
import com.yonyou.entity.*;
import com.yonyou.service.UhDcOrdExeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class UhDcOrdExeServiceImpl implements UhDcOrdExeService {
    @Autowired
    private UhDcOrdExeDao uhDcOrdExeDao;

	@Override
	public void saveUhDcOrdExe(UhDcOrdExe uhDcOrdExe) {
		// TODO Auto-generated method stub
		uhDcOrdExeDao.saveAndFlush(uhDcOrdExe);
	}


}
