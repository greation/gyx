package com.jg2b.api.crm.customerManage.vo;

import java.util.Date;

public class TracesVO {

	private String custID; // 客户id
	private String customerName;// 客户名称
	private String name; // 用户名称
	private Integer action;// 动作类型(0:插入,1:更新,2:删除)
	private String creator;// 操作者(UserID,记录创建者)
	private Date createTime;// 创建时间
	private String text;
	private Date updateTime;
	
	
	 
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
