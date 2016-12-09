package com.jg2b.h5.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.h5.conts.BaseConts;
import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.SearchDto;
import com.jg2b.h5.pojo.UserPojo;
import com.jg2b.h5.respons.ResultResponse;
import com.jg2b.h5.service.UserService;
import com.jg2b.h5.vo.CompanyVo;
import com.jg2b.h5.vo.ModifiedPwdVo;
import com.jg2b.h5.vo.SearchVo;
import com.jg2b.h5.vo.UserVo;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);  
	
	@RequestMapping(value = "/registerUserInfo", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse registerUserInfo(@RequestBody UserVo requestParam) {
		System.out.println("111111111111");
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(ResultResponse.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			userService.queryUserInfoByPh("13115085056");
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询当前品牌下鲸工入驻的供应商数量异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 验证用户登录信息
	 *  得到一个map集合 里面存放信息是否正确
	 *  如果正确返回一个用户信息对象UserPoJo
	 *  如果错误返回一个boolean类型的参数false
	 *  
	 *  
	 *  @param requestParam
	 *  @return
	 */
	@RequestMapping(value = "/userIsLogin.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse userIsLogin (@RequestBody UserVo requestParam,HttpServletRequest request){
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(ResultResponse.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			Map<String, Object> map=userService.queryUserInfoIsSure(requestParam);
			boolean isLogin=(boolean) map.get("isLogin");
			if(isLogin){
				UserPojo userPojo=(UserPojo) map.get("user");
				response.setData(userPojo);
				response.setState(ResultResponse.IsOkState);
				//保存session
			    request.getSession().setAttribute("userPojo",userPojo);
			}else{
				response.setData(isLogin);
				response.setState(ResultResponse.ErrorState);
				response.setMessage("无效用户");
			
			}
			return response;
		} catch (Exception e) {
			LOGGER.error("用户登录异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	
	/**
	 * 忘记密码/登入后修改密码
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/resetPassWord", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse resetPassWord(@RequestBody ModifiedPwdVo requestParam,HttpServletRequest request) {
		
		ResultResponse response = new ResultResponse();
		if (requestParam ==null||StringUtils.isEmpty(requestParam.getPassword())||
				StringUtils.isEmpty(requestParam.getModified_type())) {
			response.setState(ResultResponse.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			//登入以后修改密码需要校验session
			if(BaseConts.LOGINED_PASSWORD_CODE.equals(requestParam.getModified_type())){
				UserPojo user=(UserPojo)request.getSession().getAttribute("userPojo");
				if(user==null){
					response.setState(ResultResponse.ErrorState);
					response.setMessage("会话已经失效");
					return response;
				}
				/*if(!requestParam.getMobile().equalsIgnoreCase(user.getMobile())){
					response.setState(ResultResponse.ErrorState);
					response.setMessage("用户身份不一致");
					return response;
				}*/
				int i = userService.resetPassWord(requestParam.getPassword(),user.getMobile());
				response.setState(ResultResponse.IsOkState);
				response.setMessage("修改密码成功");
				response.setData(true);
				return response;
			}else if(BaseConts.FORGET_PASSWORD_CODE.equals(requestParam.getModified_type())){
				if (requestParam ==null||StringUtils.isEmpty(requestParam.getMobile())) {
					response.setState(ResultResponse.ErrorState);
					response.setMessage("无效参数");
					return response;
				}
				//忘记密码修改
				/**获取session中的忘记密码提交的手机验证码结果*/
				String isCheckout=(String)request.getSession().getAttribute("isCheckout"+BaseConts.FORGET_PASSWORD_CODE+":"+requestParam.getMobile());
				if(!BaseConts.TRUE.equalsIgnoreCase(isCheckout)){
					response.setState(ResultResponse.ErrorState);
					response.setMessage("未通过手机验证码验证");
					return response;
				}
				int i = userService.resetPassWord(requestParam.getPassword(),requestParam.getMobile());
				response.setState(ResultResponse.IsOkState);
				response.setMessage("修改密码成功");
				response.setData(true);
				return response;
			}else{
				response.setState(ResultResponse.ErrorState);
				response.setMessage("无效的修改类型");
				response.setData(false);
				return response;
			}
		} catch (Exception e) {
			LOGGER.error("重置密码", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
		/**
		 * <p>用户注册</p>
		 * 
		 * @param requestParam
		 * @author:张鹏 
		 * @date: Created on 2016年7月4日 下午12:00:34
		 */
		@RequestMapping(value = "/userRegistered.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
		public @ResponseBody
		ResultResponse userRegistered(@RequestBody UserVo requestParam,HttpServletRequest request) {
			ResultResponse response =new ResultResponse();
			LOGGER.info("注册开始");
		try {	
			// 每一次请求页码和每页记录数
			int a=userService.userRegistered(requestParam.getUserDto());
			if(a==1){
				UserPojo userPojo=userService.queryUserByid(requestParam.getUserDto().getMobile());
				  HttpSession session = request.getSession();
				session.setAttribute("userPojo", userPojo);
			}
			response.setData(a);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("用户注册异常", e);
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
		ResultResponse companyRegistered(@RequestBody CompanyVo requestParam,HttpServletRequest request) {
			ResultResponse response =new ResultResponse();
			LOGGER.info("注册开始");
		try {	
			// 每一次请求页码和每页记录数
			UserPojo userPojo=(UserPojo)request.getSession().getAttribute("userPojo");
			CompanyDto companyDto =requestParam.getCompanyDto();
			companyDto.setUser_id(032544);
			int a=userService.companyRegistered(companyDto);
			response.setData(a);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("公司信息注册异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
		}
		
		
		/**
		 * <p>首页最新动态</p>
		 * 
		 * @param requestParam
		 * @author:张鹏
		 * @date: Created on 2016年7月4日 下午12:00:34
		 */
		@RequestMapping(value = "/homeDynamic.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
		public @ResponseBody
		ResultResponse homeDynamic() {
			ResultResponse response =new ResultResponse();
			LOGGER.info("注册开始");
		try {	
			// 每一次请求页码和每页记录数
			List<SearchDto> SearchDtoList=userService.homeDynamic();
			response.setData(SearchDtoList);
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
		 * <p>安全退出</p>
		 * 
		 * @param requestParam
		 * @author:张鹏
		 * @date: Created on 2016年7月4日 下午12:00:34
		 */
		@RequestMapping(value = "/safetyExit.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
		public @ResponseBody
		ResultResponse safetyExit(HttpServletRequest request ) {
			ResultResponse response =new ResultResponse();
			LOGGER.info("退出开始");
		try {	
			// 获取session删除用户信息
			HttpSession session = request.getSession();
			if (session!=null) {
				session.invalidate();
				response.setState(ResultResponse.IsOkState);
				response.setData("true");
				return response;
			}else{
				response.setState(ResultResponse.ErrorState);
				response.setData("false");
				return response;
			}
		} catch (Exception e) {
			LOGGER.error("安全退出异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
		}
	
}
