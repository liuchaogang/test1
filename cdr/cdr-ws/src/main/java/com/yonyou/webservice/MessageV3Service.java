package com.yonyou.webservice;

 

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author chenpana@yonyou.com
 * @ClassName: MessageV3Service
 * @Description: V3消息WS接口
 * @date 2017/5/23 11:21
 */
@WebService(name = "MessageV3Service", // 暴露服务名称
        targetNamespace = "http://webservice.yonyou.com/"
)
public interface MessageV3Service{

    /**
     * 接收消息ws接口
     * @param serviceId 消息类型ID
     * @param msgBody 消息类容
     * @return
     */
    @WebMethod
    String msgRec(@WebParam(name = "serviceId") String serviceId, @WebParam(name = "msgBody") String msgBody);

    /**
     * 接收消息ws接口
     * @param msgId 消息ID
     * @param serviceId 消息类型ID
     * @param msgBody 消息类容
     * @return
     */
    @WebMethod
    String msgRecWs(@WebParam(name = "msgId") String msgId,@WebParam(name = "serviceId") String serviceId, @WebParam(name = "msgBody") String msgBody);
}
