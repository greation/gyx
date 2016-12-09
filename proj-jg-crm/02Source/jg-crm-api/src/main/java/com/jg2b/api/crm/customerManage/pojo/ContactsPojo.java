package com.jg2b.api.crm.customerManage.pojo;

import java.sql.Timestamp;

import com.jg2b.common.baseBean.BaseBean;

public class ContactsPojo extends BaseBean {
	private String group;// 分组标识(0:主,1:从)
	private String owner;// 所属客户
	private String name;// 联系人姓名
	private String email;// 联系人邮箱
	private Integer gender; // 性别
	private String title; // 称呼
	private String mobile; // 联系座机
	private String telphone;// 联系手机
	private Timestamp updateTime; // 录入时间
	private String modifer; // 最后修改人
	private String creater; // 录入人
	private String description; // 描述
	private Integer deleted; // 删除标识（0.未删除 1.已删除）
	private String position; // 职务

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getModifer() {
		return modifer;
	}

	public void setModifer(String modifer) {
		this.modifer = modifer;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
