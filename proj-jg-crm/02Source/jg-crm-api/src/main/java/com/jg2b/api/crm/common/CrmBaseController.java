package com.jg2b.api.crm.common;

import javax.servlet.http.HttpServletRequest;

import com.jg2b.api.crm.login.pojo.UserPojo;

public class CrmBaseController {

	public UserPojo getSessionUser(HttpServletRequest request) {
		UserPojo bean = null;
		if (request.getSession().getAttribute("loginUser") != null) {
			bean = (UserPojo) request.getSession().getAttribute("loginUser");
		}
		return bean;
	}
}
