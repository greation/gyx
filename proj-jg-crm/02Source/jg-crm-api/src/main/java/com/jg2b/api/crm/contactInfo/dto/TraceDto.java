package com.jg2b.api.crm.contactInfo.dto;

import java.util.Date;

public class TraceDto {
	private String SubscriberType;
	private String SubscriberID;
	private String action;
	private String before;
	private String after;
	private String creator;
	private String createTime;
	private Date UpdateTime;
	private String field;
	private String text;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getSubscriberType() {
		return SubscriberType;
	}
	public void setSubscriberType(String subscriberType) {
		SubscriberType = subscriberType;
	}
	public String getSubscriberID() {
		return SubscriberID;
	}
	public void setSubscriberID(String subscriberID) {
		SubscriberID = subscriberID;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public String getAfter() {
		return after;
	}
	public void setAfter(String after) {
		this.after = after;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	 
	
}
