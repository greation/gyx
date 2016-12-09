package com.jg2b.h5.pojo;

public class CirclePojo {
	private Integer id;//主键
	private String title;//商圈名
	private Integer province;//省
	private Integer city;//市
	private Integer area;//区
	private String address;//详细地址
	private Integer today_companys;//今日入库供货商
	private Integer companys;//总入驻商家数
	private Integer today_products;//今日发布供货数
	private Integer products;//总供货数
	private String pic;//商圈图片
	private String add_time;//创建时间
	private String short_title;//简称
	private Integer product_time;//商圈产品辅助字段时间;
	
	
	
	public Integer getProduct_time() {
		return product_time;
	}
	public void setProduct_time(Integer product_time) {
		this.product_time = product_time;
	}
	public String getShort_title() {
		return short_title;
	}
	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getToday_companys() {
		return today_companys;
	}
	public void setToday_companys(Integer today_companys) {
		this.today_companys = today_companys;
	}
	public Integer getCompanys() {
		return companys;
	}
	public void setCompanys(Integer companys) {
		this.companys = companys;
	}
	public Integer getToday_products() {
		return today_products;
	}
	public void setToday_products(Integer today_products) {
		this.today_products = today_products;
	}
	public Integer getProducts() {
		return products;
	}
	public void setProducts(Integer products) {
		this.products = products;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	
	

}
