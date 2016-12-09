package com.jg2b.h5.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.jg2b.h5.pojo.UserPojo;
import com.jg2b.h5.respons.ResultResponse;
import com.jg2b.h5.service.SmsService;
import com.jg2b.h5.vo.VerificationCodeVo;

/**
 * <p>[描述信息：手机验证码相关控制器]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月4日 下午2:10:35
 */


@Controller
@RequestMapping("/verification")
public class VerificationCodeController {
	@Autowired
	SmsService SmsService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(VerificationCodeController.class);  
	
	@RequestMapping(value = "/getVerificationCode.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse getVerificationCode(@RequestBody VerificationCodeVo vo,HttpServletRequest request) {
		ResultResponse response=new ResultResponse();
		if(vo==null||StringUtils.isEmpty(vo.getPhone())||StringUtils.isEmpty(vo.getType())){
			if(!BaseConts.USER_REGISTER_CODE.equals(vo.getType())
					&&!BaseConts.MODIFIED_PASSWORD_CODE.equals(vo.getType())){	
				LOGGER.error("获取手机验证码,请求参数异常:"+vo.toString());
				response.setState(ResultResponse.ErrorState);
				response.setMessage("获取手机验证码:手机号不能为null,获取验证码类型不正确");
				return response;
			}
		}
		
		try {
			String verificationCode=SmsService.sendVerificationCode(vo.getPhone());
			LOGGER.error("获取手机验证码,code:"+verificationCode+",phone:"+vo.getPhone()+",type:"+vo.getType());
			
			//如果是忘记密码 先判断用户是否存在
			if(BaseConts.FORGET_PASSWORD_CODE.equalsIgnoreCase(vo.getType())){
				//根据电话号码查询
				String Phone=SmsService.checkUser(vo.getPhone());
				if(Phone==null){
				    response.setState(ResultResponse.UserOk);
					response.setMessage("用户不存在");
					return response;
				}
			}else{
				//注册
				//根据电话号码查询
				String Phone=SmsService.checkUser(vo.getPhone());
				if(Phone!=null){
				    response.setState(ResultResponse.ErrorState);
					response.setMessage("用户已经存在");
					return response;
				}
			}
			
			//如果是注册先判断用户是否存在
			if(BaseConts.USER_REGISTER_CODE.equalsIgnoreCase(vo.getType())){
				//根据电话号码查询
				String Phone=SmsService.checkUser(vo.getPhone());
				if(Phone!=null){
			    response.setState(ResultResponse.userIsOk);
				response.setMessage("用户存在");
				return response;
				}
			}
			if(verificationCode==null){
				response.setState(ResultResponse.ErrorState);
				response.setMessage("短信平台发送验证码失败");
				response.setData(false);
				return response;
			}
			//sessio保存验证码信息     key   VerificationCode:phone
			request.getSession().setAttribute(vo.getType()+":"+vo.getPhone(), verificationCode);
			response.setData(true);
			response.setState(ResultResponse.IsOkState);
			response.setMessage("获取手机验证码:成功");
		} catch (Exception e) {
			LOGGER.error("获取手机验证码,系统异常",e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage("获取手机验证码:失败");
			return response;
		}
		return response;
	}
	
	
	@RequestMapping(value = "/checkVerificationCode.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse checkVerificationCode(@RequestBody VerificationCodeVo vo,HttpServletRequest request) {
		ResultResponse response=new ResultResponse();
		if(vo==null||StringUtils.isEmpty(vo.getVerificationCode())||StringUtils.isEmpty(vo.getPhone())||
				StringUtils.isEmpty(vo.getType())){
			if(vo==null||StringUtils.isEmpty(vo.getPhone())||StringUtils.isEmpty(vo.getType())){
				if(!BaseConts.USER_REGISTER_CODE.equals(vo.getType())
						&&!BaseConts.MODIFIED_PASSWORD_CODE.equals(vo.getType())){	
					LOGGER.error("校验手机验证码,请求参数异常:"+vo.toString());
					response.setState(ResultResponse.ErrorState);
					response.setMessage("手机号不能为null,验证码不能为null,获取验证码类型不正确");
					return response;
				}
			}
		}
		
		try {
			String sysVerificationCode=(String)request.getSession().getAttribute(vo.getType()+":"+vo.getPhone());
			LOGGER.info("校验手机验证码,sysCode:"+sysVerificationCode+",userCode:"+vo.getVerificationCode()+",type:"+vo.getType());
			//不考虑大小写
			if(vo.getVerificationCode().equalsIgnoreCase(sysVerificationCode)){
				response.setState(ResultResponse.IsOkState);
				response.setMessage("校验成功");
				response.setData(true);
				//校验成功标识
				request.getSession().setAttribute("isCheckout"+vo.getType()+":"+vo.getPhone(), BaseConts.TRUE);
			}else{
				response.setState(ResultResponse.ErrorState);
				response.setMessage("验证码错误");
				response.setData(false);
			}
		} catch (Exception e) {
			LOGGER.error("校验手机验证码,系统异常",e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage("获取手机验证码失败");
			return response;
		}
		return response;
	}
	
	
}
