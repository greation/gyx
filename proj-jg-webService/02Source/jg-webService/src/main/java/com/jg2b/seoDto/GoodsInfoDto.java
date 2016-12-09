package com.jg2b.seoDto;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.SkuInfoPojo;

public class GoodsInfoDto {
	private String skuUuid;
	private int skuId;// skuID
	private String name;// 名称
	private String size;// 型号
	private String unit;// 单位
	private int number;// 数量
	private String material;// sku材质
	private String title;// 标题
	private String brand;// 品牌
	private List<SkuInfoPojo> skuInfoPojo;// sku附表属性
	private List<GoodsInfoPojo> goodsInfoPojo;// goods附表属性
	private String introduce;// 供应商描述
	private String companyUuid;//供应商uuid
	private String goodsUuid;//商品uuid
	private String company;//供应商
	private Object goodsvalue;//拓展属性（json）
	private String image;//图片
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Object getGoodsvalue() {
		return goodsvalue;
	}
	public void setGoodsvalue(String goodsvalue) {
		if(goodsvalue!=null){
			try {
				this.goodsvalue=JSONObject.parse(goodsvalue);
			} catch (Exception e) {
				this.goodsvalue = null;
			}
		}else{
			this.goodsvalue = null;
		}
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGoodsUuid() {
		return goodsUuid;
	}

	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
	}

	public String getCompanyUuid() {
		return companyUuid;
	}

	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	public String getSkuUuid() {
		return skuUuid;
	}

	public void setSkuUuid(String skuUuid) {
		this.skuUuid = skuUuid;
	}

	public void setGoodsInfoPojo(List<GoodsInfoPojo> goodsInfoPojo) {
		this.goodsInfoPojo = goodsInfoPojo;
	}

	public List<SkuInfoPojo> getSkuInfoPojo() {
		return skuInfoPojo;
	}

	public void setSkuInfoPojo(List<SkuInfoPojo> skuInfoPojo) {
		this.skuInfoPojo = skuInfoPojo;
	}

	public List<GoodsInfoPojo> getGoodsInfoPojo() {
		return goodsInfoPojo;
	}

	public void setGoodesInfoPojo(List<GoodsInfoPojo> goodsInfoPojo) {
		this.goodsInfoPojo = goodsInfoPojo;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}