package com.yonyou.service.impl;

import com.yonyou.dao.MipMsgLogDao;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.service.MipMsgLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author chenpana@yonyou.com
 * @ClassName: MipMsgLogServiceImpl
 * @Description:
 * @date 2017/8/3 9:34
 */

@Service
public class MipMsgLogServiceImpl implements MipMsgLogService {

    @Autowired
    private MipMsgLogDao msgLogDao;

    @Override
    public void saveMsgLog(UhDcMipMsgLog msgLog) {

        if (StringUtils.isNotBlank(msgLog.getId())) {
            msgLog.setUpdateTime(new Date());
        } else {
            msgLog.setCreateTime(new Date());
        }

        msgLogDao.save(msgLog);
    }

    @Override
    public UhDcMipMsgLog getMsgLogByMsgId(String msgId) {
        return msgLogDao.findByMsgId(msgId);
    }
}
