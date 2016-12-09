package com.jg2b.api.crm.contactInfo.pojo;

import java.sql.Timestamp;
import java.util.Date;

import com.jg2b.common.baseBean.BaseBean;


public class AddressPojo extends BaseBean{
	private String owner;// 所属客户
	private String refID;// 引用的ID
	private String subscriberType;// 订阅者类型
	private String subscriberID;// 订阅者ID
	private String group;// 地址分组
	private String name;// 地址名称
	private String region;// 所在区域
	private String address;// 详细地址
	private String zip;// 邮政编码
	private Date createTime;// 创建时间
	private Timestamp UpdateTime; 
	private Boolean Deleted;// 所属客户
	
	
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRefID() {
		return refID;
	}
	public void setRefID(String refID) {
		this.refID = refID;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
