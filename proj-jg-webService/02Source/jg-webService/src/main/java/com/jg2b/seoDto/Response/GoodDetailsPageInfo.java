package com.jg2b.seoDto.Response;

import java.util.List;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;

/**
 *描述信息：商品详情页展示数据实体定义
 * 	包括商品详细信息
 * 	供应商信息	
 *  当前商品所属分类的下的其它商品，（10条）
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月30日 下午1:31:38
 */
public class GoodDetailsPageInfo {
	//商品信息
	private GoodsPojo goodsInfo;
	//供应商信息
	private CompanyInfoPojo companyInfoPojo;
	//其它同类商品：当前商品所属分类的下的其它商品
	List<GoodsPojo> relatedGoodsInfo;
	
	public GoodsPojo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsPojo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public CompanyInfoPojo getCompanyInfoPojo() {
		return companyInfoPojo;
	}
	public void setCompanyInfoPojo(CompanyInfoPojo companyInfoPojo) {
		this.companyInfoPojo = companyInfoPojo;
	}
	public List<GoodsPojo> getRelatedGoodsInfo() {
		return relatedGoodsInfo;
	}
	public void setRelatedGoodsInfo(List<GoodsPojo> relatedGoodsInfo) {
		this.relatedGoodsInfo = relatedGoodsInfo;
	}
	
}
