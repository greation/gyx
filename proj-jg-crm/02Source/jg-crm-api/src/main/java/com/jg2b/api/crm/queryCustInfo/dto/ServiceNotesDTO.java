package com.jg2b.api.crm.queryCustInfo.dto;

import com.jg2b.api.crm.queryCustInfo.pojo.ServiceNotesPojo;

public class ServiceNotesDTO extends ServiceNotesPojo{
	// 扩充字段
	private String name;
	// 用户
	private String a;
	// 扩充字段
	private String uname;//客户名称

	public String getA() {
		return a;
	}
 
	public void setA(String a) {
		this.a = a;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
