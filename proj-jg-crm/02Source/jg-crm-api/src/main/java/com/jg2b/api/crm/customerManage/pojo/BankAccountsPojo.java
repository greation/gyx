package com.jg2b.api.crm.customerManage.pojo;

import java.sql.Timestamp;

import com.jg2b.common.baseBean.BaseBean;

public class BankAccountsPojo extends BaseBean {

	private String owner;// 所属客户
	private String account;// 银行帐号
	private String Bank;// 开户行
	private String BankDetails;// 开户行（具体）
	private Integer AccountType;// 账户类型
	private Timestamp updateTime;//
	private Integer deleted;// 删除标识（0.未删除 1.已删除）

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBank() {
		return Bank;
	}

	public void setBank(String bank) {
		Bank = bank;
	}

	public String getBankDetails() {
		return BankDetails;
	}

	public void setBankDetails(String bankDetails) {
		BankDetails = bankDetails;
	}

	public Integer getAccountType() {
		return AccountType;
	}

	public void setAccountType(Integer accountType) {
		AccountType = accountType;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}
