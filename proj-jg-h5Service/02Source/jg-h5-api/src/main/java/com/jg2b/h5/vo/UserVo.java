package com.jg2b.h5.vo;

import com.jg2b.h5.dto.UserDto;

public class UserVo {

	private UserDto userDto;
	private String mobile;//注册手机号码
	private String password;//密码

	public  UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	

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
	

}
