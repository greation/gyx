package com.jg2b.seoDto.Response;

import java.util.List;

import com.jg2b.seoDto.GoodsInfoDto;

public class QueryProductDetailsPojo{
	private List<GoodsInfoDto> queryProductDetails;

	public List<GoodsInfoDto> getQueryProductDetails() {
		return queryProductDetails;
	}

	public void setQueryProductDetails(List<GoodsInfoDto> queryProductDetails) {
		this.queryProductDetails = queryProductDetails;
	}

}
