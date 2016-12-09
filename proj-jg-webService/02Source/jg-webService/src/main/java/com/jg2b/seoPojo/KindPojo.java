package com.jg2b.seoPojo;

public class KindPojo {
	private int ID;//id
	private String kindUuid;//uuid
	private String name;//分类名称
	private int creator;//创建人
	private int  creatertime;//创建时间
	private int updator;//更新人
	private int updatetime;//更新时间
	private int sources;//数据来源
	private int  deleted;//删除
	private int code;//编号
	private String parentId;//父级类目
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getKindUuid() {
		return kindUuid;
	}
	public void setKindUuid(String kindUuid) {
		this.kindUuid = kindUuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public int getCreatertime() {
		return creatertime;
	}
	public void setCreatertime(int creatertime) {
		this.creatertime = creatertime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public int getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(int updatetime) {
		this.updatetime = updatetime;
	}
	public int getSources() {
		return sources;
	}
	public void setSources(int sources) {
		this.sources = sources;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
	

}
