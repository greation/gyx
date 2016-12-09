package com.jg2b.api.crm.customerManage.pojo;

import java.sql.Timestamp;

import com.jg2b.common.baseBean.BaseBean;

public class CompCustomersPojo extends BaseBean {

	private String legal;// 法人
	private Integer capital; // 注册资金
	private String corpKind;// 公司性质
	private String industry;// 所在行业
	private String website;// 公司网址
	private Integer staffs;// 员工数
	private String description;// 备注
	private Timestamp updateTime; // 录入时间
	private int Deleted; // 删除标识（0.未删除 1.已删除）

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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getStaffs() {
		return staffs;
	}

	public void setStaffs(Integer staffs) {
		this.staffs = staffs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getDeleted() {
		return Deleted;
	}

	public void setDeleted(int deleted) {
		Deleted = deleted;
	}

}
