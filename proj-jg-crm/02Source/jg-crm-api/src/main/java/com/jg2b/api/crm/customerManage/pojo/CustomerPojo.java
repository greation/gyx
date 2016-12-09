package com.jg2b.api.crm.customerManage.pojo;

import java.sql.Timestamp;
import java.util.Date;

import com.jg2b.common.baseBean.BaseBean;

/**
 * 
 * @author 卞成龙
 * 
 */
public class CustomerPojo extends BaseBean {

	private String name; // 客户名称
	private Integer custType; // 客户类型
	private Integer credits; // 客户信用度
	private Integer actives; // 客户活跃度
	private Integer classification; // 客户分类(1.源生 2.跟踪中 3.洽谈 4.签约 5.黑名单)
	private Integer level; // 客户级别
	private String faxes; // 传真
	private String introduce; // 简介
	private String creater; // 录入人
	private Timestamp updateTime; // 最后修改时间
	private String channel;// 渠道来源

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	private String modifer; // 最后修改人
	private String owner; // 客户所有者
	private String signer; // 签约人
	private Date signTime; // 签约时间
	private String auditer; // 审核人
	private Timestamp auditerTime; // 审核时间
	private String description; // 描述
	private Integer deleted; // 删除标识（0.未删除 1.已删除）

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

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getActives() {
		return actives;
	}

	public void setActives(Integer actives) {
		this.actives = actives;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getFaxes() {
		return faxes;
	}

	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getModifer() {
		return modifer;
	}

	public void setModifer(String modifer) {
		this.modifer = modifer;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getAuditer() {
		return auditer;
	}

	public void setAuditer(String auditer) {
		this.auditer = auditer;
	}

	public Timestamp getAuditerTime() {
		return auditerTime;
	}

	public void setAuditerTime(Timestamp auditerTime) {
		this.auditerTime = auditerTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}
