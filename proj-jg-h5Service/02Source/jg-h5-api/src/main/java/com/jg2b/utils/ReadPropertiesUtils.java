package com.jg2b.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesUtils {
	
	/***
	 * 读取配置文件工具类
	 * @param key
	 * @return String
	 * @author gongjp
	 * @date 2016-07-04 下午 13:31:21
	 */
	public static String readProp(String key){
		Properties prop = new Properties();
		InputStream in = ReadPropertiesUtils.class.getClassLoader().getResourceAsStream("imagepath.properties");
		String value = null;
		try {
			prop.load(in);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}
