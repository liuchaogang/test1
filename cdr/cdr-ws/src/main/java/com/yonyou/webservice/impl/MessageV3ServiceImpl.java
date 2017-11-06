package com.yonyou.webservice.impl;

 
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

 
import com.yonyou.config.DtoConfig;
import com.yonyou.config.ServiceConfig;
import com.yonyou.core.MessageProcessThread;
import com.yonyou.hl7adapter.message.data.BaseDTO;
import com.yonyou.hl7adapter.message.factory.MessageFactory;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.util.SpringUtils;
import com.yonyou.webservice.MessageV3Service;
import com.yonyou.writer.BaseProcessWriter;
 
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.yonyou.config.DtoConfig;
import com.yonyou.config.ServiceConfig;
import com.yonyou.core.MessageProcessThread;
import com.yonyou.webservice.MessageV3Service;

/**
 * @author chenpana@yonyou.com
 * @ClassName: MessageV3ServiceImpl
 * @Description:
 * @date 2017/5/23 11:24
 */
@WebService(name = "MessageV3Service", // 暴露服务名称
        targetNamespace = "http://webservice.yonyou.com/",// 命名空间,一般是接口的包名倒序
        endpointInterface = "com.yonyou.webservice.MessageV3Service"
)
public class MessageV3ServiceImpl extends SpringBeanAutowiringSupport implements MessageV3Service  {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WebServiceContext wsContext;

 
 
    MipMsgLogService msgLogService;

    public void setMsgLogService(MipMsgLogService msgLogService) {
        this.msgLogService = msgLogService;
    }

 
    public String msgRec(String serviceId, String messgeBody) {

        if (StringUtils.isEmpty(serviceId) || StringUtils.isEmpty(messgeBody)) {
            return "0:请检查参数";
        }
        //业务处理的bean名称
        String beanName = ServiceConfig.getBeanName(serviceId);
        //消息对应的实体类名，包括包名
        String className = DtoConfig.getClassName(serviceId);

        if (StringUtils.isEmpty(beanName) || StringUtils.isEmpty(className)) {
            return "0:服务暂不支持";
        }

        try {

            /* Thread 处理*/
            /*BaseDTO dto = (BaseDTO) Class.forName(className).newInstance();

            MessageFactory.parsexml2DTO(messgeBody, dto, "xpath/" + beanName);

            BaseProcessWriter<BaseDTO> msgWriter = (BaseProcessWriter<BaseDTO>) SpringUtils.getBean(beanName);

            Object valid = null;*/

 
           
 
            MessageProcessThread processThread = new MessageProcessThread(beanName,className,messgeBody);
 
        
 
            processThread.start();

            return "消息正在处理";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String msgRecWs(String msgId, String serviceId, String msgBody) {
        if (StringUtils.isEmpty(serviceId) || StringUtils.isEmpty(msgBody)) {
            return "0:请检查参数";
        }
        //业务处理的bean名称
        String beanName = ServiceConfig.getBeanName(serviceId);
        //消息对应的实体类名，包括包名
        String className = DtoConfig.getClassName(serviceId);

        if (StringUtils.isEmpty(beanName) || StringUtils.isEmpty(className)) {
            return "0:服务暂不支持";
        }

        try {

            MessageProcessThread processThread = new MessageProcessThread(msgId, beanName, className, msgBody, msgLogService);
            processThread.start();

            return "消息正在处理";

        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
