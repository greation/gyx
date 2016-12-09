package com.jg2b.vo;


public class BrandVo {
	private String  brandUuid;//品牌uuid
	private String  goodsUuid;//商品uuid
	private String kindUuid;//分类Uuid
	
	
	public String getKindUuid() {
		return kindUuid;
	}

	public void setKindUuid(String kindUuid) {
		this.kindUuid = kindUuid;
	}

	public String getGoodsUuid() {
		return goodsUuid;
	}

	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
	}

	public String getBrandUuid() {
		return brandUuid;
	}

	public void setBrandUuid(String brandUuid) {
		this.brandUuid = brandUuid;
	}
}
