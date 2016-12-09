package com.jg2b.api.crm.customerManage.pojo;

import java.sql.Timestamp;
import java.util.Date;

import com.jg2b.common.baseBean.BaseBean;

public class TracesPojo extends BaseBean {

	private String subscriberType;// 数据类型（实体名，或表名）
	private String subscriberID;// 数据ID
	private Integer action;// 动作类型(0:插入,1:更新,2:删除)
	private String fields;// 操作的字段(或属性名)
	private String before;// 更新前的值
	private String after;// 更新后的值
	private String creator;// 操作者(UserID,记录创建者)
	private Timestamp updateTime;// 时间戳
	private Date createTime;// 创建时间
	private Integer deleted;// 删除标识

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}
