package com.jg2b.h5.vo;

import java.io.Serializable;

/**
 * <p>[描述信息：查询供应商详情页面的请求实体]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月7日 下午1:03:31
 */
public class CompanyPageVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3156256935680960696L;
	private String company_id;
	
	//分页参数
	private int pageNum;//页码
	
	private int pageSize;//大小
	
	private int startIndex;

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
	public int getStartIndex() {
		return (pageNum-1)*pageSize<0?0:(pageNum-1)*pageSize;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
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
}
