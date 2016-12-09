package com.jg2b.api.crm.actionRecord.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jg2b.api.crm.actionRecord.doman.ActionRecordDoman;
import com.jg2b.api.crm.actionRecord.dto.ActionRecordDto;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.actionRecord.pojo.ActionRecordPojo;
import com.jg2b.api.crm.actionRecord.pojo.CustomerPojo;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.common.baseBean.MediaAttachsBaseBean;
import com.jg2b.common.baseBean.StreamAttachsBaseBean;

public interface IActionRecordService {
	/**
	 * 根据用户查询行动记录
	 * 
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
	 * @param Id
	 *            List<UserFollowDto>
	 */
	List<ActionRecordPojo> queryActionByCsname(String csName);

	/**
	 * 
	 * <p>
	 * 保存行动记录
	 * </p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com
	 * @throws ParseException
	 * @date: Created on 2016年4月25日 上午10:35:24
	 */
	String saveActionRecords(ActionRecordDto actionrecord,
			HttpServletRequest request, UserPojo userPojo)
			throws ParseException;

	/**
	 * 
	 * <p>
	 * 删除行动记录
	 * </p>
	 * 
	 * @param Id
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com
	 * @date: Created on 2016年4月25日 上午10:34:24
	 */
	int deleteActionRecords(String Id);

	/**
	 * 
	 * <p>
	 * 修改行动记录
	 * </p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com
	 * @throws ParseException
	 * @date: Created on 2016年4月25日 上午10:34:32
	 */
	ActionRecordPojo updateActionRecords(ActionRecordDto actionrecord,
			HttpServletRequest request, UserPojo userPojo)
			throws ParseException;

	/**
	 * 
	 * <p>
	 * 通过公司名称与客户名称查询联系人电话号码
	 * </p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com
	 * @date: Created on 2016年4月25日 上午10:34:32
	 */
	String queryPhoneNoByCusNameandTname(int cusId, String tName);

	/**
	 * 校验客户名称是否真实存在
	 */
	boolean isCustomer(String cusName);

	/**
	 * 根据客户名称查询客户下所有联系人
	 */
	List<ActionRecordPojo> queryContactsListByOwer(int cusName);

	/**
	 * 查询行动记录详情
	 */
	ActionRecordDoman queryActionRecodDetail(int id);

	/**
	 * 查询所有客户id名称
	 */
	List<CustomerPojo> queryCustomer(int owner);

	/**
	 * <p>
	 * 客户详情页面跳转到新增行动记录页面
	 * </p>
	 * 
	 * @param active
	 * @param custID
	 * @return
	 * @author: zhagnpeng - linyuzhu@jg2b.com
	 * @date: Created on 2016年5月12日 上午10:08:00
	 */
	ActionRecordDoman jumpAddActionJspByCusDetailId(int id);

	public int saveMediaAttachs(MediaAttachsBaseBean mAttachMentBean);

	public int saveStreamAttachs(StreamAttachsBaseBean streamAttachsBaseBean);
	
	/**
	 * 上传图片
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */

	void saveImages(int id,HttpServletRequest request,String name);
	
	/**
	 * 上传图片公用方法
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	 void saveImage(String gid,HttpServletRequest request,String relativePath);
	 /**
		 * 图片上传成功后刷新图片
		 * 
		 * @param custId
		 * @param request
		 * @param model
		 * @return
		 */
	 List<AttachmentDto> getDetailAttachmentListFlash(int id);
	 
	 /**
		 * 删除图片(批量)
		 * 
		 * @param custId
		 * @param request
		 * @param model
		 * @return
		 */
	int deleAttachmentByAcgid(int id);
	
	 /**
	 * 删除图片(单张)
	 * 
	 * @param custId
	 * @param request
	 * @param model
	 * @return
	 */
	int  deleteAttachment(int attId);
	 
	 
	 
}
