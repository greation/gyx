package com.jg2b.h5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.h5.respons.ResultResponse;
import com.jg2b.h5.service.UserService;
import com.jg2b.h5.vo.CompanyVo;
import com.jg2b.h5.vo.UserVo;
@Controller
@RequestMapping("/test")
public class TestController {

	
	@Autowired
	private UserService userService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);  
	
	/**
	 * <p>提供测试入口</p>
	 * 
	 * @param requestParam
	 * @author:刘毅 
	 * @date: Created on 2016年7月4日 下午12:00:34
	 */
	@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	void test(@RequestBody UserVo requestParam) {
		LOGGER.info("我的测试开始了");
		
		userService.queryUserInfoByPh("123");
		
		
		LOGGER.info("我的测试结束了");
	}
	
	
	/**
	 * <p>用户注册</p>
	 * 
	 * @param requestParam
	 * @author:刘毅 
	 * @date: Created on 2016年7月4日 下午12:00:34
	 */
	@RequestMapping(value = "/userRegistered.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse userRegistered(@RequestBody UserVo requestParam) {
		ResultResponse response =new ResultResponse();
		LOGGER.info("注册开始");
	try {	
		// 每一次请求页码和每页记录数
		int a=userService.userRegistered(requestParam.getUserDto());
		response.setData(a);
		response.setState(ResultResponse.IsOkState);
		return response;
	} catch (Exception e) {
		LOGGER.error("品牌商家分页（15条）异常", e);
		response.setState(ResultResponse.ErrorState);
		response.setMessage(e.getMessage());
		return response;
	}
	}
	
	
	/**
	 * <p>注册信息</p>
	 * 
	 * @param requestParam
	 * @author:张鹏
	 * @date: Created on 2016年7月4日 下午12:00:34
	 */
	@RequestMapping(value = "/companyRegistered.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse companyRegistered(@RequestBody CompanyVo requestParam) {
		ResultResponse response =new ResultResponse();
		LOGGER.info("注册开始");
	try {	
		// 每一次请求页码和每页记录数
		int a=userService.companyRegistered(requestParam.getCompanyDto());
		response.setData(a);
		response.setState(ResultResponse.IsOkState);
		return response;
	} catch (Exception e) {
		LOGGER.error("品牌商家分页（15条）异常", e);
		response.setState(ResultResponse.ErrorState);
		response.setMessage(e.getMessage());
		return response;
	}
	}
	
	
	

}
