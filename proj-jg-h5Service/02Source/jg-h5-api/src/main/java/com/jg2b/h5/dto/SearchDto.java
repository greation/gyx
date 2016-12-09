package com.jg2b.h5.dto;

public class SearchDto {
	private int  company_id;//公司id
	private String company;//公司名称
	private String title;//标题
	private int ty;//首页动态表示0代表搜索方 1为供应商
	private int mins;//计算后时间（分钟）
	
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = mins;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTy() {
		return ty;
	}
	public void setTy(int ty) {
		this.ty = ty;
	}
	

}
