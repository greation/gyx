package com.jg2b.common.typeEnum;

public enum CustEnum {
	PURCHASER("0", "采购商"),
	SUPPLIER("1", "供应商");

	private String key;
	private String value;

	private CustEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
