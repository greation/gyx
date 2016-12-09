package com.jg2b.api.crm.customerManage.pojo;

import java.sql.Timestamp;
import java.util.Date;

import com.jg2b.common.baseBean.BaseBean;

public class CodesPojo extends BaseBean {
	private String category;// 代码大类
	private String parent;// 上级代码
	private String code;// 代码编号
	private String caption;// 代码标题
	private Integer level;// 代码层级
	private String isVirtual;// 是否虚拟层级
	private String description;// 代码描述
	private String deleted;// 删除标识
	private Timestamp updateTime;//
	private Date createTime;//

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
