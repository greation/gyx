package com.jg2b.h5.vo;

import com.jg2b.h5.dto.ProductDto;
import com.jg2b.utils.PageRequest;

public class ReleaseVo {
private Integer id;//product id
private Integer User_id;//
private ProductDto productDto;
private PageRequest pageRequest;



public PageRequest getPageRequest() {
	return pageRequest;
}
public void setPageRequest(PageRequest pageRequest) {
	this.pageRequest = pageRequest;
}
public ProductDto getProductDto() {
	return productDto;
}
public void setProductDto(ProductDto productDto) {
	this.productDto = productDto;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getUser_id() {
	return User_id;
}
public void setUser_id(Integer user_id) {
	User_id = user_id;
}

}
