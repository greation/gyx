package com.jg2b.web.crm.actionRecord.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.api.crm.actionRecord.doman.ActionRecordDoman;
import com.jg2b.api.crm.actionRecord.dto.ActionRecordDto;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.actionRecord.pojo.ActionRecordPojo;
import com.jg2b.api.crm.actionRecord.pojo.CustomerPojo;
import com.jg2b.api.crm.actionRecord.service.IActionRecordService;
import com.jg2b.api.crm.actionRecord.vo.ActionRecordVo;
import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;
import com.jg2b.api.crm.queryCustInfo.service.IQueryCustInfoService;

@Controller
@RequestMapping("/actionRecord")
public class ActionRecordController extends CrmBaseController {

	private IActionRecordService actionRecordService;

	@Autowired
	private IQueryCustInfoService customerManageService;

	@Autowired
	public void setActionRecordService(IActionRecordService actionRecordService) {
		this.actionRecordService = actionRecordService;
	}

	/**
	 * 
	 * <p>
	 * 根据用户查询当前用户所做的行动记录
	 * </p>
	 * 
	 * @param Id
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com
	 * @date: Created on 2016年4月25日 下午1:31:54
	 */
	@RequestMapping("/queryActionByCsname")
	public String queryActionByCsname(@RequestParam String csName,
			ModelMap modelMap) {
		List<ActionRecordPojo> actionRecordList = actionRecordService
				.queryActionByCsname(csName);
		modelMap.addAttribute("actionRecordList", actionRecordList);
		return "queryActionRecords";
	}

	/**
	 * 
	 * <p>
	 * 删除行动记录i
	 * </p>
	 * 
	 * @param Id
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com
	 * @date: Created on 2016年4月25日 下午2:53:32
	 */
	@RequestMapping("/deleteActionRecords")
	public String deleteActionRecords(@RequestParam String id) {
		int a = actionRecordService.deleteActionRecords(id);
		if (a == 1) {
			return "success";
		}
		return "failed";
	}

