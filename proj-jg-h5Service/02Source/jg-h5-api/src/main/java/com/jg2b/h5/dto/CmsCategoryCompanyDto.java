package com.jg2b.h5.dto;

public class CmsCategoryCompanyDto {
	private  int user_id;//供应商ID
	private  int c_id;//供应商主营分类id
	private  int status;//状态0审核1通过2不通过
	private  int add_time;//申请时间
	private  int audit_time;//审核时间 
	private  String reason;//审核不通过原因 
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAdd_time() {
		return add_time;
	}
	public void setAdd_time(int add_time) {
		this.add_time = add_time;
	}
	public int getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(int audit_time) {
		this.audit_time = audit_time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	

}
