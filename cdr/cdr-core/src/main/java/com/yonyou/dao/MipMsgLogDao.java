package com.yonyou.dao;

import com.yonyou.entity.UhDcMipMsgLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenpana@yonyou.com
 * @ClassName: MipMsgLogDao
 * @Description:
 * @date 2017/8/3 9:35
 */

public interface MipMsgLogDao extends JpaRepository<UhDcMipMsgLog,String> {

    UhDcMipMsgLog findByMsgId(String msgId);
}
