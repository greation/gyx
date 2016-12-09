package com.jg2b.h5.vo;

import com.jg2b.utils.PageRequest;

public class ContactVo {
	
	private int userId;//用户的ID
	private int user_id;//联系的供应商的user_id
	private PageRequest pageRequest;//分页
	
	
	

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
