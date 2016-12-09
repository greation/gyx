package com.jg2b.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jg2b.h5.pojo.UserPojo;

/**
 * <p>
 * [描述信息：登入拦截器]
 * </p>
 * 
 * @author 刘毅
 * @version 1.0 Created on 2016年7月4日 下午1:24:35
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String[] IGNORE_URI = { 
		"queryReleaseProductInfo.do", 
		"deleteReleaseProduct.do",
		"queryRecentCompanyDto.do",
		"insertRecentContact.do",
		"releaseProduct.do",
		"queryDetailUserInfo.do",
		"queryBrandName.do"
		};

	private static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		boolean flag = false;
		String url = request.getRequestURL().toString();
		LOGGER.info(">>>: " + url);
		//其他不做限制
		if (!url.endsWith(".do"))
			return true;
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				LOGGER.info("拦截范围内>>>: " + url);
				UserPojo userPojo=(UserPojo)request.getSession().getAttribute("userPojo");
				if(userPojo==null){
					LOGGER.info("该会话已经失效");
					response.getWriter().write("{\"state\":-1,\"message\":\"请登入以后再操作!\"}");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
