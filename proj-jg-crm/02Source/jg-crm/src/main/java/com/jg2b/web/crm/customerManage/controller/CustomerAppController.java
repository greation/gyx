package com.jg2b.web.crm.customerManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.customerManage.pojo.CustomerPojo;
import com.jg2b.api.crm.customerManage.service.ICustomerService;
import com.jg2b.api.crm.customerManage.vo.CustomerVO;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.web.crm.queryCustInfo.vo.QueryCustInfoVO;

@RequestMapping("/customerApp")
@Controller
public class CustomerAppController extends CrmBaseController {
	@Autowired
	private ICustomerService customerServiceImpl;

	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 添加客户
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/addCsutApp")
	@ResponseBody
	public Object addCsutApp(CustomerVO vo, HttpServletRequest request)
			throws Exception {

		UserPojo bean = getSessionUser(request);
		Integer uId = null;
		String uGId = null;
		if (bean != null) {
			uGId = bean.getGID();
			uId = bean.getID();

		}
		CustomerPojo cust = this.customerServiceImpl.insertCustomers(uGId, vo,
				request, bean);
		Map<String, Object> map = (Map<String, Object>) customerServiceImpl
				.queryCustomerInformation(cust.getID(), uId, uGId);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("custBean", map.get("custBeanList"));
		resultMap.put("contList", map.get("contList"));
		resultMap.put("addList", map.get("addList"));
		resultMap.put("tracesList", map.get("tracesList"));
		resultMap.put("user", bean);

		resultMap.put("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		resultMap.put("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		resultMap.put("regionList", customerServiceImpl.queryCodeAndRegion());
		resultMap.put("channelList", customerServiceImpl.queryCodeAndChannel());

		resultMap.put("pageType", "update");
		return JSON.toJSONString(resultMap);

	}

	/**
	 * 添加客户并新建
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/addCustRedirectApp")
	@ResponseBody
	public Object addCustRedirectApp(CustomerVO vo, HttpServletRequest request)
			throws Exception {

		UserPojo bean = getSessionUser(request);
		Integer uId = null;
		String uGId = null;
		if (bean != null) {
			uGId = bean.getGID();
			uId = bean.getID();
		}
		this.customerServiceImpl.insertCustomers(uGId, vo, request, bean);
		return "ok";
	}

	/**
	 * 跳转到新增页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/jumpAddcustomerApp")
	@ResponseBody
	public Object addCustomerApp(Model model, HttpServletRequest request) {
		UserPojo bean = getSessionUser(request);
		if (bean == null) {
			return "/error";
		}
		map.put("industryList", customerServiceImpl.queryCodesAndIndustry());
		map.put("corpKindList", customerServiceImpl.queryCodesAndCorpKind());
		map.put("regionList", customerServiceImpl.queryCodeAndRegion());
		map.put("channelList", customerServiceImpl.queryCodeAndChannel());
		map.put("user", bean);
		return JSON.toJSONString(map);
	}

	/**
	 * 编辑
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/jumpUpdatePageApp")
	@ResponseBody
	public Object jumpUpdatePageApp(@RequestParam("custId") Integer custId,
			@Param(value = "custGID") String custGID,
			HttpServletRequest request, QueryCustInfoVO vo) {
		UserPojo bean = getSessionUser(request);
		Integer uId = null;
		String uGId = null;
		if (bean != null) {
			uId = bean.getID();
			uGId = bean.getGID();
		}
		Map<String, Object> map = (Map<String, Object>) customerServiceImpl
				.queryCustomerInformation(custId, uId, uGId);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("custBean", map.get("custBeanList"));
		resultMap.put("contList", map.get("contList"));
		resultMap.put("addList", map.get("addList"));
		resultMap.put("tracesList", map.get("tracesList"));
		resultMap.put("user", bean);

		resultMap.put("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		resultMap.put("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		resultMap.put("regionList", customerServiceImpl.queryCodeAndRegion());
		resultMap.put("channelList", customerServiceImpl.queryCodeAndChannel());

		resultMap.put("pageType", "update");
		return JSON.toJSONString(resultMap);
	}

	/**
	 * 修改客户
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateCustApp")
	@ResponseBody
	public Object updateCustApp(CustomerVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {

		UserPojo bean = getSessionUser(request);
		Integer uId = null;
		String uGId = null;
		if (bean != null) {
			uId = bean.getID();
			uGId = bean.getGID();
		}
		int count = this.customerServiceImpl.updateCustomers(vo, request, bean);

		Map<String, Object> map = (Map<String, Object>) customerServiceImpl
				.queryCustomerInformation(vo.getCustID(), uId, uGId);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("custBean", map.get("custBeanList"));
		resultMap.put("contList", map.get("contList"));
		resultMap.put("addList", map.get("addList"));
		resultMap.put("tracesList", map.get("tracesList"));
		resultMap.put("user", bean);

		resultMap.put("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		resultMap.put("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		resultMap.put("regionList", customerServiceImpl.queryCodeAndRegion());
		resultMap.put("channelList", customerServiceImpl.queryCodeAndChannel());

		resultMap.put("pageType", "update");
		return JSON.toJSONString(resultMap);
	}

	/**
	 * 客户名称查重
	 * 
	 */
	@RequestMapping(value = "/queryCustomerNameApp")
	@ResponseBody
	public int queryCustomerNameApp(@RequestParam(value = "name") String name) {
		int result = this.customerServiceImpl.queryCustomerName(name);
		return result;
	}

	/**
	 * 客户详细信息
	 * 
	 * @param request
	 * @param custBean
	 * @param model
	 * @return //
	 */
	@RequestMapping(value = "/queryCustomerInfoApp")
	@ResponseBody
	public Object queryCustomerInfoApp(@RequestParam("custId") Integer custId,
			HttpServletRequest request, ModelMap model) {
		UserPojo bean = getSessionUser(request);
		Integer uId = null;
		String uGId = null;
		if (bean != null) {

			uId = bean.getID();
			uGId = bean.getGID();
		}
		Map<String, Object> map = (Map<String, Object>) customerServiceImpl
				.queryCustomerInformation(custId, uId, uGId);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("custBean", map.get("custBeanList"));
		resultMap.put("contList", map.get("contList"));
		resultMap.put("addList", map.get("addList"));
		resultMap.put("tracesList", map.get("tracesList"));
		resultMap.put("user", bean);

		/*
		 * resultMap.put("industryList",
		 * customerServiceImpl.queryCodesAndIndustry());
		 * resultMap.put("corpKindList",
		 * customerServiceImpl.queryCodesAndCorpKind());
		 * resultMap.put("regionList",
		 * customerServiceImpl.queryCodeAndRegion());
		 * resultMap.put("channelList",
		 * customerServiceImpl.queryCodeAndChannel());
		 */

		resultMap.put("pageType", "update");
		return JSON.toJSONString(resultMap);
	}

	/**
	 * 上传图片
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("insertCustInfoApp")
	@ResponseBody
	public Object insertCustInfo(@RequestParam("custId") Integer custId,
			HttpServletRequest request, ModelMap model) {

		UserPojo bean = getSessionUser(request);
		String userName = null;
		if (bean != null) {
			userName = bean.getName();
		}
		this.customerServiceImpl.insertCustInfo(custId, request, userName);
		return "upload_ok";
	}

	/**
	 * 删除图片 逻辑删除
	 * 
	 */

	@RequestMapping("deleteCustInfoApp")
	@ResponseBody
	public int deleteCustInfo(@Param("attId") Integer attId) {
		int a = this.customerServiceImpl.deleteCustInfo(attId);
		if (a == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 查询图片
	 * 
	 * @param custId
	 * @return
	 */
	@RequestMapping("queryCustInfoApp")
	@ResponseBody
	public List<AttachmentDto> queryCustInfo(
			@RequestParam("custId") Integer custId) {
		return this.customerServiceImpl.getDetailAttachmentList(custId);
	}

	/**
	 * 根据行动记录id全部删除图片 逻辑删除
	 * 
	 */
	@RequestMapping("delImgAllApp")
	@ResponseBody
	public Object delImgAll(@RequestParam("custId") Integer custId) {

		this.customerServiceImpl.updateCustImgInfo(custId);
		return "delImgAll_OK";
	}
}
