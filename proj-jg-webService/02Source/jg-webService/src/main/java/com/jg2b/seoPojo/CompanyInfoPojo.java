package com.jg2b.seoPojo;

/**
 * <p>
 * [描述信息：供应商信息实体]
 * </p>
 * 
 * @author 刘毅
 * @version 1.0 Created on 2016年6月28日 下午2:17:21
 */
public class CompanyInfoPojo {
	private int company_id;// 公司id
	private String companyUuid;// uuid
	private int user_id;// 用户id
	private String company;// 供应商
	private String address;// 地址
	private int province;// 省份
	private int city;// 城市
	private int region; // 地区
	private String email;// 邮箱
	private String contacts;// 联系人
	private String mobile;// 电话
	private String phone;// 手机
	private String website;// 网址
	private String capital;// 注册资金
	private int offer;// 报价次数
	private int status;// 0未审核1审核通过
	private int commend;// 推荐0不推荐1推荐
	private String verify_note;// 审核备注
	private String out_inquiry;// 屏蔽的询价单
	private int add_time;// 加入时间
	private int admin;// 管理员
	private String mode2;// 注册来路
	private int managementModel;// 经营模式(0,厂家直销,1供应商,2，经销批发)
	private String introduce;// 介绍
	private String businessScope;// 公司经营范围
	/**第二批新加字段*/
	private String main_products_server;// 主营产品或服务
	private String main_business ;//主营行业
	private int is_customizing ;//是否提供加工定制 0是1不是
	private String employee_num ;//员工人数
	private String server_business ;//服务行业
	private String main_market ;//主要市场
	private String main_consumer ;//主要客户
	private String storage_area ;//仓库面积
	private String yearly_turnover ;//年营业额
	private String createdOn ;//成立时间 

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompanyUuid() {
		return companyUuid;
	}

	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCommend() {
		return commend;
	}

	public void setCommend(int commend) {
		this.commend = commend;
	}

	public String getVerify_note() {
		return verify_note;
	}

	public void setVerify_note(String verify_note) {
		this.verify_note = verify_note;
	}

	public String getOut_inquiry() {
		return out_inquiry;
	}

	public void setOut_inquiry(String out_inquiry) {
		this.out_inquiry = out_inquiry;
	}

	public int getAdd_time() {
		return add_time;
	}

	public void setAdd_time(int add_time) {
		this.add_time = add_time;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getMode2() {
		return mode2;
	}

	public void setMode2(String mode2) {
		this.mode2 = mode2;
	}

	public int getManagementModel() {
		return managementModel;
	}

	public void setManagementModel(int managementModel) {
		this.managementModel = managementModel;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getMain_products_server() {
		return main_products_server;
	}

	public void setMain_products_server(String main_products_server) {
		this.main_products_server = main_products_server;
	}

	public String getMain_business() {
		return main_business;
	}

	public void setMain_business(String main_business) {
		this.main_business = main_business;
	}

	public int getIs_customizing() {
		return is_customizing;
	}

	public void setIs_customizing(int is_customizing) {
		this.is_customizing = is_customizing;
	}

	public String getEmployee_num() {
		return employee_num;
	}

	public void setEmployee_num(String employee_num) {
		this.employee_num = employee_num;
	}

	public String getServer_business() {
		return server_business;
	}

	public void setServer_business(String server_business) {
		this.server_business = server_business;
	}

	public String getMain_market() {
		return main_market;
	}

	public void setMain_market(String main_market) {
		this.main_market = main_market;
	}

	public String getMain_consumer() {
		return main_consumer;
	}

	public void setMain_consumer(String main_consumer) {
		this.main_consumer = main_consumer;
	}

	public String getStorage_area() {
		return storage_area;
	}

	public void setStorage_area(String storage_area) {
		this.storage_area = storage_area;
	}

	public String getYearly_turnover() {
		return yearly_turnover;
	}

	public void setYearly_turnover(String yearly_turnover) {
		this.yearly_turnover = yearly_turnover;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	
}
