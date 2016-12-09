package com.jg2b.h5.service;

import java.util.List;

import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.pojo.Category;

/**
 * <p>[描述信息：品类接口]</p>
 *
 * @author liucongcong 
 * @version 1.0 Created on 2016年7月4日 下午4:35:59
 */
public interface CategoryService {

	/**
	 * 得到父类品类
	 * @return
	 */
	List<Category> queryTopCategoryInfo();
	
	/**
	 * 根据父类品类ID得到子类品类
	 * @param topid
	 * @return
	 */
	List<Category> queryChildCategoryInfo(int topid); 
	
	/**
	 * 查询所有的子类
	 * @return
	 * 2016年7月6日
	 */
	List<Category> queryEveryChildCategory();

	/**
	 * 根据用户id查询公司信息
	 * @param user_id
	 * @return
	 *//*
	CompanyDto queryCompanyByUserId(int user_id);*/

	

}
