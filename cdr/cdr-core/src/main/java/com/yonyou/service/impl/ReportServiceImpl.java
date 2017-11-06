package com.yonyou.service.impl;

import com.yonyou.dao.UhDcOrdRecordDao;
import com.yonyou.entity.UhDcOrdRecord;
import com.yonyou.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenpana@yonyou.com
 * @ClassName: ReportServiceImpl
 * @Description:
 * @date 2017/7/11 11:00
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private UhDcOrdRecordDao uhDcOrdRecordDao;

    @Override
    public UhDcOrdRecord getReportByCondition(String reportNo, String groupCode, String orgCode, String flag) {
        return uhDcOrdRecordDao.findByCodeRepAndCodeGroupAndCodeOrgAndFlagDel(reportNo, groupCode, orgCode, flag);
    }
}
