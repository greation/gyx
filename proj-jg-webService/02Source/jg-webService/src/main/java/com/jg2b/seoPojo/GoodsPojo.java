package com.jg2b.seoPojo;

import com.alibaba.fastjson.JSONObject;


public class GoodsPojo{
	private int id;
	private String goodsUuid;
	private String skuUuid;
	private String companyUuid;
	private String brandUuid;
	private String factoryUuid;
	private String title;
	private double price;
	private int creator;
	private int creatertime;
	private int updator;
	private int updatetime;
	private int sources;
	private int deleted;
	private String image;//图片地址
	private String brand_name;//品牌名
	private String sku_name;//sku名称
	private String material;//材质
	private String size;//型号
	private String is_customizing;//是否提供加工定制 0是1不是 
	private Object goodsvalue;//产品其他属性
	private String company_name;//公司名称
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getSku_name() {
		return sku_name;
	}
	public void setSku_name(String sku_name) {
		this.sku_name = sku_name;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getIs_customizing() {
		return is_customizing;
	}
	public void setIs_customizing(String is_customizing) {
		this.is_customizing = is_customizing;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsUuid() {
		return goodsUuid;
	}
	public void setGoodsUuid(String goodsUuid) {
		this.goodsUuid = goodsUuid;
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
	public String getBrandUuid() {
		return brandUuid;
	}
	public void setBrandUuid(String brandUuid) {
		this.brandUuid = brandUuid;
	}
	public String getFactoryUuid() {
		return factoryUuid;
	}
	public void setFactoryUuid(String factoryUuid) {
		this.factoryUuid = factoryUuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
