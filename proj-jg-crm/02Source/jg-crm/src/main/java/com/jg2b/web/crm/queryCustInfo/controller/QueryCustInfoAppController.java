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

import com.alibaba.fastjson.JSON;
import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.customerManage.service.ICustomerService;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.dto.FindActivitiesDTO;
import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;
import com.jg2b.api.crm.queryCustInfo.service.IQueryCustInfoService;
import com.jg2b.common.utils.BaseUtil;
import com.jg2b.web.crm.queryCustInfo.service.impl.QueryCustInfoServiceImpl;
import com.jg2b.web.crm.queryCustInfo.vo.QueryCustInfoVO;

@Controller
@RequestMapping(value = "/CustApp")
public class QueryCustInfoAppController extends CrmBaseController {
	private static Logger logger = Logger
			.getLogger(QueryCustInfoServiceImpl.class);

	@Autowired
	private IQueryCustInfoService customerManageService;

	@Autowired
	private ICustomerService customerServiceImpl;

	/**
	 * // 地区
	 * 
	 * @return
	 */
	@RequestMapping("/queryRegionListApp")
	@ResponseBody
	public Object queryRegionListApp() {
		return customerServiceImpl.queryCodeAndRegion();// 地区
	}

	/**
	 * 行业
	 * 
	 * @return
	 */
	@RequestMapping("/queryindustryListApp")
	@ResponseBody
	public Object queryindustryListApp() {
		return customerServiceImpl.queryCodesAndIndustry();
	}

	/**
	 * 客服
	 * 
	 * @return
	 */
	@RequestMapping("/queryUserListApp")
	@ResponseBody
	public Object queryUserListApp() {
		return customerServiceImpl.queryCodesAndUser();
	}

	/**
	 * 渠道来源
	 * 
	 * @return
	 */
	@RequestMapping("/querySourceListApp")
	@ResponseBody
	public Object querySourceListApp() {
		return customerServiceImpl.queryCodeAndChannel();
	}

	@RequestMapping("/findCustomerInfoApp")
	@ResponseBody
	public String findCustomerInfoApp(HttpServletRequest request,
			@ModelAttribute QueryCustInfoVO vo) throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);

		UserPojo user = getSessionUser(request);
		if (user != null && !"".equals(user.getID()) && user.getID() != null) {
			dto.setUserid(user.getGID());

		} else {
			throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		}
		dto.setuID(user.getID());
		dto.setOwner(user.getGID());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uuowner", dto.getOwner());
		map.put("search", dto);
		map.put("custs", customerManageService.findCustomerInfo(dto,
				getSessionUser(request)));// 查询客户信息
		map.put("bean", user);

		return JSON.toJSONString(map);
	}

	@RequestMapping("findCustomerInfoAjaxApp")
	@ResponseBody
	public List findCustomerInfoAjaxApp(HttpServletRequest request,
			@ModelAttribute QueryCustInfoVO vo, ModelMap model)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		UserPojo user = getSessionUser(request);
		if (user != null && !"".equals(user.getID()) && user.getID() != null) {
			dto.setUserid(user.getGID());
		} else {
			throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		}

		List list = new ArrayList();
		list.add(customerManageService.findCustomerInfo(dto,
				getSessionUser(request)));
		list.add(user);
		list.add(dto.getOwner());
		return list;
	}

	@RequestMapping("findContactInfoApp")
	@ResponseBody
	public List<QueryCustInfoDTO> findContactInfoApp(
			HttpServletRequest request, @ModelAttribute QueryCustInfoVO vo)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		return customerManageService.findContactInfo(dto,
				getSessionUser(request));
	}

	@RequestMapping("findActivitiesApp")
	@ResponseBody
	public List<FindActivitiesDTO> findActivitiesApp(
			HttpServletRequest request, @ModelAttribute QueryCustInfoVO vo)
			throws Exception {
		QueryCustInfoDTO dto = BaseUtil.vo2DTO(vo, QueryCustInfoDTO.class);
		return customerManageService.findActivities(dto,
				getSessionUser(request));
	}
}
