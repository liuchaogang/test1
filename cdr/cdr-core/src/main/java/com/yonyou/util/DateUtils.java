package com.yonyou.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:DateUtils.java
 * @Description: 
 * @date 2017年7月29日 下午5:37:26
 */
public class DateUtils {
	
	  private static Logger dateUtilsLogger = LoggerFactory.getLogger("DateUtilsLogger");
	
	 private static final String PATTERN_COMPACT_DATETIME = "yyyyMMddHHmmss";
	 private static final String PATTERN_COMPACT_DATETIME_ = "yyyy-MM-dd HH:mm:ss";
	 
	 private static final String PATTERN_COMPACT_DATE = "yyyyMMdd";
	 private static final String PATTERN_COMPACT_DATE_ = "yyyy-MM-dd";

	 
		public static String getDateStr2Str(String date){
			
			String dateFormat=null;
			if(ObjectUtils.isNotEmpty(date) && date.length()!=0){
				if(date.length()==PATTERN_COMPACT_DATE.length()){
					dateFormat=getDateFormat(date);
				}else if(date.length()==PATTERN_COMPACT_DATETIME.length()){
					dateFormat=getDateTimeFormat(date);
				}
				 
			}else{
				dateUtilsLogger.debug("日期为空，无法转换转换标准格式！");
			}
		
			
			return dateFormat;
		}
	 
	
	/**
	 * 由yyyyMMddHHmmss格式变成yyyy-MM-dd HH:mm:ss格式的时间字符串
	 * @param dateTime
	 * @return
	 */
	public static String getDateTimeFormat(String dateTime){
		
		String dateTimeFormat=null;
		 
			try {
				 dateTimeFormat=new SimpleDateFormat(PATTERN_COMPACT_DATETIME_).format(new SimpleDateFormat(PATTERN_COMPACT_DATETIME).parse(dateTime));
				
			} catch (ParseException e) {
				dateUtilsLogger.error("从yyyyMMddHHmmss日期格式转换yyyy-MM-dd HH:mm:ss时报错");
				e.printStackTrace();
			}
		 
	 
		return dateTimeFormat;
	}
	
	/**
	 * 由yyyyMMdd日期格式转换yyyy-MM-dd格式的日期字符串
	 * @param date
	 * @return
	 */
	public static String getDateFormat(String date){
		
		String dateFormat=null;
 
			try {
				 dateFormat=new SimpleDateFormat(PATTERN_COMPACT_DATE_).format(new SimpleDateFormat(PATTERN_COMPACT_DATE).parse(date));
				
			} catch (ParseException e) {
				dateUtilsLogger.error("从yyyyMMdd日期格式转换yyyy-MM-dd时报错");
				e.printStackTrace();
			}
		 
		
		return dateFormat;
	}
	
	   public static Date covertDateTime(String dateStr)   {
	        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_COMPACT_DATETIME_);
	        Date date=null;
	        try {
	        	date=sdf.parse(dateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return date;
	    }

}
