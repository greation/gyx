package com.jg2b.seoDto.Response;

//当前品牌已询价的次数（按单商品计算）
public class QueryInqueriedCountsResponse{

	private int inqueriedCount;

	public int getInqueriedCount() {
		return this.inqueriedCount;
	}

	public void setInqueriedCount(int inqueriedCount) {
		this.inqueriedCount = inqueriedCount;
	}
    
    public QueryInqueriedCountsResponse() {
		
	}

	public QueryInqueriedCountsResponse(int inqueriedCount) {
		this.inqueriedCount = inqueriedCount;
	}
}
