package com.jg2b.seoDto;

import java.util.List;

import com.jg2b.seoPojo.CompanyPojo;
import com.jg2b.seoPojo.GoodsPojo;



public class BrandListDto {
	private String brandUuid;//
	private int companyNum;//供应商数量
	private int inquiryNum;//询价次数
	private String infos;// 描述
	private String name;//sku 商品名称
	private String companyUuid;//
	private String brand_name;//品牌名称
	private String brand_logo;//品牌logo
	
	
	
	public String getBrand_logo() {
		return brand_logo;
	}
	public void setBrand_logo(String brand_logo) {
		this.brand_logo = brand_logo;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	
	private List<CompanyPojo> companyPojo;
	
	private List<GoodsPojo> goodsPojo;
	
	
	
	public List<GoodsPojo> getGoodsPojo() {
		return goodsPojo;
	}
	public void setGoodsPojo(List<GoodsPojo> goodsPojo) {
		this.goodsPojo = goodsPojo;
	}
	public List<CompanyPojo> getCompanyPojo() {
		return companyPojo;
	}
	public void setCompanyPojo(List<CompanyPojo> companyPojo) {
		this.companyPojo = companyPojo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrandUuid() {
		return brandUuid;
	}
	public void setBrandUuid(String brandUuid) {
		this.brandUuid = brandUuid;
	}
	public int getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}
	public int getInquiryNum() {
		return inquiryNum;
	}
	public void setInquiryNum(int inquiryNum) {
		this.inquiryNum = inquiryNum;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public String getCompanyUuid() {
		return companyUuid;
	}
	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	

}
