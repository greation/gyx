package com.jg2b.seoDto.Response;

import java.util.List;

/**
 *描述信息：品牌下供应商信息
 *		品牌+供应商信息
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月28日 下午5:45:26
 */
public class BrandCompanysPageInfo {
	//返回前台信息列表
	private List<CompanyGoodsPageInfo> companys;
	//返回前台信息总数
	private int count;
	public List<CompanyGoodsPageInfo> getCompanys() {
		return companys;
	}
	public void setCompanys(List<CompanyGoodsPageInfo> companys) {
		this.companys = companys;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
