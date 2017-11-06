package com.yonyou.service;

import com.yonyou.entity.UhDcMipMsgLog;

/**
 * @author chenpana@yonyou.com
 * @ClassName: MipMsgLogService
 * @Description:
 * @date 2017/8/3 9:32
 */

public interface MipMsgLogService {

    /**
     * 保存日志信息
     * @param msgLog
     */
    void saveMsgLog(UhDcMipMsgLog msgLog);

    /**
     * 通过msgId 获取消息日志内容
     * @param msgId
     * @return
     */
    UhDcMipMsgLog getMsgLogByMsgId(String msgId);
}
