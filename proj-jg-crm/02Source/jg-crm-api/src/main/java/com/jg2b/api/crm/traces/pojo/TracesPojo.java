package com.jg2b.api.crm.traces.pojo;

import java.sql.Timestamp;

import com.jg2b.common.baseBean.BaseBean;

public class TracesPojo extends BaseBean {
	
	private String SubscriberType;
	private String SubscriberID;
	private String Action;
	private String Fields;
	private String Before;
	private String After;
	private String SerialNo;
	private String Creator;
	private Boolean Deleted;
	private Timestamp UpdateTime;

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
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public String getFields() {
		return Fields;
	}

	public void setFields(String fields) {
		Fields = fields;
	}

	public String getBefore() {
		return Before;
	}

	public void setBefore(String before) {
		Before = before;
	}

	public String getAfter() {
		return After;
	}

	public void setAfter(String after) {
		After = after;
	}

	public String getCreator() {
		return Creator;
	}

	public void setCreator(String creator) {
		Creator = creator;
	}



	public Boolean getDeleted() {
		return Deleted;
	}

	public void setDeleted(Boolean deleted) {
		Deleted = deleted;
	}

	public Timestamp getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		UpdateTime = updateTime;
	}

	public String getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}
	
}
