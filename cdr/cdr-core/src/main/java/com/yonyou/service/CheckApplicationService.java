package com.yonyou.service;

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

public interface CheckApplicationService {
	
	UhDcOrd saveUhDcOrd(UhDcOrd uhDcOrd);
	
	UhDcOrdRis saveUhDcOrdRis(UhDcOrdRis uhDcOrdRis);
	UhDcOrdPis saveUhDcOrdPis(UhDcOrdPis uhDcOrdPis);
	UhDcOrdOth saveUhDcOrdOth(UhDcOrdOth uhDcOrdOth);
	UhDcOrdLis saveUhDcOrdLis(UhDcOrdLis uhDcOrdLis);
	UhDcOrdRecord saveUhDcOrdRecord(UhDcOrdRecord uhDcOrdRecord); 
	UhDcOrdPacsRecord saveuhDcOrdPacsRecord(UhDcOrdPacsRecord uhDcOrdPacsRecord);
	
	UhDcOrdLisRecord saveUhDcOrdLisRecord(UhDcOrdLisRecord uhDcOrdLisRecord);
	UhDcOrdLisitem saveUhDcOrdLisitem(UhDcOrdLisitem uhDcOrdLisitem);
	UhDcOrdRis getUhDcOrdRis(String pkDcord);
	
	UhDcOrdRis getOrderRisByCordOrd(String orderNo);
	
	UhDcOrdPis getUhDcOrdPis(String pkDcord);
	UhDcOrdOth getUhDcOrdOth(String pkDcord);
	UhDcOrdLis getUhDcOrdLis(String pkDcord);
	UhDcOrdTrans getUhDcOrdTrans(String pkDcord);
	//UhDcOrdRecord getUhDcOrdRecord(String pkDcord);
	
	UhDcOrdRecord  getUhDcOrdRecord(String codeOrd,String codePati,String pvcode,String codePvtype,String codeGroup,String codeOrg);
	
	UhDcOrdPacsRecord getuhDcOrdPacsRecordByPkOrdRecord(String pkOrdRecord);
	
	
	UhDcOrdLisRecord getUhDcOrdLisRecordByPkOrdRecord(String pkOrdRecord);
	
	
	UhDcOrdLisitem getUhDcOrdLisitemByPkRepLisAndCodeInstrument(String pkRepLis, String codeInstrument);
	
	
	
	
	
	
}
