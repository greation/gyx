package com.jg2b.seoDto.Response;

import java.util.List;

import com.jg2b.seoDto.GoodsInfoDto;

public class KindGoodsPageInfo {
	private List<GoodsInfoDto> goodsInfoList;//分类商品集合
	private int count;//分类商品总数
	public List<GoodsInfoDto> getGoodsInfoList() {
		return goodsInfoList;
	}
	public void setGoodsInfoList(List<GoodsInfoDto> goodsInfoList) {
		this.goodsInfoList = goodsInfoList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
