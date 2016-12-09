package com.jg2b.api.crm.customerManage.bean;

import java.util.Date;
import java.util.List;

import com.jg2b.api.crm.customerManage.pojo.AddressPojo;
import com.jg2b.api.crm.customerManage.pojo.ContactsPojo;
import com.jg2b.api.crm.customerManage.pojo.TracesPojo;

public class CustomerInformationBean {

	private String custGID;

	private Integer compID;

	private Integer contID;

	public Integer getCompID() {
		return compID;
	}

	public void setCompID(Integer compID) {
		this.compID = compID;
	}

	public Integer getContID() {
		return contID;
	}

	public void setContID(Integer contID) {
		this.contID = contID;
	}

	public String getCustGID() {
		return custGID;
	}

	public void setCustGID(String custGID) {
		this.custGID = custGID;
	}

	private Integer custId;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	// Customer
	private String name;// 客户名称
	private Integer level;// 客户级别（1.VI 2. VII 3.VIII）
	private Integer classification;// 客户分类(1.源生 2.跟踪中 3.洽谈 4.签约 5.黑名单)
	private String faxes;// 传真
	private String description;// 描述
	private String creater;// 录入人
	private String channel;// 渠道来源
	private Date createTime;// CHUANGJIANSHIJIAN

	private String owner;

	private int custType;

	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		this.custType = custType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	// Contacts
	private String title;// 称呼
	private String conname;// 联系人姓名
	private String telphone;// 联系电话
	private List<ContactsPojo> contactsList;//
	// Comp_Customers
	private String legal;// 法人
	private Integer capital;// 注册资金
	private String corpKind;// 公司性质
	private String industry;// 所在行业
	// Adress
	private String subscriberID;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	private String region;// 所在区域
	private List<AddressPojo> addressList;// 地址名称

	private List<TracesPojo> tracessList;//

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<ContactsPojo> getContactsList() {
		return contactsList;
	}

	public void setContactsList(List<ContactsPojo> contactsList) {
		this.contactsList = contactsList;
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

	public List<TracesPojo> getTracessList() {
		return tracessList;
	}

	public void setTracessList(List<TracesPojo> tracessList) {
		this.tracessList = tracessList;
	}

}
