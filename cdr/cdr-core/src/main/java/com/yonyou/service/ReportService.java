package com.yonyou.service;

import com.yonyou.entity.UhDcOrdRecord;

/**
 * @author chenpana@yonyou.com
 * @ClassName: ReportService
 * @Description:
 * @date 2017/7/11 10:39
 */
public interface ReportService {

    /**
     * 根据条件查找报告
     * @param reportNo
     * @param groupCode
     * @param orgCode
     * @param flag
     * @return
     */
    UhDcOrdRecord getReportByCondition(String reportNo,String groupCode,String orgCode,String flag);
}
