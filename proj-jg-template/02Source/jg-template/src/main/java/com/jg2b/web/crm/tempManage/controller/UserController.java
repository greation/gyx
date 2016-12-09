package com.jg2b.web.crm.tempManage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.api.crm.userManage.dto.UserDTO;
import com.jg2b.api.crm.userManage.pojo.TestPojo;
import com.jg2b.api.crm.userManage.service.ITestService;

@Controller
public class UserController {

	private ITestService testService;

	@Autowired
	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	@RequestMapping("/test")
	public Object test(HttpServletRequest request, ModelMap modelMap) {
		List<TestPojo> list = testService.searchList();
		System.out.println(list.size());

		UserDTO user = new UserDTO();
		user.setId(1);
		user.setUname("测试");
		user.setUpwd("pwd");
		modelMap.addAttribute("user", user);
		return "test";
	}

	@RequestMapping("/showInfos")
	@ResponseBody
	public Object showUserInfos() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		UserDTO user;
		for (int i = 0; i < 5; i++) {
			user = new UserDTO();
			user.setId(i);
			user.setUname("测试人员" + i);
			user.setUpwd("123456");
			users.add(user);
		}
		return users;
	}
}
