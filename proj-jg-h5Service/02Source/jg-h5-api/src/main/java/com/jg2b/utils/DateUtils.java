package com.jg2b.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class DateUtils {
	
	/**
	 * 将当前时间转换成对应的时间戳
	 * @return
	 * @author gongjp
	 * @date 2016-07-04 下午 18:36:21
	 */
	public  static String formatCurrentDate(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	/**
	 * 返回当前时间的毫秒数
	 * @return
	 * @author gongjp
	 * @date 2016-07-05
	 */
	public static long transfromCurentDateToLong(){
		return new Date().getTime();
	}
	
	
	/**
	 * 比较当前时间和传入的时间戳
	 * @param time
	 * @return
	 * @author gongjp
	 * @date 2016-07-05
	 */
	public static boolean  compareCurrentTimeWithParameterTime(String time){
		Long ctime = null;
		if(StringUtils.isNotBlank(time)){
			ctime=Long.parseLong(time);
		}
		if(ctime>transfromCurentDateToLong()){
			return true;
		}else{
			return false;
		}
	}
}
