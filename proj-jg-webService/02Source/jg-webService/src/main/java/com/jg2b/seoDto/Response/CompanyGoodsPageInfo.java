package com.jg2b.seoDto.Response;

import java.util.List;

import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;

public class CompanyGoodsPageInfo {
	private CompanyInfoPojo companyInfo;
	private List<GoodsPojo> goodsList;
	private List<BrandPojo> brands;
	
	public List<BrandPojo> getBrands() {
		return brands;
	}
	public void setBrands(List<BrandPojo> brands) {
		this.brands = brands;
	}
	public CompanyInfoPojo getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(CompanyInfoPojo companyInfo) {
		this.companyInfo = companyInfo;
	}
	public List<GoodsPojo> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsPojo> goodsList) {
		this.goodsList = goodsList;
	}
	
	
	
}
