package com.jg2b.web.crm.redirectPage.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("Redirect")
public class RedirectPageController{
    @RequestMapping("redirectpage")
	public String findCustomerInfo(HttpServletRequest request,
			@RequestParam("page") String page) throws Exception {
    	return page;
    }
}
 