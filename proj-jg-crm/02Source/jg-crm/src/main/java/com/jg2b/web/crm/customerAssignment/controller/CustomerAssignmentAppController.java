package com.jg2b.web.crm.customerAssignment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.customerAssignment.service.ICustomerAssignmentService;
import com.jg2b.api.crm.login.pojo.UserPojo;

@Controller
@RequestMapping(value = "/CustAgtApp/")
public class CustomerAssignmentAppController extends CrmBaseController {

	@Autowired
	private ICustomerAssignmentService customerAssignmentService;

	@RequestMapping("CustCheckInApp")
	@ResponseBody
	public String CustCheckInApp(HttpServletRequest request,
			@RequestParam("id") String id, @RequestParam("uid") String uid)
			throws Exception {
		UserPojo user = getSessionUser(request);
		customerAssignmentService.CustCheck(id, "in", uid, user);
		return "success";
	}

	@RequestMapping("CustCheckOutApp")
	@ResponseBody
	public String CustCheckOutApp(HttpServletRequest request,
			@RequestParam("id") String id) throws Exception {
		UserPojo user = getSessionUser(request);
		customerAssignmentService.CustCheck(id, "out", "", user);
		return "success";
	}

}
