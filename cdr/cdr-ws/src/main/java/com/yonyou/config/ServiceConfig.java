package com.yonyou.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpana@yonyou.com
 * @ClassName: ServiceConfig
 * @Description: 消息业务配置
 * @date 2017/5/23 14:07
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="service")
@PropertySource("classpath:service_mapping.properties")
public class ServiceConfig {

    private static Map<String, String> ids = new HashMap<String, String>();

    public static String getBeanName(String id){
        if(ids.containsKey(id)){
            return ids.get(id);
        }
        return null;
    }

    public Map<String, String> getIds() {
        return ids;
    }

    public void setIds(Map<String, String> ids) {
        ServiceConfig.ids = ids;
    }


}
