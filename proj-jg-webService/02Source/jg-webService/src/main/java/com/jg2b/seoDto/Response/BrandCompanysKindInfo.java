package com.jg2b.seoDto.Response;

import java.util.List;

import com.jg2b.seoDto.CompanyDto;

/**
 * @author GONGJP
 * @version 1.0 Created on 2016年6月29日 下午16:01:26
 */
public class BrandCompanysKindInfo {
	//返回前台信息列表
	private List<CompanyDto> companys;
	//返回前台信息总数
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<CompanyDto> getCompanys() {
		return companys;
	}
	public void setCompanys(List<CompanyDto> companys) {
		this.companys = companys;
	}
	
}
