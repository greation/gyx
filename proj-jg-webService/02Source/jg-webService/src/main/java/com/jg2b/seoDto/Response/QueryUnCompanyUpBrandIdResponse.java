package com.jg2b.seoDto.Response;

//查询品牌下右侧边栏同类供应商（未入驻）
public class QueryUnCompanyUpBrandIdResponse{

	private String categoryBrand;

	public String getCategoryBrand() {
		return this.categoryBrand;
	}

	public void setCategoryBrand(String categoryBrand) {
		this.categoryBrand = categoryBrand;
	}

	public QueryUnCompanyUpBrandIdResponse() {
	}

	public QueryUnCompanyUpBrandIdResponse(String brand) {
		this.categoryBrand = brand;
	}
}