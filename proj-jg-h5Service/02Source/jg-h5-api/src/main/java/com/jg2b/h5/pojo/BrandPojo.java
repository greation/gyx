package com.jg2b.h5.pojo;

public class BrandPojo {
	private Integer brand_id;//
	private String brand_name;//品牌名称
	private String brand_logo;//品牌logo链接
	private String first_letter;//首字母
	private String pinyin;//拼音
	private Integer companys;//该品牌的供应商
	private String keywords;//关键字
	private String info;//描述
	private Integer status;//状态1启用0禁用
	private Integer recommend;//推荐1是 0 否
	private Integer sorts;//排序
	private Integer admin;//管理员ID
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_logo() {
		return brand_logo;
	}
	public void setBrand_logo(String brand_logo) {
		this.brand_logo = brand_logo;
	}
	public String getFirst_letter() {
		return first_letter;
	}
	public void setFirst_letter(String first_letter) {
		this.first_letter = first_letter;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Integer getCompanys() {
		return companys;
	}
	public void setCompanys(Integer companys) {
		this.companys = companys;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Integer getSorts() {
		return sorts;
	}
	public void setSorts(Integer sorts) {
		this.sorts = sorts;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	

}
