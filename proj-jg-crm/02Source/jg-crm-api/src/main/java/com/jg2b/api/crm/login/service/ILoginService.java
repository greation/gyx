package com.jg2b.api.crm.login.service;

import java.util.List;

import com.jg2b.api.crm.login.pojo.UserPojo;

/**
 * <p>[描述信息：登录功能接口]</p>
 *
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月5日 下午1:56:55
 */
public interface ILoginService {
	
	/**
	 * <p>用户名密码登录校验查询</p>
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年5月5日 下午1:55:14
	 */
	List<UserPojo> searchUser(String userName,String pwd);

}
