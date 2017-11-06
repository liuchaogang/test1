package com.yonyou.service;

import com.yonyou.entity.*;

import java.util.List;

import org.springframework.data.repository.query.Param;

/**
 * The interface Order service.
 */
public interface OrderService {

    /**
     * 查询患者交叉索引信息
     *
     * @param patientId     患者本地ID
     * @param localTypeCode 患者类型编码
     * @param groupCode     集团编码
     * @param orgCode       机构编码
     * @return uh pi cross index
     */
    UhDcOrd getOrderByNo(String orderNo);

    UhDcOrd saveOrder(UhDcOrd uhDcOrd);

	UhDcOrd saveOrderReturnOrder(UhDcOrd uhDcOrd);
	void saveUhDcOrdList(List<UhDcOrd> uhDcOrdList);
	

	List<UhDcOrd> getUhDcOrdListByPresNos(List<String> presIds);

	void deleteUhDcOrdList(List<UhDcOrd> lstUhDcOrd);

	List<UhDcOrd> getUhDcOrdListByOrdNos(List<String> ordNos, boolean isWest);
	
	
    UhDcOrd getUhDcOrderByVisitInfo(String orderNo,String visitId,String visitTypeCode,String codeOrditemType,String groupCode,String orgCode);
}
