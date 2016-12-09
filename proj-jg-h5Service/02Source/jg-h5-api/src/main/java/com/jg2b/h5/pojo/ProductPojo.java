package com.jg2b.h5.pojo;

public class ProductPojo {
	private Integer id;
	private Integer category_id;//分类id
	private Integer user_id;//供应商ID
	private Integer brand_id;//品牌ID
	private String title;//产品名称
	private String spec;//规格
	private String model;//型号
	private Integer circle_id;//商圈ID
	private Integer quantity;//数量
	private String unit;//单位
	private Integer add_time;//创建时间
	private String remarks;//备注
	private Integer deleted;//删除标示  0未删除 1删除
	private Integer day;//多少天
	private Integer hour;//多少小时
	private Integer minute;//多少分钟
	private String timeago;// 多少分钟之前
	
	
	public String getTimeago() {
		return timeago;
	}
	public void setTimeago(String timeago) {
		this.timeago = timeago;
	}
	
	
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getCircle_id() {
		return circle_id;
	}
	public void setCircle_id(Integer circle_id) {
		this.circle_id = circle_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Integer add_time) {
		this.add_time = add_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	

}
