package com.yonyou.service;

import com.yonyou.entity.*;

import java.util.List;

/**
 * The interface Order service.
 */
public interface UhDcOrdExeService {

    /**
     * 查询患者交叉索引信息
     *
     * @param patientId     患者本地ID
     * @param localTypeCode 患者类型编码
     * @param groupCode     集团编码
     * @param orgCode       机构编码
     * @return uh pi cross index
     */

	void saveUhDcOrdExe(UhDcOrdExe uhDcOrdExe);

}
