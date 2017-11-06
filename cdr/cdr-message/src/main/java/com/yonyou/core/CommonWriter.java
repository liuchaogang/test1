package com.yonyou.core;

import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.service.MipMsgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author chenpana@yonyou.com
 * @ClassName: CommonWriter
 * @Description:
 * @date 2017/8/3 20:36
 */

public class CommonWriter {

    public static UhDcMipMsgLog generateLog(UhDcMipMsgLog msgLog, String processDesc, MessageStatus msgStatus) {
        Assert.notNull(msgStatus, "MessageStatus must not be null");

        msgLog.setMsgStatus(msgStatus.getValue());
        msgLog.setProcessInfo(msgStatus.getDesc() + (processDesc == null ? "" : processDesc));

        return msgLog;
    }
}
