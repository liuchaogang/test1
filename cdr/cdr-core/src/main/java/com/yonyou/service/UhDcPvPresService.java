package com.yonyou.service;

import java.util.List;

import com.yonyou.entity.*;

/**
 * The interface Order service.
 */
public interface UhDcPvPresService {

	void saveUhDcPvPresList(List<UhDcPvPres> lstUhDcPvPres);

	void saveUhDcPvPres(UhDcPvPres uhDcPvPres);

	List<UhDcPvPres> getUhDcPvPresListByPresNos(List<String> presIds);

	void deleteUhDcPvPresList(List<UhDcPvPres> lstUhDcPvPres);
}
