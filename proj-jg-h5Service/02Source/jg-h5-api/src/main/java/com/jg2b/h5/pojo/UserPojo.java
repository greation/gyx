package com.jg2b.h5.pojo;

/**
 * 
* @ClassName: UserPojo 
* @Description: cms_user
* @author bianchenglong
* @date 2016年7月4日 下午12:01:04 
*
 */
public class UserPojo {
	private Integer userId;//主键id
	private String userName;//用户名
	private String passWord;//密码
	private String mobile;//手机号
	private String regIp;//注册ip
	private Integer regTime;//注册时间
	private Integer inquiry;//询价数
	private Integer group;//
	private String contacts;//联系人
	private String company;//公司名称
	private Integer addressId;//默认收货地址
	private Integer status;//用户状态1正常0锁定
	private Integer admin;//代注册管理id
	private Integer companyId;//代注册管理id
	private String sales;//地推（销售）人员ID
	private String mode;//注册来路（pc,system,mobile,app）
	private Integer perfect;//完善，1已完善0未完善
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public Integer getRegTime() {
		return regTime;
	}
	public void setRegTime(Integer regTime) {
		this.regTime = regTime;
	}
	public Integer getInquiry() {
		return inquiry;
	}
	public void setInquiry(Integer inquiry) {
		this.inquiry = inquiry;
	}
	public Integer getGroup() {
		return group;
	}
	public void setGroup(Integer group) {
		this.group = group;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Integer getPerfect() {
		return perfect;
	}
	public void setPerfect(Integer perfect) {
		this.perfect = perfect;
	}
	
	
}
