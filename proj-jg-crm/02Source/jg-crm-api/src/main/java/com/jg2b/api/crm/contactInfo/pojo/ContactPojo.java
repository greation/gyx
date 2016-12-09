package com.jg2b.api.crm.contactInfo.pojo;

import com.jg2b.common.baseBean.BaseBean;


public class ContactPojo extends BaseBean{

	private String owner;// 所属客户
	private String name;// 联系人姓名
	private String email;// 联系人邮箱
	private Integer gender; // 性别
	private String title; // 称呼
	private String mobile; // 联系座机
	private String position;//职务
	private String telphone;// 联系手机
	//private Timestamp updateTime; // 录入时间
	//private Date createTime; //
	private String create; // 录入人
	private String description;//描述
	private String modifer;//修改人
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
	
	
	
}
