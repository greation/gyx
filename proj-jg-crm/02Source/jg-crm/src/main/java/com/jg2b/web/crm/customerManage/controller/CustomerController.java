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

import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.customerManage.pojo.CustomerPojo;
import com.jg2b.api.crm.customerManage.service.ICustomerService;
import com.jg2b.api.crm.customerManage.vo.CustomerVO;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.web.crm.queryCustInfo.vo.QueryCustInfoVO;

@RequestMapping("/customer")
@Controller
public class CustomerController extends CrmBaseController {
	@Autowired
	private ICustomerService customerServiceImpl;

	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 添加客户
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/custAdd")
	public Object customersAdd(CustomerVO vo, HttpServletRequest request,
			ModelMap model) throws Exception {

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

		model.addAttribute("pageType", "add");
		model.addAttribute("custBean", map.get("custBeanList"));
		model.addAttribute("contList", map.get("contList"));
		model.addAttribute("addList", map.get("addList"));
		model.addAttribute("tracesList", map.get("tracesList"));

		model.addAttribute("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		model.addAttribute("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		model.addAttribute("regionList",
				customerServiceImpl.queryCodeAndRegion());
		model.addAttribute("channelList",
				customerServiceImpl.queryCodeAndChannel());
		model.addAttribute("user", bean);

		return "/customer/customerDetail";
	}

	/**
	 * 跳转到新增页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/jumpAddcustomer")
	public Object customersAdd(Model model, HttpServletRequest request) {
		UserPojo bean = getSessionUser(request);

		if (bean == null) {
			return "/error";
		}
		model.addAttribute("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		model.addAttribute("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		model.addAttribute("regionList",
				customerServiceImpl.queryCodeAndRegion());
		model.addAttribute("channelList",
				customerServiceImpl.queryCodeAndChannel());
		model.addAttribute("user", bean);
		return "customer/updateCustomer";
	}

	/**
	 * 添加客户并新建
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/custAddRedirect")
	@ResponseBody
	public Object CustomersAddRedirect(CustomerVO vo, HttpServletRequest request)
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
	 * 编辑
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/junmUpdatePage")
	public Object junmUpdatePage(@RequestParam("custId") Integer custId,
			@Param(value = "custGID") String custGID,
			HttpServletRequest request, ModelMap model, QueryCustInfoVO vo) {
		UserPojo bean = getSessionUser(request);
		Integer uId = null;
		String uGId = null;
		if (bean != null) {
			uId = bean.getID();
			uGId = bean.getGID();
		}
		Map<String, Object> map = (Map<String, Object>) customerServiceImpl
				.queryCustomerInformation(custId, uId, uGId);

		model.addAttribute("custBean", map.get("custBeanList"));
		model.addAttribute("contList", map.get("contList"));
		model.addAttribute("addList", map.get("addList"));
		model.addAttribute("tracesList", map.get("tracesList"));
		model.addAttribute("user", bean);

		model.addAttribute("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		model.addAttribute("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		model.addAttribute("regionList",
				customerServiceImpl.queryCodeAndRegion());
		model.addAttribute("channelList",
				customerServiceImpl.queryCodeAndChannel());

		model.addAttribute("pageType", "update");
		return "/customer/updateCustomer";

	}

	/**
	 * 修改客户
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/custUpdate")
	public Object customersUpdate(CustomerVO vo, HttpServletRequest request,
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
		model.addAttribute("custBean", map.get("custBeanList"));
		model.addAttribute("contList", map.get("contList"));
		model.addAttribute("addList", map.get("addList"));
		model.addAttribute("tracesList", map.get("tracesList"));
		model.addAttribute("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		model.addAttribute("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		model.addAttribute("regionList",
				customerServiceImpl.queryCodeAndRegion());
		model.addAttribute("channelList",
				customerServiceImpl.queryCodeAndChannel());
		model.addAttribute("user", bean);
		return "/customer/customerDetail";
	}

	/**
	 * 客户名称查重
	 * 
	 */
	@RequestMapping(value = "/queryCustomerName")
	@ResponseBody
	public int queryCustomerName(@RequestParam(value = "name") String name) {
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
	@RequestMapping(value = "/customerInfo")
	public Object queryCustomerInfo(@RequestParam("custId") Integer custId,
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
		model.addAttribute("custBean", map.get("custBeanList"));
		model.addAttribute("contList", map.get("contList"));
		model.addAttribute("addList", map.get("addList"));
		model.addAttribute("tracesList", map.get("tracesList"));
		model.addAttribute("user", bean);
		model.addAttribute("industryList",
				customerServiceImpl.queryCodesAndIndustry());
		model.addAttribute("corpKindList",
				customerServiceImpl.queryCodesAndCorpKind());
		model.addAttribute("regionList",
				customerServiceImpl.queryCodeAndRegion());
		model.addAttribute("channelList",
				customerServiceImpl.queryCodeAndChannel());
		model.addAttribute("actionRecordDoman",
				customerServiceImpl.getDetailAttachmentList(custId));
		return "/customer/customerDetail";
	}

	/**
	 * 上传图片
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("insertCustInfo")
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

	@RequestMapping("deleteCustInfo")
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
	@RequestMapping("queryCustInfo")
	@ResponseBody
	public List<AttachmentDto> queryCustInfo(
			@RequestParam("custId") Integer custId) {
		return this.customerServiceImpl.getDetailAttachmentList(custId);
	}

	/**
	 * 根据行动记录id全部删除图片 逻辑删除
	 * 
	 */
	@RequestMapping("delImgAll")
	@ResponseBody
	public Object delImgAll(@RequestParam("custId") Integer custId) {

		this.customerServiceImpl.updateCustImgInfo(custId);
		return "delImgAll_OK";
	}
}
