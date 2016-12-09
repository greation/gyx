package com.jg2b.seoDto.Response;

import java.util.List;

import com.jg2b.seoDto.BrandDto;

public class QueryBrandInfosResponse{
	private List<BrandDto> brandList;

	public List<BrandDto> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandDto> brandList) {
		this.brandList = brandList;
	}
	
	

}
