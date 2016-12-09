package com.jg2b.seoDto.Response;

import java.util.List;

import com.jg2b.seoDto.GoodDto;

//查询同类商家
public class QuerySimilarGoodsResponse{

	private List<GoodDto> goods;

	public void setGoods(List<GoodDto> goods) {
		this.goods = goods;
	}

	public List<GoodDto> getGoods() {
		return this.goods;
	}
}
