package com.yonyou.writer;

/**
 * @author chenpana@yonyou.com
 * @ClassName: BaseProcessWriter
 * @Description: 消息接收处理基类接口
 * @date 2017/6/27 9:10
 */
public interface BaseProcessWriter<T> {

    /**
     * 校验消息内容
     * @param t
     * @param reMsg
     * @return
     */
    boolean validation(T t, Object reMsg);

    /**
     * 消息依赖校验
     * @param t
     * @return
     */
    boolean checkPre(T t);

    /**
     * 业务处理，数据库写入
     * @param t
     */
    void businessWrite(T t);
}
