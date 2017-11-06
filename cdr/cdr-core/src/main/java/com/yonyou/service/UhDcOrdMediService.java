package com.yonyou.service;

import com.yonyou.entity.*;

import java.util.List;

/**
 * The interface Order service.
 */
public interface UhDcOrdMediService {

	void saveUhDcOrdMedi(UhDcOrdMedi uhDcOrdMedi);

	List<UhDcOrdMedi> getUhDcOrdMediListByUhDcOrdPks(List<String> uhDcOrdPks);

	void deleteUhDcOrdMediList(List<UhDcOrdMedi> lstUhDcOrdMedi);
}
