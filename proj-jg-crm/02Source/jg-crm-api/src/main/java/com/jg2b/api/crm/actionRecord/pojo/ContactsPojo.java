package com.jg2b.api.crm.actionRecord.pojo;

import java.util.Date;

public class ContactsPojo {
	/**联系人id*/
	private String ID;
	/**所属客户*/
	private String Owner;
	/**联系人姓名*/
	private String Name;
	/**联系人邮箱*/
	private String Email;
	/**性别*/
	private int Gender;
	/**称呼*/
	private String Title;
	/**联系座机*/
	private String Mobile;
	/**联系电话*/
	private String Telphone;
	/**录入时间*/
	private Date CreateTime;
	/**录入人*/
	private String Creater;
	/**最后修改时间*/
	private Date UpdateTime;
	/**最后修改人*/
	private String Modifer;
	/**备注*/
	private String Description;
	/**删除标识（0.未删除 1.已删除）*/
	private int Deleted;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getTelphone() {
		return Telphone;
	}
	public void setTelphone(String telphone) {
		Telphone = telphone;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public String getCreater() {
		return Creater;
	}
	public void setCreater(String creater) {
		Creater = creater;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public String getModifer() {
		return Modifer;
	}
	public void setModifer(String modifer) {
		Modifer = modifer;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getDeleted() {
		return Deleted;
	}
	public void setDeleted(int deleted) {
		Deleted = deleted;
	}

}
