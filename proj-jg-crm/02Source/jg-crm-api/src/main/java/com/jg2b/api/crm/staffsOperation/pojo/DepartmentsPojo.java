package com.jg2b.api.crm.staffsOperation.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class DepartmentsPojo {

	private String ID;
	private String Code;
	private String Name;
	private String Parent;
	private String Supervisor;
	private String Description;
	private Date CreateTime;
	private Timestamp UpdateTime;
	private Boolean Deleted;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getParent() {
		return Parent;
	}
	public void setParent(String parent) {
		Parent = parent;
	}
	public String getSupervisor() {
		return Supervisor;
	}
	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		UpdateTime = updateTime;
	}
	public Boolean getDeleted() {
		return Deleted;
	}
	public void setDeleted(Boolean deleted) {
		Deleted = deleted;
	}

	
}
