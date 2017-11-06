package com.yonyou.service;

import java.util.List;

import com.yonyou.entity.*;

/**
 * The interface Order service.
 */
public interface UhDcPvDiagService {

	void saveUhDcPvDiag(UhDcPvDiag uhDcPvDiag);

	List<UhDcPvDiag> getUhDcPvDiagListByPvcode(String pvId);

	void deleteUhDcPvDiagList(List<UhDcPvDiag> lstUhDcPvDiag);
}
