package com.yonyou.service.impl;

import com.yonyou.dao.*;
import com.yonyou.entity.*;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientService;
import com.yonyou.service.UhAppLoopEventService;
import com.yonyou.util.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 */
@Service
public class UhAppLoopEventServiceImpl implements UhAppLoopEventService {
    @Autowired
    private UhAppLoopEventDao uhAppLoopEventDao;

	@Override
	public void saveUhAppLoopEvent(UhAppLoopEvent uhAppLoopEvent) {
		// TODO Auto-generated method stub
		uhAppLoopEventDao.saveAndFlush(uhAppLoopEvent);
	}
    
    
}
