package com.yonyou.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpana@yonyou.com
 * @ClassName: DtoConfig
 * @Description:
 * @date 2017/5/23 15:41
 */
@Configuration
@ConfigurationProperties(prefix="dto")
@PropertySource("classpath:service_mapping.properties")
public class DtoConfig{
    private static Map<String, String> ids = new HashMap<String, String>();

    public static String getClassName(String id){
        if(ids.containsKey(id)){
            return ids.get(id);
        }
        return null;
    }

    public Map<String, String> getIds() {
        return ids;
    }

    public void setIds(Map<String, String> ids) {
        DtoConfig.ids = ids;
    }
}