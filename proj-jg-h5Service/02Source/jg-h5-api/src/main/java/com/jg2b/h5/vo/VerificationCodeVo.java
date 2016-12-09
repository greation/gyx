package com.jg2b.h5.vo;

import java.io.Serializable;

public class VerificationCodeVo implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6819842705322932163L;

	//验证码
	private String verificationCode;
	//手机号码
	private String phone;
	//验证码类型
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("vo:[verificationCode:").append(verificationCode)
			.append(",phone:").append(phone).append(",type:").append(type).append("]");
		return sb.toString();
	}
	
}
