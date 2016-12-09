package com.jg2b.seoDto.Response;

//查询品牌下右侧边栏同类供应商（入驻）
public class QueryCompanyUpBrandIdResponse{

	private String upBrand;

	public String getUpBrand() {
		return this.upBrand;
	}

	public void setUpBrand(String upBrand) {
		this.upBrand = upBrand;
	}

	public QueryCompanyUpBrandIdResponse() {
	}

	public QueryCompanyUpBrandIdResponse(String upBrand) {
		this.upBrand = upBrand;
	}
}
