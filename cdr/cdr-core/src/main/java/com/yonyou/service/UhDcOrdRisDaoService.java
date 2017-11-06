package com.yonyou.service;

import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdOth;
import com.yonyou.entity.UhDcOrdPis;
import com.yonyou.entity.UhDcOrdRis;

public interface UhDcOrdRisDaoService {
	
	UhDcOrd saveUhDcOrd(UhDcOrd uhDcOrd);
	
	UhDcOrdRis saveUhDcOrdRis(UhDcOrdRis uhDcOrdRis);
	UhDcOrdPis saveUhDcOrdPis(UhDcOrdPis uhDcOrdPis);
	UhDcOrdOth saveUhDcOrdOth(UhDcOrdOth uhDcOrdOth);
}
