package com.jg2b.seoPojo;

public class FactoryPojo {
	private  int ID;//id
	private String factoryUuid;//uuid
	private String  name;//工厂名称
	private String	address;//地址
	private int creator;//创建人
	private int creatertime;//创建时间
	private int updator;//更新人
	private int updatetime;//更新时间
	private int deleted;//是否有效 1为有效0为无效
	private int sources;//数据来源
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFactoryUuid() {
		return factoryUuid;
	}
	public void setFactoryUuid(String factoryUuid) {
		this.factoryUuid = factoryUuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getSources() {
		return sources;
	}
	public void setSources(int sources) {
		this.sources = sources;
	}
	
	


}
