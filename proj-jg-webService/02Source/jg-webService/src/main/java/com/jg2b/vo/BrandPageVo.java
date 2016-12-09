package com.jg2b.vo;

import com.jg2b.utils.PageRequest;

public class BrandPageVo {
	private String brandUuid;//品牌id
	private PageRequest pageRequest;//分页参数
	

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}

	public String getBrandUuid() {
		return brandUuid;
	}

	public void setBrandUuid(String brandUuid) {
		this.brandUuid = brandUuid;
	}
	
	

}
