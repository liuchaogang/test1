package com.yonyou.config;

import com.yonyou.service.MipMsgLogService;
import com.yonyou.webservice.impl.MessageV3ServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author chenpana@yonyou.com
 * @ClassName: CxfConfig
 * @Description: cxf配置
 * @date 2017/6/27 9:04
 */
@Configuration
public class CxfConfig {
 /*@Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/yonyou-ws*//*");
    }*/

    @Autowired
    private Bus bus;

    @Autowired
    MipMsgLogService msgLogService;

    @Bean
    public Endpoint endpoint() {
        MessageV3ServiceImpl MessageV3ServiceImpl = new MessageV3ServiceImpl();
        MessageV3ServiceImpl.setMsgLogService(msgLogService);
        EndpointImpl endpoint = new EndpointImpl(bus, MessageV3ServiceImpl);
        endpoint.publish("/MessageV3Service");
        //入日志拦截器
       /* endpoint.getInInterceptors().add(new LoggingInInterceptor());*/
        //自定义拦截器
        //endpoint.getOutInterceptors().add(new CxfCusInterceptor(Phase.MARSHAL));

        return endpoint;
    }
}
