package com.jg2b.api.crm.queryCustInfo.pojo;

import java.sql.Timestamp;


import com.jg2b.common.baseBean.BaseBean;

public class ContactsPojo extends BaseBean {

	private String id;// 物理主键
	private String owner;// 所属客户
	private String name;// 联系人姓名
	private String email;// 联系人邮箱
	private Integer gender; // 性别
	private String title; // 称呼
	private String mobile; // 联系座机
	private String telphone;// 联系手机
	private Timestamp createTime; // 录入时间
	private String create; // 录入人

	public String getId() {
		return id;
	}
 
	public void setId(String id) {
		this.id = id;
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

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public ContactsPojo(String id, String owner, String name, String email,
			Integer gender, String title, String mobile, String telphone,
			Timestamp createTime, String create) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.title = title;
		this.mobile = mobile;
		this.telphone = telphone;
		this.createTime = createTime;
		this.create = create;
	}

	public ContactsPojo() {
		super();
	}

	@Override
	public String toString() {
		return "Contacts [id=" + id + ", owner=" + owner + ", name=" + name
				+ ", email=" + email + ", gender=" + gender + ", title="
				+ title + ", mobile=" + mobile + ", telphone=" + telphone
				+ ", createTime=" + createTime + ", create=" + create + "]";
	}

}
