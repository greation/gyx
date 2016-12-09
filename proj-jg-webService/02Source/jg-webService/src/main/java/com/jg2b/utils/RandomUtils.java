package com.jg2b.utils;

import java.util.Random;

/**
 * 随机生成随机数工具类
 * @author gongjp
 * @date 2016-06-29 上午 11:54
 */
public class RandomUtils {
	public final static String TIPS="生成的随机数位数不正确";
	
	/**
	 * @function       随机生成随机数
	 * @param num      生成几位随机数
	 * @return String  生成的随机数
	 * @author gongjp
	 * @date 2016-06-29 上午 11:54
	 */
	public  static String generatorRandom(int num) {
		if(num<=0) return RandomUtils.TIPS;
		Random random = new Random();
		String result = "";
		for (int i = 1; i <=num; i++) {
			result += random.nextInt(10);
		}
		return result;
	}
}
