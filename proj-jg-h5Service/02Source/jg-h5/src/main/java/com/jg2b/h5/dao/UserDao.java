package com.jg2b.h5.dao;

import java.util.List;

import com.jg2b.h5.dto.BrandUpload;
import com.jg2b.h5.dto.CmsCategoryCompanyDto;
import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.SearchDto;
import com.jg2b.h5.dto.UserDto;
import com.jg2b.h5.pojo.UserPojo;

public interface UserDao {
	UserPojo queryUserInfoByPh(String phone);
	
	/**
	 * 重置密码
	 * @param mobile
	 * @param password
	 * @return
	 */
	int resetPassWord(String password,String mobile);
	/**
	 * 用户注册
	 */
	int userRegistered(UserDto userDto);
	
	/**
	 * 公司注册注册
	 */
	int companyRegistered(CompanyDto companyDto);
	
	/**
	 * 插入用户分类
	 */
	int insertUserKind(CmsCategoryCompanyDto cmsCategoryCompanyDto);
	/**
	 * 插入用户品牌
	 */
	int insertUserBrand(BrandUpload brandUpload);
	/**
	 * 首页动态信息
	 */
	List<SearchDto> homeDynamic();
	
	/**
	 * 校验用户是否存在
	 * @param mobile
	 * @return
	 */
	String checkUser(String mobile);
	
	/**
	 *查询用户信息
	 */
	UserPojo queryUserByid(String mobile);
	
}
