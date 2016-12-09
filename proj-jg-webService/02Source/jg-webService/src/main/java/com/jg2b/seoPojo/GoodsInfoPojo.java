package com.jg2b.seoPojo;

public class GoodsInfoPojo{
	private int id;// id
	private String goodsUuid;//goodsUuid
	private String goodskey;// 对应属性名称
	private String goodsvalue;// 与key形成映射关系相对应的value值
	private int updator;// 修改人
	private int updatetime;// 修改时间
	private int creator;// 创建人
	private int creatertime;// 创建时间
	private int source;// 数据源
	private int deleted;// 删除标示(0.是，1否)

	public String getGoodsUuid() {
		return goodsUuid;
	}

	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getGoodskey() {
		return goodskey;
	}

	public void setGoodskey(String goodskey) {
		this.goodskey = goodskey;
	}

	public String getGoodsvalue() {
		return goodsvalue;
	}

	public void setGoodsvalue(String goodsvalue) {
		this.goodsvalue = goodsvalue;
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

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}