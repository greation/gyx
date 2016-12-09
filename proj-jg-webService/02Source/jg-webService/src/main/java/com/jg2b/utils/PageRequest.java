package com.jg2b.utils;

public class PageRequest {
	private int pageNum = 0;// 接受每一次请求页码
	private int pageSize = 15;// 每次分页请求 显示15条记录
	private int startIndex;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		if(pageNum<=1)
			return 0;
		this.startIndex = (this.pageNum - 1) * this.pageSize;
		return this.startIndex;
	}

	// public void setStartIndex(int startIndex) {
	// this.startIndex = startIndex;
	// }

}
