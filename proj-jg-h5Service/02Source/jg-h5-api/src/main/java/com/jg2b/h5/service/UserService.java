package com.jg2b.h5.service;

import java.util.List;
import java.util.Map;

import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.SearchDto;
import com.jg2b.h5.dto.UserDto;
import com.jg2b.h5.pojo.UserPojo;
import com.jg2b.h5.vo.UserVo;
/**
 * <p>[描述信息：用户信息操作接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月4日 上午10:58:57
 */
public interface UserService {
	
	/**
	 * 根据注册电话得到一个UserPojo对象
	 * @param phone
	 * @author liucongcong
	 * @return
	 */
	UserPojo queryUserInfoByPh(String phone);
	
	/**
	 * 根据手机和密码验证是否信息正确
	 * 	返回一个map集合 里面存放userPojo 和 信息正确判断标识isLogin
	 * @param userVo
	 * @author liucongcong
	 * @return
	 */
	Map<String, Object> queryUserInfoIsSure(UserVo userVo);
	
	/**
	 * 传入一个电话号码 判断是否存在该用户 用于注册
	 * @param phone
	 * @author liucongcong
	 * @return
	 */
	boolean isExitUser(String phone);

	/**
	 * 重置密码
	 * @param password
	 * @param mobile
	 * @return
	 */
	int resetPassWord(String password, String mobile);
	//用户注册
	int userRegistered(UserDto userDto);
	//注册信息
	int companyRegistered(CompanyDto companyDto);
	
	/**
	 * 首页动态信息
	 */
	List<SearchDto> homeDynamic();
	
	/**
	 *查询用户信息
	 */
	UserPojo queryUserByid(String mobile);
}
