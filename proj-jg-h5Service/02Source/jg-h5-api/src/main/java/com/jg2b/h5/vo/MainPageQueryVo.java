package com.jg2b.h5.vo;

import java.io.Serializable;

/**
 * <p>[描述信息：主页查询请求参数]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月5日 下午4:06:53
 */
public class MainPageQueryVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3846787805457900837L;
	//查询框输入内容
	private String pageQueryParam;
	//品牌id
	private String brand_id;
	//品类id
	private String c_id;
	//商圈id
	private String circle_id;
	//搜索类型 1仅精准查询  2模块查询或者 模糊查询+精准查询
	private String search_type;
	
	//private pageRequest
	
	//分页参数
	private int pageNum;//页码
	
	private int pageSize;//大小
	
	private int startIndex;
	
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
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getPageQueryParam() {
		return pageQueryParam;
	}
	public void setPageQueryParam(String pageQueryParam) {
		this.pageQueryParam = pageQueryParam;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getCircle_id() {
		return circle_id;
	}
	public void setCircle_id(String circle_id) {
		this.circle_id = circle_id;
	}
	
}
