package com.jg2b.h5.vo;

import java.io.Serializable;

/**
 * <p>[描述信息：重置密码 修改密码请求实体]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月5日 下午3:17:30
 */
public class ModifiedPwdVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -425407515967100027L;
	private String mobile;//注册手机号码
	private String password;//密码
	private String modified_type;//修改类型
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getModified_type() {
		return modified_type;
	}
	public void setModified_type(String modified_type) {
		this.modified_type = modified_type;
	}
	
}
