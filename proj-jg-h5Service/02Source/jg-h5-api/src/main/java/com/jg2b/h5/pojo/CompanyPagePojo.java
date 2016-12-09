package com.jg2b.h5.pojo;

import java.util.List;

public class CompanyPagePojo {
	private int company_id;
	private String user_id;
	private String company;
	private String address;
	private String commend;
	private String is_proxy;
	private String is_address;
	private String contacts;
	private String mobile ;
	List<ProductPojo> products;
	List<String> goodsList;
	List<String> brandList;
	private String uploadImg;//TRUE支持上传 FALSE不支持上传
	
	public String getUploadImg() {
		return uploadImg;
	}
	public void setUploadImg(String uploadImg) {
		this.uploadImg = uploadImg;
	}
	public List<String> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<String> goodsList) {
		this.goodsList = goodsList;
	}
	public List<String> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<String> brandList) {
		this.brandList = brandList;
	}
	
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
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
	public String getCommend() {
		return commend;
	}
	public void setCommend(String commend) {
		this.commend = commend;
	}
	public String getIs_proxy() {
		return is_proxy;
	}
	public void setIs_proxy(String is_proxy) {
		this.is_proxy = is_proxy;
	}
	public String getIs_address() {
		return is_address;
	}
	public void setIs_address(String is_address) {
		this.is_address = is_address;
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
	public List<ProductPojo> getProducts() {
		return products;
	}
	public void setProducts(List<ProductPojo> products) {
		this.products = products;
	}
	
}
