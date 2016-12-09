package com.jg2b.web.crm.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.login.service.ILoginService;
import com.jg2b.api.crm.login.vo.UserVo;
import com.jg2b.common.baseBean.UploadCommonBean;
import com.jg2b.common.utils.FileUploadUtil;

@Controller
@RequestMapping("/loginApp")
public class LoginAppController {

	@Autowired
	private ILoginService loginService;

	@RequestMapping("/userLoginApp")
	@ResponseBody
	public Object userLoginApp(UserVo user, HttpSession session) {
		List<UserPojo> list = loginService.searchUser(user.getName(),
				user.getPassword());
		UserPojo userBean = new UserPojo();
		if (list != null && list.size() > 0) {
			userBean = list.get(0);
			session.setAttribute("loginUser", userBean);
		}
		return userBean;
	}

	@RequestMapping("/userLogoutApp")
	@ResponseBody
	public Object userLogoutApp(HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
		return "success";
	}

	@RequestMapping("/insertContactsApp")
	@ResponseBody
	public Object insertContactsApp(HttpServletRequest request)
			throws Exception {
		FileUploadUtil fileUploadUtil = new FileUploadUtil("1\\2", request);
		List<UploadCommonBean> uploadList = fileUploadUtil.UploadFile();
		return "success";
	}

}
