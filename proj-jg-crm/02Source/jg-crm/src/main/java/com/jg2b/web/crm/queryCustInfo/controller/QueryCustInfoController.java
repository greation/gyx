package com.jg2b.web.crm.queryCustInfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.customerManage.service.ICustomerService;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;
import com.jg2b.api.crm.queryCustInfo.service.IQueryCustInfoService;
import com.jg2b.common.utils.BaseUtil;
import com.jg2b.web.crm.queryCustInfo.service.impl.QueryCustInfoServiceImpl;
import com.jg2b.web.crm.queryCustInfo.vo.QueryCustInfoVO;

@Controller
@RequestMapping(value = "/Cust/")
public class QueryCustInfoController extends CrmBaseController {
	private static Logger logger = Logger
			.getLogger(QueryCustInfoServiceImpl.class);

	@Autowired
	private IQueryCustInfoService customerManageService;

	@Autowired
	private ICustomerService customerServiceImpl;

	@RequestMapping("findCustomerInfo")
	public String findCustomerInfo(HttpServletRequest request,
			@ModelAttribute QueryCustInfoVO vo, ModelMap model)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		// String seaType = vo.getSeaType();
		// if(seaType!=null&&!seaType.equals("")){
		// if(seaType.equals("0")){
		// dto.setOwner("");
		// }else if(seaType.equals("1")){
		// UserPojo user = getSessionUser(request);
		// if(user!=null&&!"".equals(user.getID())&&user.getID()!=null){
		// dto.setUserid(user.getID());
		// }else{
		// throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		// }
		// dto.setOwner(String.valueOf(user.getID()));
		// }
		// }

		UserPojo user = getSessionUser(request);
		if (user != null && !"".equals(user.getID()) && user.getID() != null) {
			dto.setUserid(user.getGID());
			
		} else {
			throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		}
		dto.setuID(user.getID());
		dto.setOwner(user.getGID());
		model.addAttribute("uuowner", dto.getOwner());
		 
		model.addAttribute("search",dto);
		model.addAttribute("custs", customerManageService.findCustomerInfo(dto,getSessionUser(request)));// 查询客户信息
		model.addAttribute("regionList",customerServiceImpl.queryCodeAndRegion());// 地区
		model.addAttribute("industryList",customerServiceImpl.queryCodesAndIndustry());// 行业
		model.addAttribute("UserList", customerServiceImpl.queryCodesAndUser());// 客服
		model.addAttribute("sourceList",customerServiceImpl.queryCodeAndChannel());// 渠道来源
		// model.addAttribute("ConCount",customerServiceImpl.queryConCount());
		model.addAttribute("bean", user);
		
		return "/customer/customerList";
	}
	@RequestMapping("findCustomerInfoAjax")
	@ResponseBody
	public List findCustomerInfoAjax(HttpServletRequest request,
			@ModelAttribute QueryCustInfoVO vo, ModelMap model)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		UserPojo user = getSessionUser(request);
		if (user != null && !"".equals(user.getID()) && user.getID() != null) {
			dto.setUserid(user.getGID());
		} else {
			throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		}
	 
		List list=new ArrayList();
		list.add(customerManageService.findCustomerInfo(dto,getSessionUser(request)));
		list.add(user);
		list.add(dto.getOwner());
		return list;
	}
	@RequestMapping("findContactInfo")
	public String findContactInfo(HttpServletRequest request,
			@ModelAttribute QueryCustInfoVO vo, ModelMap model)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		model.addAttribute("contacts", customerManageService.findContactInfo(
				dto, getSessionUser(request)));

		return "/contact/contactsList";
	}

	@RequestMapping("findActivities")
	public String findActivities(HttpServletRequest request,
			@ModelAttribute QueryCustInfoVO vo, ModelMap model)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		model.addAttribute("activities", customerManageService.findActivities(
				dto, getSessionUser(request)));
		return "/customerActive/callActivities";
	}
}
