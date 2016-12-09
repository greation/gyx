package com.jg2b.h5.dto;

import java.util.List;

public class UserDetailDto {
	
	private Integer user_id;//用户ID
	private Integer company_id;//公司ID
	private Integer id;//商圈ID
	private String username;//个人姓名
	private String mobile;//手机号
	private String companyName;//公司名字
	private int province;//省
	private int city;//市
	private int region;//区
	private String address;//详细地址
	private String contacts;//联系人
	private String phone;//公司电话
	private List<String> categoryList;//经营品类
	private List<String> brandList;//经营品牌
	private String circle;//所在商圈名字
	private String license;//营业执照
	private String area;//地区
	private int is_proxy;//是否认证
	private int is_address;//是否实地认证
	
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
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public List<String> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<String> brandList) {
		this.brandList = brandList;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	

}
