package com.jg2b.common.utils;

import org.springframework.beans.BeanUtils;

/**
 * 基本工具类
 * @author zhangyaotang
 * @version 1.0 Created on 2016年5月4日
 */
public class BaseUtil {
	
	public BaseUtil() {
	}

	public static <T> T  vo2DTO(Object obj,Class<T> cls) throws Exception{
    	T t;
		try {
			t = cls.newInstance();
			BeanUtils.copyProperties(obj, t);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception("VO2DTO转换异常："+e);
		}
    	return t;
    }
}
