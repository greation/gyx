package com.jg2b.common.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DateUtil
{

	public static final String XML_DATE_FORMAT = "yyyyMMddHHmmss";

	public static final String JSON_DATE_FORMAT = "yyyy-MM-dd";
	
	public static final String JSON_DATE_FORMAT2 = "yyyy-MM-dd HH:mm:ss";
	
	
	private static final  ThreadLocal<Map<String,SimpleDateFormat>> threadLocal = new ThreadLocal<Map<String,SimpleDateFormat>>(){
        protected Map<String, SimpleDateFormat> initialValue() {
            return new HashMap<String, SimpleDateFormat>();
        }
    };
    
    
    protected static SimpleDateFormat getFormat(String pattern) {
    	Map<String, SimpleDateFormat> map = threadLocal.get();
    	SimpleDateFormat simpleDateFormat = map.get(pattern);
        if(simpleDateFormat == null) {
        	simpleDateFormat = new SimpleDateFormat(pattern);
        	map.put(pattern, simpleDateFormat);
        }
        return simpleDateFormat;
    }
    
	/**
	 * <p>
	 * 报文日期格式转换:String->Date
	 * </p>
	 * 
	 * @return Date
	 */
	public static Date xmlDate2Date(String stringDate) throws ParseException{
		return getFormat(XML_DATE_FORMAT).parse(stringDate);
	}

	/**
	 * <p>
	 * 报文日期格式转换:Date->String
	 * </p>
	 * 
	 * @return String
	 */
	public static String xmlDate2String(Date date) {
		return getFormat(XML_DATE_FORMAT).format(date);
	}
	
	/**
	 * <p>
	 * 报文日期格式转换:Date->String
	 * </p>
	 * 
	 * @return String
	 */
	public static String xmlDate2String24(Date date) {
		return getFormat(JSON_DATE_FORMAT2).format(date);
	}

	/**
	 * <p>
	 * Json日期格式转换:String->Date
	 * </p>
	 * 
	 * @return Date
	 */
	public static Date jsonDate2Date(String stringDate) throws ParseException {
		return getFormat(JSON_DATE_FORMAT).parse(stringDate);
	}

	/**
	 * Json日期格式转换:Date->String
	 * @return String
	 */
	public static String jsonDate2String(Date date)
	{
		return getFormat(JSON_DATE_FORMAT).format(date);
	}
	
	/**
	 * <p>
	 * Json日期格式转换:Date->String
	 * </p>
	 * 
	 * @return String
	 */
	public static String jsonDate2String24(Date date)
	{
		return getFormat(JSON_DATE_FORMAT2).format(date);
	}

	/***
	 * 保留两位小数的情况 传入的值只能为double foalt
	 * @param str
	 * @return
	 */
	public static String getDecimalFormatByDouble(Object str)
	{
		DecimalFormat df = new DecimalFormat("#####0.00");
		if(str == null)
		{
			return df.format(0);
		}
		return df.format(str);
	}

	public static String exceptionHappenTime(String cause)
	{
		return "(异常发生时间:" + xmlDate2String24(new Date()) + ") (异常产生原因:" + cause + ")";
	}
	/**
	 * 比较两个日期，第一个大返回1，小返回-1 相等返回0   日期格式为 YYYY-MM-DD
	 * @param firstDate 比较的第一个时间
	 * @param secondDate 比较的第二个时间   
	 * @param equalTag   是否包含=，true为包含，false为不包含
	 * @return
	 * @throws ParseException 
	 */
	public static int compareDate(String firstDate,String secondDate) throws ParseException {
			int num  = jsonDate2Date(firstDate).compareTo(jsonDate2Date(secondDate));
			if (num >0 ){
				return 1;
			}else if(num == 0){
				return  0;
			}else{
				return -1;
			}
	}
	/**
	 * 比较两个日期，第一个大返回1，第一个小返回-1 相等返回0   日期格式为 YYYY-MM-DD
	 * @param firstDate 比较的第一个时间
	 * @param secondDate 比较的第二个时间   
	 * @param equalTag   是否包含=，true为包含，false为不包含
	 * @return
	 * @throws ParseException 
	 */
	public static int compareDate(Date firstDate,Date secondDate) throws ParseException {
			int num  = firstDate.compareTo(secondDate);
			if (num >0 ){
				return 1;
			}else if(num == 0){
				return  0;
			}else{
				return -1;
			}
	}
	
	/**
	 * 获取两个日期间天数差额diff，间隔天数interval = diff - 1;
	 * @param after
	 * @param before
	 * @return
	 */
	public static int daysBetweenDates(Date after, Date before) {
		Calendar calAfter = Calendar.getInstance();
		calAfter.setTime(after);
		Calendar calBefore = Calendar.getInstance();
		calBefore.setTime(before);
		
		int diff =-1;
		int diffYears = calAfter.get(Calendar.YEAR) - calBefore.get(Calendar.YEAR);
		
		if(diffYears == 0) {
			diff = calAfter.get(Calendar.DAY_OF_YEAR) - calBefore.get(Calendar.DAY_OF_YEAR);
		}
		
		if(diffYears > 0) {
			int beforePart = calBefore.getActualMaximum(Calendar.DAY_OF_YEAR) - calBefore.get(Calendar.DAY_OF_YEAR);
			
			int middlePart = 0;
			for(int i = 1; i < diffYears; i++) {
				calBefore.add(Calendar.YEAR, 1);
				middlePart += calBefore.getActualMaximum(Calendar.DAY_OF_YEAR);
			}
			
			diff = beforePart + middlePart + calAfter.get(Calendar.DAY_OF_YEAR);
		}
		
		return diff;
	}
	
	
}
