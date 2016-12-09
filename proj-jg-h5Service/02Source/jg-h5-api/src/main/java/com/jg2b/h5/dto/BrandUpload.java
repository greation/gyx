package com.jg2b.h5.dto;

public class BrandUpload {
	private int user_id;//用户ID
	private String pic;//上传的图片
	private int status;//状态0申请1
	private int add_time;//申请时间
	private int audit_time;//审核时间
	private String reason ;//审核不通过原因
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
