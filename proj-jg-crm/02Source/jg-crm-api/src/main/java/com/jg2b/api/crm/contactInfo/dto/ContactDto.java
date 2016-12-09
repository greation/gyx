package com.jg2b.api.crm.contactInfo.dto;

import com.jg2b.common.baseBean.BaseBean;

 


public class ContactDto extends BaseBean{

	private String owner;// 所属客户
	private String name;// 联系人姓名
	private String email;// 联系人邮箱
	private Integer gender; // 性别
	private String title; // 称呼
	private String mobile; // 联系座机
	private String position;//职务
	private String telphone;// 联系手机
	 
	private String create; // 录入人
	private String description;//描述
	private String modifer;//修改人
	
	
	private String addowner;// 所属客户
	private String refID;// 引用的ID
	private String subscriberType;// 订阅者类型
	private String subscriberID;// 订阅者ID
	private String group;// 地址分组
	private String addName;// 地址名称
	private String region;// 所在区域
	private String address;// 详细地址
	private String zip;// 邮政编码
	
	private String userId;//客服ID
	
	private String generalID;//通用ID
	private String generalName;//通用姓名
	
	private String yID;//单独ID
	
	
	
	
 
	public String getyID() {
		return yID;
	}
	public void setyID(String yID) {
		this.yID = yID;
	}
	public String getGeneralName() {
		return generalName;
	}
	public void setGeneralName(String generalName) {
		this.generalName = generalName;
	}
	public String getGeneralID() {
		return generalID;
	}
	public void setGeneralID(String generalID) {
		this.generalID = generalID;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModifer() {
		return modifer;
	}
	public void setModifer(String modifer) {
		this.modifer = modifer;
	}
	public String getAddowner() {
		return addowner;
	}
	public void setAddowner(String addowner) {
		this.addowner = addowner;
	}
	public String getRefID() {
		return refID;
	}
	public void setRefID(String refID) {
		this.refID = refID;
	}
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
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getAddName() {
		return addName;
	}
	public void setAddName(String addName) {
		this.addName = addName;
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
	public ContactDto() {
		super();
	}
	
}
