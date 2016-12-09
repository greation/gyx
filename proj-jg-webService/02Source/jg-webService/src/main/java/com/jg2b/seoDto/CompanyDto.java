package com.jg2b.seoDto;

import java.util.List;

import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.CompanyIntroducePojo;
import com.jg2b.seoPojo.QueryGoodsByCompanyPojo;
public class CompanyDto {
	private int companyId;//公司id
	private String companyUuid;//供应商uuid
	private String companyName;//公司名称
	private String businessScope;//经营范围
	private String introduces; //介绍
	
	
	public String getIntroduces() {
		return introduces;
	}
	public void setIntroduces(String introduces) {
		this.introduces = introduces;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	private List<CompanyIntroducePojo> introduce;//公司介绍 /经营范围
	private List<BrandPojo> brands;//品牌集合
	
	private List<QueryGoodsByCompanyPojo> goods;
	
	public List<CompanyIntroducePojo> getIntroduce() {
		return introduce;
	}
	public void setIntroduce(List<CompanyIntroducePojo> introduce) {
		this.introduce = introduce;
	}
	public List<BrandPojo> getBrands() {
		return brands;
	}
	public void setBrands(List<BrandPojo> brands) {
		this.brands = brands;
	}
	private int status;//审核1为通过0未通过
	
	public String getCompanyUuid() {
		return companyUuid;
	}
	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<QueryGoodsByCompanyPojo> getGoods() {
		return goods;
	}
	public void setGoods(List<QueryGoodsByCompanyPojo> goods) {
		this.goods = goods;
	}

}
