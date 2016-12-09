package com.jg2b.web.crm.actionRecord.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jg2b.api.crm.actionRecord.doman.ActionRecordDoman;
import com.jg2b.api.crm.actionRecord.dto.ActionRecordDto;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.actionRecord.pojo.ActionRecordPojo;
import com.jg2b.api.crm.actionRecord.pojo.CustomerPojo;
import com.jg2b.api.crm.actionRecord.service.IActionRecordService;
import com.jg2b.api.crm.actionRecord.vo.ActionRecordVo;
import com.jg2b.api.crm.common.CrmBaseController;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.dto.FindActivitiesDTO;
import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;
import com.jg2b.api.crm.queryCustInfo.service.IQueryCustInfoService;

@Controller
@RequestMapping("/actionRecordApp")
public class ActionRecordAppController extends CrmBaseController {

	private IActionRecordService actionRecordService;

	@Autowired
	private IQueryCustInfoService customerManageService;

	@Autowired
	public void setActionRecordService(IActionRecordService actionRecordService) {
		this.actionRecordService = actionRecordService;
	}

	/**
	 * 根据用户查询当前用户所做的行动记录
	 * 
	 * @param csName
	 * @return
	 */
	@RequestMapping("/queryActionAppByCsName")
	@ResponseBody
	public List<ActionRecordPojo> queryActionAppByCsName(
			@RequestParam String csName) {
		return actionRecordService.queryActionByCsname(csName);
	}

	/**
	 * 新增行动记录
	 * 
	 * @param <ActionRecordDto>
	 * @param Id
	 *            List<UserFollowDto>
	 * @throws ParseException
	 */
	@RequestMapping("/saveActionRecordsApp")
	@ResponseBody
	public List<FindActivitiesDTO> saveActionRecordsApp(
			ActionRecordVo actionRecodvo, HttpServletRequest request)
			throws ParseException {
		ActionRecordDto actionrecord = actionRecodvo.getActionrecord();
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return null;
		}
		String id = userPojo.getGID();
		String name = userPojo.getName();
		actionrecord.setCsId(id);
		actionrecord.setCsName(name);
		String a = actionRecordService.saveActionRecords(actionrecord, request,
				userPojo);
		if (a != null) {
			return customerManageService.findActivities(new QueryCustInfoDTO(),
					userPojo);
		}
		return null;
	}

	/**
	 * 修改行动记录表
	 * 
	 * @param <ActionRecordDto>
	 * @param Id
	 *            List<UserFollowDto>
	 * @throws ParseException
	 */
	@RequestMapping("/updateActionRecordsApp")
	@ResponseBody
	public ActionRecordDoman updateActionRecordsApp(
			ActionRecordVo actionRecodvo, HttpServletRequest request)
			throws ParseException {
		ActionRecordDto actionrecord = actionRecodvo.getActionrecord();
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return null;
		}
		actionrecord.setCsId(userPojo.getGID());
		actionrecord.setCsName(userPojo.getName());
		ActionRecordPojo recordPojo = actionRecordService.updateActionRecords(
				actionrecord, request, userPojo);
		if (recordPojo != null) {
			return actionRecordService.queryActionRecodDetail(recordPojo
					.getID());
		}
		return null;
	}

	/**
	 * 根据客户名称与联系人姓名查询电话号码
	 */
	@RequestMapping("/queryPhoneNoAppByCusNameandTname")
	@ResponseBody
	public String queryPhoneNoAppByCusNameandTname(int cusId, String tName) {
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
	@RequestMapping("/isCustomerApp")
	@ResponseBody
	public String isCustomerApp(@RequestParam String cusName) {
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
	@RequestMapping("/queryContactsListAppByOwer")
	@ResponseBody
	public List<ActionRecordPojo> queryContactsListAppByOwer(
			@RequestParam int id) {
		List<ActionRecordPojo> contactList = actionRecordService
				.queryContactsListByOwer(id);
		if (contactList != null && !contactList.isEmpty()) {
			return contactList;
		}
		return null;
	}

	/**
	 * 查询行动记录详情(列表页跳转详情)
	 */
	@RequestMapping("/queryActionRecodDetailApp")
	@ResponseBody
	public ActionRecordDoman queryActionRecodDetailApp(@RequestParam int id) {
		ActionRecordDoman actionRecordDoman = actionRecordService
				.queryActionRecodDetail(id);
		return actionRecordDoman;
	}

	/**
	 * 根据id查询行动记录详情
	 */
	@RequestMapping("/queryActionRecodDetailAppById")
	@ResponseBody
	public String queryActionRecodDetailAppById(@RequestParam int id,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return null;
		}
		ActionRecordDoman actionRecordDoman = actionRecordService
				.queryActionRecodDetail(id);
		List<CustomerPojo> CustomerPojoList = actionRecordService
				.queryCustomer(userPojo.getID());
		map.put("actionRecordDoman", actionRecordDoman);
		map.put("pageType", "UPDATE");
		map.put("CustomerPojoList", CustomerPojoList);
		System.out.println(JSON.toJSONString(map));
		return JSON.toJSONString(map);
	}

	/**
	 * 跳转到新增行动记录页面
	 */
	@RequestMapping("/jumpAddActionApp")
	@ResponseBody
	public List<CustomerPojo> jumpAddActionApp(HttpServletRequest request) {
		UserPojo userPojo = getSessionUser(request);
		if (userPojo == null) {
			return null;
		}
		return actionRecordService.queryCustomer(userPojo.getID());

	}

	/**
	 * web客户详情页面 转到新增行动记录页面
	 */
	@RequestMapping("/jumpAddActionAppByCusDetailId")
	@ResponseBody
	public String jumpAddActionAppByCusDetailId(int id,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		ActionRecordDoman actionRecordDoman = actionRecordService
				.jumpAddActionJspByCusDetailId(id);
		UserPojo userPojo = getSessionUser(request);
		map.put("actionRecordDoman", actionRecordDoman);
		map.put("CusDetail", "Cus");
		List<CustomerPojo> CustomerPojoList = actionRecordService
				.queryCustomer(userPojo.getID());
		map.put("CustomerPojoList", CustomerPojoList);

		return JSON.toJSONString(map);

	}

	/**
	 * 上传图片
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("saveAppqImages")
	@ResponseBody
	public Object saveImages(@RequestParam("Id") int Id,
			HttpServletRequest request, ModelMap modelMap) {
		UserPojo userPojo = getSessionUser(request);
		String name = null;
		if (userPojo != null) {
			name = userPojo.getName();
		}
		actionRecordService.saveImages(Id, request, name);
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
	@RequestMapping("queryCustInfoAPP")
	@ResponseBody
	public List<AttachmentDto> queryCustInfo(@RequestParam("Id") int Id) {
		return this.actionRecordService.getDetailAttachmentListFlash(Id);
	}

	/**
	 * 删除图片 逻辑删除
	 * 
	 */

	@RequestMapping("deleteAttachmentAPP")
	@ResponseBody
	public int deleteAttachmentAPP(@Param("attId") int attId) {
		int a = actionRecordService.deleteAttachment(attId);
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
	public Object deleAttachmentByAcgid(@Param("custId") int custId) {
		this.actionRecordService.deleAttachmentByAcgid(custId);
		return "delImgAll_OK";
	}

}
