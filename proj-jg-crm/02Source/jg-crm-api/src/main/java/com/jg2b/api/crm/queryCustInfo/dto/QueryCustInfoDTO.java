package com.jg2b.api.crm.queryCustInfo.dto;

import com.jg2b.api.crm.queryCustInfo.pojo.CustomerPojo;

public class QueryCustInfoDTO extends CustomerPojo {

	private String lname;// 联系人姓名
	private String email;// 联系人邮箱
	private Integer gender; // 性别
	private String title; // 称呼
	private String mobile; // 联系座机
	private String telphone;// 联系手机
	private String industry;// 所在行业
	private String address;// 地址
	private String region;// 所在区域
	private String userid;// 操作用户id
	private String begintime;
	private String endtime;
	private String conCount;//联系人数
	private String notesCount;//行动记录数
	
	private String uGID;//判断GID
	private String uName;//客服姓名
	private String uMobile;//客服电话
	private Integer uID;//判断客服ID
	
	private String sregion;//条件查询的地区
	private String sindustry;//条件查询的行业
	private String suserID;//条件查询的客服ID
	private String slevel;//条件查询的客户级别
	private String sclassification;//条件查询的客户状态
	private String schannel;//条件查询的客户来源
	
	private Integer tID;//通用ID
	
	

	
	
	 

	public Integer gettID() {
		return tID;
	}

	public void settID(Integer tID) {
		this.tID = tID;
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public String getSregion() {
		return sregion;
	}

	public void setSregion(String sregion) {
		this.sregion = sregion;
	}

	public String getSindustry() {
		return sindustry;
	}

	public void setSindustry(String sindustry) {
		this.sindustry = sindustry;
	}

	public String getSuserID() {
		return suserID;
	}

	public void setSuserID(String suserID) {
		this.suserID = suserID;
	}

	public String getSlevel() {
		return slevel;
	}

	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}

	public String getSclassification() {
		return sclassification;
	}

	public void setSclassification(String sclassification) {
		this.sclassification = sclassification;
	}

 
	public String getSchannel() {
		return schannel;
	}

	public void setSchannel(String schannel) {
		this.schannel = schannel;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuMobile() {
		return uMobile;
	}

	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}

	public String getuGID() {
		return uGID;
	}

	public void setuGID(String uGID) {
		this.uGID = uGID;
	}

	public String getConCount() {
		return conCount;
	}

	public void setConCount(String conCount) {
		this.conCount = conCount;
	}

	public String getNotesCount() {
		return notesCount;
	}

	public void setNotesCount(String notesCount) {
		this.notesCount = notesCount;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
