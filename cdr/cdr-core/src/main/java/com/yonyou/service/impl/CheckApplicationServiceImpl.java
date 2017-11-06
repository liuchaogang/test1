package com.yonyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.dao.UhDcOrdDao;
import com.yonyou.dao.UhDcOrdLisDao;
import com.yonyou.dao.UhDcOrdLisRecordDao;
import com.yonyou.dao.UhDcOrdLisitemDao;
import com.yonyou.dao.UhDcOrdOthDao;
import com.yonyou.dao.UhDcOrdPacsRecordDao;
import com.yonyou.dao.UhDcOrdPisDao;
import com.yonyou.dao.UhDcOrdRecordDao;
import com.yonyou.dao.UhDcOrdRisDao;
import com.yonyou.dao.UhDcOrdTransDao;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdLis;
import com.yonyou.entity.UhDcOrdLisRecord;
import com.yonyou.entity.UhDcOrdLisitem;
import com.yonyou.entity.UhDcOrdOth;
import com.yonyou.entity.UhDcOrdPacsRecord;
import com.yonyou.entity.UhDcOrdPis;
import com.yonyou.entity.UhDcOrdRecord;
import com.yonyou.entity.UhDcOrdRis;
import com.yonyou.entity.UhDcOrdTrans;
import com.yonyou.service.CheckApplicationService;

@Service
public class CheckApplicationServiceImpl implements CheckApplicationService {

	@Autowired
	private UhDcOrdDao uhDcOrdDao;
	
	@Autowired
	private UhDcOrdRisDao uhDcOrdRisDao;
	
	@Autowired
	private UhDcOrdPisDao uhDcOrdPisDao;
	
	@Autowired
	private UhDcOrdOthDao uhDcOrdOthDao;
	
	@Autowired
	private UhDcOrdLisDao uhDcOrdLisDao;
	
	@Autowired
	private UhDcOrdTransDao uhDcOrdTransDao;
	
	@Autowired
	private UhDcOrdRecordDao uhDcOrdRecordDao;
	
	
	@Autowired
	private UhDcOrdPacsRecordDao uhDcOrdPacsRecordDao;
	
	@Autowired
	private UhDcOrdLisRecordDao uhDcOrdLisRecordDao;
	
	@Autowired
	private UhDcOrdLisitemDao uhDcOrdLisitemDao;

	@Override
	public UhDcOrd saveUhDcOrd(UhDcOrd uhDcOrd) {
		return uhDcOrdDao.saveAndFlush(uhDcOrd);
	}

	@Override
	public UhDcOrdRis saveUhDcOrdRis(UhDcOrdRis uhDcOrdRis) {
		return uhDcOrdRisDao.saveAndFlush(uhDcOrdRis);
	}

	@Override
	public UhDcOrdPis saveUhDcOrdPis(UhDcOrdPis uhDcOrdPis) {
		return uhDcOrdPisDao.saveAndFlush(uhDcOrdPis);
	}

	@Override
	public UhDcOrdOth saveUhDcOrdOth(UhDcOrdOth uhDcOrdOth) {
		return uhDcOrdOthDao.saveAndFlush(uhDcOrdOth);
	}

 
	@Override
	public UhDcOrdLis saveUhDcOrdLis(UhDcOrdLis uhDcOrdLis) {
		return uhDcOrdLisDao.saveAndFlush(uhDcOrdLis);
	}

	@Override
	public UhDcOrdLis getUhDcOrdLis(String pkDcord) {
		return uhDcOrdLisDao.getOrderLisByPkDcord(pkDcord);
	}

	@Override
	public UhDcOrdRis getUhDcOrdRis(String pkDcord) {
		return uhDcOrdRisDao.getOrderRisByPkDcord(pkDcord);
	}

	@Override
	public UhDcOrdPis getUhDcOrdPis(String pkDcord) {
		return uhDcOrdPisDao.getOrderPisByPkDcord(pkDcord);
	}

	@Override
	public UhDcOrdOth getUhDcOrdOth(String pkDcord) {
		return uhDcOrdOthDao.getOrderOthByPkDcord(pkDcord);
	}

	@Override
	public UhDcOrdRecord saveUhDcOrdRecord(UhDcOrdRecord uhDcOrdRecord) {
		return uhDcOrdRecordDao.save(uhDcOrdRecord);
	}

	/*@Override
	public UhDcOrdRecord getUhDcOrdRecord(String pkDcord) {
		// TODO Auto-generated method stub
		return uhDcOrdRecordDao.getOrderRecordByPkDcord(pkDcord);
	}*/

	@Override
	public UhDcOrdTrans getUhDcOrdTrans(String pkDcord) {
		// TODO Auto-generated method stub
		return uhDcOrdTransDao.getOrderTransByPkDcord(pkDcord);
	}

	@Override
	public UhDcOrdRis getOrderRisByCordOrd(String orderNo) {
		// TODO Auto-generated method stub
		return uhDcOrdRisDao.getOrderRisByCordOrd(orderNo);
	}

	@Override
	public UhDcOrdPacsRecord saveuhDcOrdPacsRecord(UhDcOrdPacsRecord uhDcOrdPacsRecord) {
		 
		return uhDcOrdPacsRecordDao.save(uhDcOrdPacsRecord);
	}
	
	public UhDcOrdRecord getUhDcOrdRecord(String codeOrd,String codePati,String pvcode,String codePvtype,String codeGroup,String codeOrg){
		return uhDcOrdRecordDao.getUhDcOrdRecord(codeOrd, codePati, pvcode, codePvtype, codeGroup, codeOrg);
	}

	@Override
	public UhDcOrdPacsRecord getuhDcOrdPacsRecordByPkOrdRecord(String pkOrdRecord) {
		// TODO Auto-generated method stub
		return uhDcOrdPacsRecordDao.getuhDcOrdPacsRecordByPkOrdRecord(pkOrdRecord);
	}

	@Override
	public UhDcOrdLisRecord saveUhDcOrdLisRecord(UhDcOrdLisRecord uhDcOrdLisRecord) {
		 
		return uhDcOrdLisRecordDao.saveAndFlush(uhDcOrdLisRecord);
	}

	@Override
	public UhDcOrdLisitem saveUhDcOrdLisitem(UhDcOrdLisitem uhDcOrdLisitem) {
		// TODO Auto-generated method stub
		return uhDcOrdLisitemDao.save(uhDcOrdLisitem);
	}

	@Override
	public UhDcOrdLisRecord getUhDcOrdLisRecordByPkOrdRecord(String pkOrdRecord) {
		 
		return uhDcOrdLisRecordDao.getUhDcOrdLisRecordByPkOrdRecord(pkOrdRecord);
	}

	@Override
	public UhDcOrdLisitem getUhDcOrdLisitemByPkRepLisAndCodeInstrument(String pkRepLis, String codeInstrument) {
		 
		return uhDcOrdLisitemDao.getgetUhDcOrdLisitemByPkRepLisAndCodeInstrume(pkRepLis,codeInstrument);
	}
 
}
