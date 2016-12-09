package com.jg2b.h5.dto;

import java.util.List;

public class CompanyDto {
	private int company_id;// 公司id
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
	private int is_proxy;//是否认证
	private int is_address;//是否实地认证s
	private String map;//百度地图
	private int circle_id;//商圈
	private String logo;//商家Logo
	private int salesman;//递推人员
	private String kindLlists;//类别集合
	private List<String> brandList;//品牌集合
	private String brandLists;//品牌集合（接受前台字符串）
	private List<String> goodsList;//商品集合
	private String  busiLicense;//营业执照
	
	public String getKindLlists() {
		return kindLlists;
	}
	public void setKindLlists(String kindLlists) {
		this.kindLlists = kindLlists;
	}
	public String getBrandLists() {
		return brandLists;
	}
	public void setBrandLists(String brandLists) {
		this.brandLists = brandLists;
	}
	public List<String> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<String> brandList) {
		this.brandList = brandList;
	}
	public String getBusiLicense() {
		return busiLicense;
	}
	public void setBusiLicense(String busiLicense) {
		this.busiLicense = busiLicense;
	}

	public int getIs_proxy() {
		return is_proxy;
	}
	public void setIs_proxy(int is_proxy) {
		this.is_proxy = is_proxy;
	}
	public int getIs_address() {
		return is_address;
	}
	public void setIs_address(int is_address) {
		this.is_address = is_address;
	}
	public List<String> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<String> goodsList) {
		this.goodsList = goodsList;
	}

	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
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
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public int getCircle_id() {
		return circle_id;
	}
	public void setCircle_id(int circle_id) {
		this.circle_id = circle_id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getSalesman() {
		return salesman;
	}
	public void setSalesman(int salesman) {
		this.salesman = salesman;
	}
	

}
