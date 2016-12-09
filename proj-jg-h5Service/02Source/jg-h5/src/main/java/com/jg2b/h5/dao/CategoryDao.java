package com.jg2b.h5.dao;

import java.util.List;

import com.jg2b.h5.pojo.Category;

/**
 * 
 * @author liucongcong
 * 
 */
public interface CategoryDao {
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
}