	/**
	 * 新增行动记录
	 * 
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
	 * @param Id
	 *            List<UserFollowDto>
	 * @throws ParseException
	 */
	@RequestMapping("/saveActionRecords")
	public String saveActionRecords(ActionRecordVo actionRecodvo,
			HttpServletRequest request, ModelMap model) throws ParseException {
		ActionRecordDto actionrecord = actionRecodvo.getActionrecord();
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return "login";
		}
		String id = userPojo.getGID();
		String name = userPojo.getName();
		actionrecord.setCsId(id);
		actionrecord.setCsName(name);
		String a = actionRecordService.saveActionRecords(actionrecord, request,
				userPojo);
		if (a != null) {
			model.addAttribute("activities", customerManageService
					.findActivities(new QueryCustInfoDTO(), userPojo));
			return "/customerActive/callActivities";
		}
		return "failed";
	}

	/**
	 * 修改行动记录表
	 * 
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
	 * @param Id
	 *            List<UserFollowDto>
	 * @throws ParseException
	 */
	@RequestMapping("/updateActionRecords")
	public String updateActionRecords(ActionRecordVo actionRecodvo,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		ActionRecordDto actionrecord = actionRecodvo.getActionrecord();
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return "login";
		}

		actionrecord.setCsId(userPojo.getGID());
		actionrecord.setCsName(userPojo.getName());
		ActionRecordPojo recordPojo = actionRecordService.updateActionRecords(
				actionrecord, request, userPojo);
		if (recordPojo != null) {
			ActionRecordDoman actionRecordDoman = actionRecordService
					.queryActionRecodDetail(recordPojo.getID());
			modelMap.addAttribute("actionRecordDoman", actionRecordDoman);
			return "actionRecord/callActivitiesDetail";
		}
		return "failed";
	}

	/**
	 * 根据客户名称与联系人姓名查询电话号码
	 */
	@RequestMapping("/queryPhoneNoByCusNameandTname")
	@ResponseBody
	public String queryPhoneNoByCusNameandTname(int cusId, String tName,
			ModelMap modelMap) {
		String tellphone = actionRecordService.queryPhoneNoByCusNameandTname(
				cusId, tName);
		if (tellphone != null && tellphone != "") {
			return tellphone;
		}
		String msg = "不是常用联系人";
		return msg;
	}

	/**
	 * 校验客户名称是否真实存在
	 */
	@RequestMapping("/isCustomer")
	@ResponseBody
	public String isCustomer(@RequestParam String cusName) {
		boolean a = actionRecordService.isCustomer(cusName);
		if (a == false) {
			String msg = "该客户不存在";
			return msg;
		}
		return "";
	}

	/**
	 * 根据客户名称查询所属联系人,职位
	 */
	@RequestMapping("/queryContactsListByOwer")
	@ResponseBody
	public List<ActionRecordPojo> queryContactsListByOwer(@RequestParam int id,
			ModelMap modelMap) {
		List<ActionRecordPojo> contactList = actionRecordService
				.queryContactsListByOwer(id);
		if (contactList != null && !contactList.isEmpty()) {
			/* modelMap.addAttribute("contactList",contactList); */
			return contactList;
		}
		return null;
	}

	/**
	 * 查询行动记录详情(列表页跳转详情)
	 */
	@RequestMapping("/queryActionRecodDetail")
	public String queryActionRecodDetail(@RequestParam int id, ModelMap modelMap) {
		ActionRecordDoman actionRecordDoman = actionRecordService
				.queryActionRecodDetail(id);
		modelMap.addAttribute("actionRecordDoman", actionRecordDoman);
		return "actionRecord/callActivitiesDetail";
	}

	/**
	 * 根据id查询行动记录详情
	 */
	@RequestMapping("/queryActionRecodDetailById")
	public String queryActionRecodDetailById(@RequestParam int id,
			ModelMap modelMap, HttpServletRequest request) {
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return "/login";
		}
		ActionRecordDoman actionRecordDoman = actionRecordService
				.queryActionRecodDetail(id);
		modelMap.addAttribute("actionRecordDoman", actionRecordDoman);
		modelMap.addAttribute("pageType", "UPDATE");
		List<CustomerPojo> CustomerPojoList = actionRecordService
				.queryCustomer(userPojo.getID());
		modelMap.addAttribute("CustomerPojoList", CustomerPojoList);
		return "actionRecord/updateActivitiesDetail";
	}

	/**
	 * 跳转到新增行动记录页面
	 */
	@RequestMapping("/jumpAddActionJsp")
	public String jumpAddActionJsp(ModelMap modelMap, HttpServletRequest request) {
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return "login";
		}
		List<CustomerPojo> CustomerPojoList = actionRecordService
				.queryCustomer(userPojo.getID());
		modelMap.addAttribute("CustomerPojoList", CustomerPojoList);
		return "actionRecord/updateActivitiesDetail";
		/* return "actionRecord/addCallActivities" ; */
	}

	/**
	 * 客户详情页面 转到新增行动记录页面 
	 */
	@RequestMapping("/jumpAddActionJspByCusDetailId")
	public String jumpAddActionJspByCusDetailId(ModelMap modelMap,int id,HttpServletRequest request){ 
		ActionRecordDoman actionRecordDoman=actionRecordService.jumpAddActionJspByCusDetailId(id);
		UserPojo userPojo=getSessionUser(request);
		modelMap.addAttribute("actionRecordDoman",actionRecordDoman);
		modelMap.addAttribute("CusDetail","Cus");
		List<CustomerPojo> CustomerPojoList=actionRecordService.queryCustomer(userPojo.getID());
		modelMap.addAttribute("CustomerPojoList",CustomerPojoList);
	    return "actionRecord/updateActivitiesDetail" ;
	    
    }
	/**
	 * 前台页面客户名称
	 */
	/*
	 * @RequestMapping("/queryCustomer") public String queryCustomer(ModelMap
	 * modelMap){ List<CustomerPojo>
	 * CustomerPojoList=actionRecordService.queryCustomer();
	 * modelMap.addAttribute("CustomerPojoList",CustomerPojoList); return
	 * "actionRecord/addCallActivities" ; }
	 */
	
	
	/**
	 * 上传图片
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("saveImages")
	@ResponseBody
	public Object saveImages(@RequestParam("Id") int Id,HttpServletRequest request, ModelMap modelMap) {
		UserPojo userPojo = getSessionUser(request);
		String name=null;
		if(userPojo!=null){
		 name=userPojo.getName();
		}
		actionRecordService.saveImages(Id, request,name);
		return "upload_ok";
	}
	
	/**
	 * 根据行动记录id查询图片
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("queryCustInfo")
	@ResponseBody
	public List<AttachmentDto> queryCustInfo(
			@RequestParam("Id") int Id) {
		return this.actionRecordService.getDetailAttachmentListFlash(Id);
	}
	
	
	/**
	 * 删除图片 逻辑删除
	 * 
	 */

	@RequestMapping("deleteAttachment")
	@ResponseBody
	public int deleteAttachment (@Param("attId") int attId) {
		int a=actionRecordService.deleteAttachment(attId);
		if (a == 1) {
			return a;
		} else {
			return 0;
		}
	}
	
	/**
	 * 根据行动记录id删除图片 逻辑删除(批量)
	 * 
	 */

	@RequestMapping("deleAttachmentByAcgid")
	@ResponseBody
	public Object deleAttachmentByAcgid (@Param("custId") int custId) {
		this.actionRecordService.deleAttachmentByAcgid(custId);
		return "delImgAll_OK";
	}



}
