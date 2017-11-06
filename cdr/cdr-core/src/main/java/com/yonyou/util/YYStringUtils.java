package com.yonyou.util;

import java.util.UUID;

/**
 * @author chenpana@yonyou.com
 * @ClassName: YYStringUtils
 * @Description:
 * @date 2017/6/29 10:24
 */
public class YYStringUtils {

    public static String getUUID(){
       return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
