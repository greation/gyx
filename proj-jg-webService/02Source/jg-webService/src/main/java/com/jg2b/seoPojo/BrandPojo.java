package com.jg2b.seoPojo;

public class BrandPojo {

	private int brand_id;// 品牌id
	private String brandUuid;// 品牌UUid
	private String brand_name;// 品牌名称
	private String brand_logo;// 品牌logo链接
	private String first_letter;// 首字母
	private String pinyin;// 拼音
	private int companys;// 该品牌的供应商
	private String keywords;// 关键字
	private String infos;// 描述
	private int status;// 状态1启用0禁用
	private int recommend;// 推荐1是 0 否
	private int sorts;// 排序
	private int admin;// 管理员ID

	public String getBrandUuid() {
		return brandUuid;
	}

	public void setBrandUuid(String brandUuid) {
		this.brandUuid = brandUuid;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
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

	public int getCompanys() {
		return companys;
	}

	public void setCompanys(int companys) {
		this.companys = companys;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getSorts() {
		return sorts;
	}

	public void setSorts(int sorts) {
		this.sorts = sorts;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
