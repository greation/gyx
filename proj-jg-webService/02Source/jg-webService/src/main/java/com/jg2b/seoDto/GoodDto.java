package com.jg2b.seoDto;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.SkuInfoPojo;

public class GoodDto {
	private String brandUuid;//
	private String goodsUuid;
	private String skuUuid;// SKU关联id
	private String companyUuid;// 供应商关联Id
	private int factoryId;// 厂家id
	private int companyId;// 供应商Id
	private int skuId;// skuID
	private String title;// 标题
	private String brandName;// 品牌
	private String name;// 商品名称
	private String size;// 型号
	private String material;// 材质
	private String company;// 供应商
	private String fatoryInfo;// 厂家
	private List<SkuInfoPojo> skuInfoPojo;// sku附表属性
	private List<GoodsInfoPojo> goodsInfoPojo;// goods附表属性
	private String skuKey;
	private Object skuvalue;
	private String goodsKey;
    private Object goodsvalue;//拓展属性（json）
    private String image;//商品图片
    
	
    
    public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Object getSkuvalue() {
		return skuvalue;
	}
	public void setSkuvalue(String skuvalue) {
		if(skuvalue!=null){
			try {
				this.skuvalue=JSONObject.parse(skuvalue);
			} catch (Exception e) {
				this.skuvalue = null;
			}
		}else{
			this.skuvalue = null;
		}
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
	
	


	public String getSkuKey() {
		return skuKey;
	}

	public void setSkuKey(String skuKey) {
		this.skuKey = skuKey;
	}



	public String getGoodsKey() {
		return goodsKey;
	}

	public void setGoodsKey(String goodsKey) {
		this.goodsKey = goodsKey;
	}

	public List<GoodsInfoPojo> getGoodsInfoPojo() {
		return goodsInfoPojo;
	}

	public void setGoodsInfoPojo(List<GoodsInfoPojo> goodsInfoPojo) {
		this.goodsInfoPojo = goodsInfoPojo;
	}

	public String getBrandUuid() {
		return brandUuid;
	}

	public void setBrandUuid(String brandUuid) {
		this.brandUuid = brandUuid;
	}

	public String getGoodsUuid() {
		return goodsUuid;
	}

	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSkuUuid() {
		return skuUuid;
	}

	public void setSkuUuid(String skuUuid) {
		this.skuUuid = skuUuid;
	}

	public String getCompanyUuid() {
		return companyUuid;
	}

	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getFatoryInfo() {
		return fatoryInfo;
	}

	public void setFatoryInfo(String fatoryInfo) {
		this.fatoryInfo = fatoryInfo;
	}

	public List<SkuInfoPojo> getSkuInfoPojo() {
		return skuInfoPojo;
	}

	public void setSkuInfoPojo(List<SkuInfoPojo> skuInfoPojo) {
		this.skuInfoPojo = skuInfoPojo;
	}
	
}
