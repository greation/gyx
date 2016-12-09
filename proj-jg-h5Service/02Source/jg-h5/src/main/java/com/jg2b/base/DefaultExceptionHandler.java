package com.jg2b.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.ModelAndView;

public class DefaultExceptionHandler {
	private static Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);  
    
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  Exception ex) {    
        ModelAndView mv = new ModelAndView();      
        log.error("服务器异常",ex);
        try {
        	// 根据不同的异常类型进行不同处理
			/*if(ex instanceof com.fasterxml.jackson.core.JsonParseException||
					ex instanceof com.fasterxml.jackson.databind.JsonMappingException) 
				response.getWriter().write("{\"state\":false,\"message\":\"JSON格式异常\"}");
			else
				response.getWriter().write("{\"state\":false,\"message\":\"系统异常:" + ex.getMessage() + "\"}");*/
        	if(ex instanceof HttpMessageNotReadableException){
        		response.getWriter().write("{\"state\":0,\"message\":\"请求参数异常!\"}");
			}else{
				response.getWriter().write("{\"state\":0,\"message\":\"系统异常!\"}");
			}
		} catch (IOException e) {
			 log.error("与客户端通讯异常:"+ e.getMessage(), e);  
		}
        return mv;  
    }  
}
