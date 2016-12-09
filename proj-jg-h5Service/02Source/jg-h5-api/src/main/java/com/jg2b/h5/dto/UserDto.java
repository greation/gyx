package com.jg2b.h5.dto;
/**
 * 
* @ClassName: UserDto 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bianchenglong
* @date 2016年7月4日 下午12:01:04 
*
 */
public class UserDto {

		private String userId;//主键id
		private String userUuId;//关联id
		private String userName;//用户名
		private String passWord;//密码
		private String mobile;//手机号
		private String reg_ip;//注册ip
		private Integer reg_time;//注册时间
		private Integer inquiry;//询价数
		private Integer group;//0求购商1供应商2同城调货
		private String contacts;//联系人
		private String company;//公司名称
		private Integer address_id;//默认收货地址
		private Integer status;//用户状态1正常0锁定
		private Integer admin;//代注册管理id
		private Integer company_id;//代注册管理id
		private String sales;//
		private String mode;//注册来路（pc,system,mobile,app）
		
		private String companyUuid;//供应商uuid
		
		public Integer getReg_time() {
			return reg_time;
		}
		public void setReg_time(Integer reg_time) {
			this.reg_time = reg_time;
		}
		public Integer getAddress_id() {
			return address_id;
		}
		public void setAddress_id(Integer address_id) {
			this.address_id = address_id;
		}
		public Integer getCompany_id() {
			return company_id;
		}
		public void setCompany_id(Integer company_id) {
			this.company_id = company_id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserUuId() {
			return userUuId;
		}
		public void setUserUuId(String userUuId) {
			this.userUuId = userUuId;
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
	
		public String getReg_ip() {
			return reg_ip;
		}
		public void setReg_ip(String reg_ip) {
			this.reg_ip = reg_ip;
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
	
		public String getCompanyUuid() {
			return companyUuid;
		}
		public void setCompanyUuid(String companyUuid) {
			this.companyUuid = companyUuid;
		}

}
