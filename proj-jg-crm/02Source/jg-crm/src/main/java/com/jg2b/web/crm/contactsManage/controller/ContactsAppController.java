package com.jg2b.web.crm.contactsManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.contactInfo.dto.ContactDto;
import com.jg2b.api.crm.contactInfo.dto.TraceDto;
import com.jg2b.api.crm.contactInfo.service.IContactService;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.common.utils.BaseUtil;
import com.jg2b.web.crm.contactsManage.vo.ContactsVo;

@Controller
@RequestMapping("/contactApp")
public class ContactsAppController extends CrmBaseController {

	@Autowired
	private IContactService contactservice;

	/**
	 * 新增联系人
	 * 
	 * @param request
	 * @param contactsvo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertContactApp")
	@ResponseBody
	public int isertContactApp(HttpServletRequest request,
			@ModelAttribute ContactsVo contactsvo) throws Exception {
		ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo, ContactDto.class);
		UserPojo bean = getSessionUser(request);
		String userId = null;
		if (bean != null) {
			userId = bean.getGID();
		}
		contactsdto.setCreate(userId);

		return contactservice.insertContacts(contactsdto, request,
				getSessionUser(request));
	}

	@RequestMapping("/insertAndCreateContactsApp")
	@ResponseBody
	public Object insertAndCreateContactsApp(HttpServletRequest request,
			@ModelAttribute ContactsVo contactsvo) throws Exception {
		ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo, ContactDto.class);
		UserPojo bean = getSessionUser(request);
		String userId = null;
		if (bean != null) {
			userId = String.valueOf(bean.getID());
		}
		contactsdto.setCreate(userId);

		return contactservice.insertContacts(contactsdto, request,
				getSessionUser(request));
	}

	/**
	 * 联系人修改
	 * 
	 * @param request
	 * @param contactsvo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/UpdateContactsApp")
	@ResponseBody
	public int updateContactApp(HttpServletRequest request,
			@ModelAttribute ContactsVo contactsvo) throws Exception {
		ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo, ContactDto.class);
		return contactservice.updateContacts(contactsdto,
				getSessionUser(request));
	}

	/**
	 * 查询所属客户
	 * 
	 * @param map
	 * @param request
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchCustAllApp")
	@ResponseBody
	public List<String> searchCustAllApp(HttpServletRequest request,
			@ModelAttribute ContactsVo vo) throws Exception {
		ContactDto dto = BaseUtil.vo2DTO(vo, ContactDto.class);
		UserPojo bean = getSessionUser(request);
		if (bean != null) {
			dto.setUserId(String.valueOf(bean.getID()));
		}
		return contactservice.searchCustAll(dto);
	}

	/**
	 * 
	 * @Title: ContactsController.java
	 * @Package com.jg2b.web.crm.contactsManage.controller
	 * @Description: 联系人查重
	 * @author Yuan.S
	 * @throws Exception
	 * @date 2016年5月10日 下午5:09:28
	 */
	@RequestMapping("/checkContactsApp")
	@ResponseBody
	public List<ContactDto> checkContactsApp(
			@ModelAttribute ContactsVo contactsvo) throws Exception {
		ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo, ContactDto.class);
		return contactservice.checkContacts(contactsdto);
	}

	/**
	 * 
	 * @Description: 通过ID查询的联系人
	 */
	@RequestMapping("/searchContsAppByID")
	@ResponseBody
	public String searchContsAppByID(HttpServletRequest request,
			@ModelAttribute ContactsVo contactsvo) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ContactDto dto = BaseUtil.vo2DTO(contactsvo, ContactDto.class);
		UserPojo bean = getSessionUser(request);
		if (bean != null) {
			dto.setUserId(String.valueOf(bean.getID()));// 所属客服ID
		}
		List<ContactDto> conlist = contactservice.searchContsByID(dto);
		List<ContactDto> list = contactservice.search_CustByID(dto);
		resultMap.put("clist", conlist);
		resultMap.put("list", list);
		return JSON.toJSONString(resultMap);
	}

	/**
	 * <p>
	 * 查询联系人详情页面
	 * </p>
	 * 
	 */
	@RequestMapping("/searchContactDetailApp")
	@ResponseBody
	public String searchContsByIDApp(String contactID, ModelMap map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ContactDto dto = new ContactDto();
		dto.setID(Integer.valueOf(contactID));
		List<ContactDto> list = contactservice.searchContsByID(dto);
		List<TraceDto> pastList = contactservice.searchPast(dto);
		if (list != null && list.size() > 0) {
			resultMap.put("contact", list.get(0));
		}
		resultMap.put("pastList", pastList);
		return JSON.toJSONString(resultMap);
	}

	@RequestMapping("/refreshPage")
	public ModelAndView refreshPage() {
		return new ModelAndView("redirect:/Cust/findContactInfo.do");
	}

	/**
	 * 删除联系人 逻辑删除 *
	 * 
	 * @param request
	 * @param contactsvo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteContactApp")
	@ResponseBody
	public String deleteContactApp(@RequestParam("contId") Integer contId)
			throws Exception {

		if (contactservice.deleteContact(contId) != 0) {
			return "del_ok";
		}

		return "del_error";
	}
}
