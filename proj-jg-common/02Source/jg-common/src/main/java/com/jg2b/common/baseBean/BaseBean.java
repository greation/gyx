package com.jg2b.common.baseBean;


import java.util.Date;
import java.util.UUID;

public class BaseBean {
	
	public String GID;//全局ID
	public Integer ID;//自增主键
	public Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}

	public String getGID() {
		return GID;
	}

	public void setGID(String gID) {
		GID = gID;
	}

	public BaseBean(){
		GID =  UUID.randomUUID().toString().replace("-", "");
		createTime = new Date();
	}
	
	
	
}