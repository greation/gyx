package com.jg2b.h5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.pojo.Category;
import com.jg2b.h5.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private com.jg2b.h5.dao.CategoryDao categoryDao;
	
	@Autowired
	private com.jg2b.h5.dao.CompanyDao CompanyDao;

	@Override
	public List<Category> queryTopCategoryInfo() {
		return categoryDao.queryTopCategoryInfo();
	}

	@Override
	public List<Category> queryChildCategoryInfo(int topid) {
		return categoryDao.queryChildCategoryInfo(topid);
	}
    
	/**
	 * 通过用户id查新公司信息
	 *//*
	@Override
	public CompanyDto queryCompanyByUserId(int user_id) {
		CompanyDto companyDto =CompanyDao.queryCompanyByUserId(user_id);
		if(companyDto==null)
		return null;
		return companyDto;
	}*/

	@Override
	public List<Category> queryEveryChildCategory() {
		// TODO Auto-generated method stub
		return null;
	}


}
