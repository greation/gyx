package com.jg2b.seoPojo;

public class SkuInfoPojo {

	private int ID;// id
	private String skuUuid;//
	private String skukey;// 对应属性名称
	private String skuvalue;// 与key形成映射关系相对应的value值
	private int updator;// 修改人
	private int updatetime;// 修改时间
	private int creator;// 创建人
	private int creatertime;// 创建时间
	private int source;// 数据源
	
	
	

	public String getSkukey() {
		return skukey;
	}

	public void setSkukey(String skukey) {
		this.skukey = skukey;
	}

	public String getSkuvalue() {
		return skuvalue;
	}

	public void setSkuvalue(String skuvalue) {
		this.skuvalue = skuvalue;
	}

	public String getSkuUuid() {
		return skuUuid;
	}

	public void setSkuUuid(String skuUuid) {
		this.skuUuid = skuUuid;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}
}
