package com.jg2b.h5.service;

import com.jg2b.h5.pojo.UserPojo;

/**
 * <p>[描述信息：短信服务接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月4日 下午1:52:59
 */
public interface SmsService {
	
	/**
	 * <p>向短信服务平台发送手机验证码</p>
	 * 
	 * @param phone(发送手机号)
	 * @return String 返回验证码信息
	 * @author:刘毅 
	 * @date: Created on 2016年7月4日 下午1:55:38
	 */
	String sendVerificationCode(String phone);
	
	/**
	 * <p>忘记密码校验用户是否存在</p>
	 * 
	 * @param phone(发送手机号)
	 * @return String 返回验证码信息
	 * @author:刘毅 
	 * @date: Created on 2016年7月4日 下午1:55:38
	 */
	String checkUser(String mobile);
	
}
