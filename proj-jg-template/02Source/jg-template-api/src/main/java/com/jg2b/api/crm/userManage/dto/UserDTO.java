package com.jg2b.api.crm.userManage.dto;

import java.io.Serializable;


public class UserDTO implements Serializable{
	
	private Integer id;

	private String uname;

	private String upwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
