package com.yonyou.core;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.service.MipMsgLogService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.yonyou.hl7adapter.message.data.BaseDTO;
import com.yonyou.hl7adapter.message.factory.MessageFactory;
import com.yonyou.util.SpringUtils;
import com.yonyou.writer.BaseProcessWriter;


/**
 * @author chenpana@yonyou.com
 * @ClassName: MessageProcessThread
 * @Description: 消息业务处理
 * @date 2017/6/27 14:58
 */
public class MessageProcessThread extends Thread {

    private static Logger log = LoggerFactory.getLogger("MessageProcessThreadLogger");

    private String beanName;

    private String className;

    private String messageBody;

    private String msgId;

    private MipMsgLogService msgLogService;

    public MessageProcessThread(String beanName, String className, String messgeBody) {
        this.beanName = beanName;
        this.className = className;
        this.messageBody = messgeBody;
    }

    public MessageProcessThread(String msgId, String beanName, String className, String msgBody, MipMsgLogService msgLogService) {
        this.beanName = beanName;
        this.className = className;
        this.messageBody = msgBody;
        this.msgId = msgId;
        this.msgLogService = msgLogService;
    }

    @Override
    public void run() {

        BaseDTO dto = null;
        UhDcMipMsgLog msgLog = msgLogService.getMsgLogByMsgId(msgId);

        if (msgLog != null) {
            log.error("消息ID{}，消息已存在，请勿重复发送",msgId);
        } else {
            msgLog = new UhDcMipMsgLog();
            msgLog.setMsgId(msgId);
            msgLog.setMsgContent(this.messageBody);
            try {

                dto = (BaseDTO) Class.forName(className).newInstance();

                MessageFactory.parsexml2DTO(messageBody, dto, "/xpath/" + beanName);

                if (StringUtils.isNotEmpty(msgId))
                    dto.setMsgId(msgId);

                String jsonString = JSON.toJSONString(dto, SerializerFeature.PrettyFormat);

                log.debug("消息实体内容:" + jsonString);

                BaseProcessWriter<BaseDTO> msgWriter = (BaseProcessWriter<BaseDTO>) SpringUtils.getBean(beanName);


                msgLog.setDtoName(dto.toString());
                msgLog.setServiceId(dto.getTemplate());
                msgLog.setMsgStatus("0");
                msgLog.setMsgWriter(msgWriter.toString());

                msgLog.setJsonContent(jsonString);

                msgLogService.saveMsgLog(CommonWriter.generateLog(msgLog, null, MessageStatus.OK));

                Object validRes = null;
                log.debug("消息类型：{}", beanName);

                //消息内容、格式验证
                log.debug("消息校验……");
                if (msgWriter.validation(dto, validRes)) {
                    //消息依赖校验
                    log.debug("依赖校验……");
                    if (msgWriter.checkPre(dto)) {
                        //消息业务处理
                        log.debug("业务处理……");
                        msgWriter.businessWrite(dto);
                    }

                }


            } catch (InstantiationException e) {
                saveLog(msgLog, e);
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                saveLog(msgLog, e);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                saveLog(msgLog, e);
                e.printStackTrace();
            } catch (Exception e) {
                saveLog(msgLog, e);
                e.printStackTrace();
            }
        }


    }

    void saveLog(UhDcMipMsgLog msgLog, Exception e) {
        msgLogService.saveMsgLog(CommonWriter.generateLog(msgLog, e.toString(), MessageStatus.EXCEPTION));
    }
}
