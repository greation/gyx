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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.contactInfo.dto.ContactDto;
import com.jg2b.api.crm.contactInfo.dto.TraceDto;
import com.jg2b.api.crm.contactInfo.service.IContactService;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.common.baseBean.UploadCommonBean;
import com.jg2b.common.utils.BaseUtil;
import com.jg2b.common.utils.FileUploadUtil;
import com.jg2b.web.crm.contactsManage.vo.ContactsVo;
import com.jg2b.web.crm.queryCustInfo.controller.QueryCustInfoController;

 

@Controller
@RequestMapping("/contact")
public class ContactsController extends CrmBaseController{
	Map<String,String> map=new HashMap<String,String>();
	
	@Autowired
	private IContactService contactservice;
	
	
	/**
	 * 
	* @Title: ContactsController.java 
	* @Package com.jg2b.web.crm.contactsManage.controller 
	* @Description:联系人添加
	* @author Yuan.S   
	 * @throws Exception 
	* @date 2016年5月10日 下午5:10:23
	 */
	@RequestMapping("/insertContacts")
	public ModelAndView insertContact(HttpServletRequest request,@ModelAttribute ContactsVo contactsvo) throws Exception{
		 ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo,ContactDto.class);
		UserPojo bean = getSessionUser(request);
		String userId = null;
		if (bean != null) {
			userId = bean.getGID();
		}
		contactsdto.setCreate(userId);
		if(contactservice.insertContacts(contactsdto,request,getSessionUser(request))!=0){
			return new ModelAndView("redirect:/Cust/findContactInfo.do");
		} else{
			return new ModelAndView("redirect:/Cust/findContactInfo.do");
		}
		
	}
	
	@RequestMapping("/insertAndCreateContacts")
	public Object insertAndCreateContacts(HttpServletRequest request,@ModelAttribute ContactsVo contactsvo) throws Exception{
		 ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo,ContactDto.class);
		UserPojo bean = getSessionUser(request);
		String userId = null;
		if (bean != null) {
			userId = String.valueOf(bean.getID());
		} 
		contactsdto.setCreate(userId);
		if(contactservice.insertContacts(contactsdto,request,getSessionUser(request))!=0){
			return "redirect:/contact/searchContsByID";
		}
		return "redirect:/contact/searchContsByID";
	}
	
	
	/**
	 * 
	* @Title: ContactsController.java 
	* @Package com.jg2b.web.crm.contactsManage.controller 
	* @Description: 联系人修改
	* @author Yuan.S   
	 * @throws Exception 
	* @date 2016年5月10日 下午5:10:15
	 */
	@RequestMapping("/updateContacts")
	public ModelAndView updateContact(HttpServletRequest request,@ModelAttribute ContactsVo contactsvo) throws Exception{
			ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo,ContactDto.class);
			if(contactservice.updateContacts(contactsdto,getSessionUser(request))!=0)
			{		return new ModelAndView("redirect:/Cust/findContactInfo.do");
			}
			return new ModelAndView("redirect:/Cust/findContactInfo.do");
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
	@RequestMapping("/checkContacts")
	@ResponseBody
	public List<ContactDto> checkContacts(@ModelAttribute ContactsVo contactsvo) throws Exception{
		 ContactDto contactsdto = BaseUtil.vo2DTO(contactsvo,ContactDto.class);
		 return contactservice.checkContacts(contactsdto);
	}
	
	 /**
	  * 
	 * @Title: ContactsController.java 
	 * @Package com.jg2b.web.crm.contactsManage.controller 
	 * @Description: 查询所属客户
	 * @author Yuan.S   
	 * @throws Exception 
	 * @date 2016年5月9日 下午3:21:15
	  */
	@RequestMapping(value="/searchCustAll")
	public ModelAndView searchCustAll(ModelMap map,HttpServletRequest request,
			@ModelAttribute ContactsVo vo) throws Exception{
		ContactDto dto = BaseUtil.vo2DTO(vo,ContactDto.class);
		UserPojo bean = getSessionUser(request);
		if (bean != null) {
			dto.setUserId(String.valueOf(bean.getID()));
		}
		 List<String> list=contactservice.searchCustAll(dto);
		 map.addAttribute("list",list);
		 return new ModelAndView( "redirect:/contact/searchContsByID");
	}
	/**
	 * 
	* @Title: ContactsController.java 
	* @Package com.jg2b.web.crm.contactsManage.controller 
	* @Description: 通过ID查询的联系人
	* @author Yuan.S   
	 * @throws Exception 
	* @date 2016年5月10日 下午5:09:53
	 */
	@RequestMapping("/searchContsByID")
	public String searchContsByID(HttpServletRequest request,@ModelAttribute ContactsVo contactsvo,ModelMap map) throws Exception{
		ContactDto dto = BaseUtil.vo2DTO(contactsvo,ContactDto.class);
		UserPojo bean = getSessionUser(request);
		 
		if (bean != null) {
			dto.setUserId(String.valueOf(bean.getID())) ;//所属客服ID
		} 
		List<ContactDto> conlist=contactservice.searchContsByID(dto);
		List<ContactDto> list=contactservice.search_CustByID(dto);
		map.addAttribute("clist",conlist);
		map.addAttribute("list",list);
		return "contact/updateContacts";
	}
	
	/**
	 * <p>查询联系人详情页面</p>
	 * 
	 * @param contactID
	 * @param map
	 * @return
	 * @author: 林雨竹 - linyuzhu@jg2b.com 
	 * @date: Created on 2016年5月10日 下午6:56:57
	 */
	@RequestMapping("/searchContactDetail")
	public String searchContsByID(String contactID,ModelMap map){
		ContactDto dto = new ContactDto();
		dto.setID(Integer.valueOf(contactID));
		List<ContactDto> list=contactservice.searchContsByID(dto);
		List<TraceDto> pastList=contactservice.searchPast(dto);
		if(list!=null&&list.size()>0){
			map.addAttribute("contact",list.get(0));
		}
		map.addAttribute("pastList",pastList);
		return "contact/contactsDetail";
	}
	
	
	@RequestMapping("/refreshPage")
	public ModelAndView refreshPage(){
		return new ModelAndView("redirect:/Cust/findContactInfo.do");
	}
	
	
	
}
