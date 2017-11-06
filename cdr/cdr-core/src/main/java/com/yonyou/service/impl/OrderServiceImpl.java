package com.yonyou.service.impl;

import com.yonyou.dao.*;
import com.yonyou.entity.*;
import com.yonyou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public UhDcOrd getOrderByNo(String orderNo){
    	return orderDao.getOrderByNo(orderNo);
    }

	@Override
	public UhDcOrd saveOrder(UhDcOrd uhDcOrd) {
		// TODO Auto-generated method stub
		return orderDao.saveAndFlush(uhDcOrd);
	}
	

	@Override
	public void saveUhDcOrdList(List<UhDcOrd> uhDcOrdList) {
		// TODO Auto-generated method stub
		orderDao.save(uhDcOrdList);
	}

	/**
	 * 保存后返回保存的对象
	 */
	@Override
	public UhDcOrd saveOrderReturnOrder(UhDcOrd uhDcOrd) {
		 
		return orderDao.saveAndFlush(uhDcOrd);
	}

	@Override
	public List<UhDcOrd> getUhDcOrdListByPresNos(List<String> presIds) {
		// TODO Auto-generated method stub
		return orderDao.getUhDcOrdListByPresNos(presIds);
	}

	@Override
	public void deleteUhDcOrdList(List<UhDcOrd> lstUhDcOrd) {
		// TODO Auto-generated method stub
		orderDao.delete(lstUhDcOrd);
	}

	@Override
	public List<UhDcOrd> getUhDcOrdListByOrdNos(List<String> ordNos, boolean isWest) {
		// TODO Auto-generated method stub
		if(isWest){
			return orderDao.getUhDcOrdListByordNos(ordNos);
		}else{
			List<UhDcOrd> lst = new ArrayList<UhDcOrd>();
			for(String ordNo : ordNos){
				lst.addAll(orderDao.getUhDcOrdListByordNoUseLike(ordNo));
			}
			return lst;
		}
	}

	@Override
	public UhDcOrd getUhDcOrderByVisitInfo(String orderNo, String visitId, String visitTypeCode, String codeOrditemType,
			String groupCode, String orgCode) {
		// TODO Auto-generated method stub
		return orderDao.getUhDcOrderByVisitInfo(orderNo, visitId, visitTypeCode, codeOrditemType, groupCode, orgCode);
	}


}
