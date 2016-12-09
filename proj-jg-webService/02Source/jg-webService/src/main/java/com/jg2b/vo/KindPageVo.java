package com.jg2b.vo;

import com.jg2b.utils.PageRequest;

public class KindPageVo {
	private String kindUuid;//分类id
	private PageRequest pageRequest;//分页参数
	public String getKindUuid() {
		return kindUuid;
	}
	public void setKindUuid(String kindUuid) {
		this.kindUuid = kindUuid;
	}
	public PageRequest getPageRequest() {
		return pageRequest;
	}
	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}
	
}
