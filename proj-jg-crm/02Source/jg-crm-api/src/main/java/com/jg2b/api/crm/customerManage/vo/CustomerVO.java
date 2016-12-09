package com.jg2b.api.crm.customerManage.vo;

import java.util.List;

import com.jg2b.api.crm.customerManage.pojo.AddressPojo;

public class CustomerVO {
	// ID
	private Integer custID;
	private Integer contID;
	private Integer compID;

	// GID
	private String custGID;
	private String contGID;
	private String compGID;

	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}

	public Integer getContID() {
		return contID;
	}

	public void setContID(Integer contID) {
		this.contID = contID;
	}

	public Integer getCompID() {
		return compID;
	}

	public void setCompID(Integer compID) {
		this.compID = compID;
	}

	public String getCustGID() {
		return custGID;
	}

	public void setCustGID(String custGID) {
		this.custGID = custGID;
	}

	public String getContGID() {
		return contGID;
	}

	public void setContGID(String contGID) {
		this.contGID = contGID;
	}

	public String getCompGID() {
		return compGID;
	}

	public void setCompGID(String compGID) {
		this.compGID = compGID;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	private String name;// 客户名称
	private Integer custType;// 客户类型(0:采购商,1:供应商)
	private Integer level;// 客户级别（1.VI 2. VII 3.VIII）
	private Integer classification;// 客户分类(1.源生 2.跟踪中 3.洽谈 4.签约 5.黑名单)
	private String faxes;// 传真
	private String creater;// 录入人
	private String channel;// 渠道来源
	private String owner;// 客户所属者
	private String description;// 描述

	private String conname;// 联系人姓名
	private String telphone;// 联系电话
	private String legal;// 法人
	private Integer capital;// 注册资金
	private String corpKind;// 公司性质
	private String industry;// 所在行业
	private String region;// 所在区域
	private Integer orderIndex;// zhucong
	private List<AddressPojo> addressList;// 地址名称

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCustType() {
		return custType;
	}

	public void setCustType(Integer custType) {
		this.custType = custType;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public String getFaxes() {
		return faxes;
	}

	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}

	public String getConname() {
		return conname;
	}

	public void setConname(String conname) {
		this.conname = conname;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCorpKind() {
		return corpKind;
	}

	public void setCorpKind(String corpKind) {
		this.corpKind = corpKind;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<AddressPojo> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressPojo> addressList) {
		this.addressList = addressList;
	}
}
