package com.yonyou.util;

/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:ObjectUtils.java
 * @Description: 
 * @date 2017年8月12日 下午5:01:18
 */
public class ObjectUtils {
	
	//判断对象是否为空
	  public static boolean isNotEmpty(Object object) {
	        return !isEmpty(object);
	    }
	  
		//判断对象是否为空
	  public static boolean isEmpty(Object object) {
	        return object == null;
	    }

}
