package com.jg2b.web.crm.actionRecord.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jg2b.api.crm.actionRecord.dao.IActionRecordDao;
import com.jg2b.api.crm.actionRecord.doman.ActionRecordDoman;
import com.jg2b.api.crm.actionRecord.dto.ActionRecordDto;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.actionRecord.pojo.ActionRecordPojo;
import com.jg2b.api.crm.actionRecord.pojo.CustomerPojo;
import com.jg2b.api.crm.actionRecord.service.IActionRecordService;
import com.jg2b.api.crm.contactInfo.pojo.AddressPojo;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.traces.service.ICommonTracesService;
import com.jg2b.common.baseBean.AttachmentBaseBean;
import com.jg2b.common.baseBean.MediaAttachsBaseBean;
import com.jg2b.common.baseBean.StreamAttachsBaseBean;
import com.jg2b.common.baseBean.UploadCommonBean;
import com.jg2b.common.contants.GlobalContants;
import com.jg2b.common.pojo.AttachmentPojo;
import com.jg2b.common.pojo.MediaAttachsPojo;
import com.jg2b.common.pojo.StreamAttachsPojo;
import com.jg2b.common.utils.DateUtil;
import com.jg2b.common.utils.FileUploadUtil;

@Service("actionRecordService")  
public class ActionRecordServiceImpl implements IActionRecordService {
	private static Logger logger = Logger.getLogger(ActionRecordServiceImpl.class); 
	private IActionRecordDao actionRecordDao;
	@Autowired
	public void setActionRecordDao(IActionRecordDao actionRecordDao) {
		this.actionRecordDao = actionRecordDao;
	}
	
	@Autowired
	private ICommonTracesService commonTracesService;
	
	public void setCommonTracesService(ICommonTracesService commonTracesService) {
		this.commonTracesService = commonTracesService;
	}
	/**
	 * 根据用户查询行动记录
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 */
	public List<ActionRecordPojo> queryActionByCsname(String csName){
		List<ActionRecordPojo> actionRecordList=actionRecordDao.queryActionByCsname(csName);
		return actionRecordList;
	}
	/**
	 * 新增行动记录
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 */
	@Transactional
	public String saveActionRecords(ActionRecordDto actionrecord,HttpServletRequest request,UserPojo userPojo) {
		logger.info("---保存行动记录开始---");
		int cusid=actionrecord.getCusId();
		String tName=actionrecord.getRecepter();
		ActionRecordPojo actionRecordPojo=actionRecordDao.queryPhoneNoByCusNameandTname(cusid, tName);
		String ower=actionRecordDao.queryGidbyCusid(cusid);
		actionrecord.setOwer(ower);
		if(actionRecordPojo!=null){
			String RcpCid =actionRecordPojo.getRcpCid();
			if(RcpCid!=null){
				actionrecord.setRcpCid(actionRecordPojo.getRcpCid());
			}	
		}
		String a = null;
		try {
			 a = saveRecord(actionrecord,userPojo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//修改客户活跃度  +1   2016-5-12 10:10:41  linyuzhu
		actionRecordDao.updateCustomerActive(1, actionrecord.getCusId());
		String dateString=getStringToday();
		String relativePath=dateString+GlobalContants.P_OPERATE_SIGN+"actionrecord"+GlobalContants.P_OPERATE_SIGN+actionrecord.getCsName();
		FileUploadUtil fileUploadUtil=new FileUploadUtil(relativePath, request);
		List<UploadCommonBean> uploadList=fileUploadUtil.UploadFile();
		for (UploadCommonBean uploadCommonBean : uploadList) {
			//获去文件信息
			AttachmentBaseBean ttachmentBaseBean=uploadCommonBean.getAttachMentBean();
			MediaAttachsBaseBean mAttachMentBean=uploadCommonBean.getmAttachMentBean();
			StreamAttachsBaseBean streamAttachsBaseBean=uploadCommonBean.getsAttachMentBean();
			//保存附件信息
			if(ttachmentBaseBean!=null){
			saveAttachments(ttachmentBaseBean,a);
			logger.info("---保存Attachment结束---"+ttachmentBaseBean.getID());}
			if(mAttachMentBean!=null){
			//保存附件信息长宽高
			saveMediaAttachs( mAttachMentBean);
			logger.info("---保存MediaAttachs结束---"+ttachmentBaseBean.getID());}
			if(streamAttachsBaseBean!=null){
			saveStreamAttachs(streamAttachsBaseBean);
			logger.info("---保存StreamAttachs结束---"+ttachmentBaseBean.getID());	}
		}
		logger.info("---保存行动结束---");
		//**根据订阅者id（行动记录id）存储图片数据		
		return a;
		}

	
	/**
	 * 逻辑删除行动记录与行动记录图片
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 */
	@Transactional
	public int deleteActionRecords(String id) {
		int a=actionRecordDao.deleActionRecord(id);
		/*List<ImagePojo> imagePojoList=actionRecordDao.queryImagsList(id);
		for (ImagePojo imagePojo : imagePojoList) {
			String aId=imagePojo.getId();
			int a=actionRecordDao.deleImage(aId);
		}*/
		System.out.println(a);
		return a;
	}
	/**
	 * 修改行动记录表
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 * @throws ParseException 
	 */
	@Transactional
	public ActionRecordPojo updateActionRecords(ActionRecordDto actionrecord,HttpServletRequest request,UserPojo userPojo) throws ParseException {
		logger.info("---保存行动记录开始---");
		int cusid=actionrecord.getCusId();
		String tName=actionrecord.getRecepter();
		ActionRecordPojo actionRecordPojo=actionRecordDao.queryPhoneNoByCusNameandTname(cusid, tName);
		String ower=actionRecordDao.queryGidbyCusid(cusid);
		actionrecord.setOwer(ower);
		if(actionRecordPojo!=null){
			String RcpCid =actionRecordPojo.getRcpCid();
			if(RcpCid!=null){
				actionrecord.setRcpCid(RcpCid);	
			}	
		}
		ActionRecordPojo recordPojo=null;
		try {
			recordPojo = updateRecord(actionrecord,userPojo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//修改客户活跃度  +1   2016-5-12 10:10:41  linyuzhu
		actionRecordDao.updateCustomerActive(1, actionrecord.getCusId());	
		return recordPojo;
	}
	/**
	 * 根据客户名称与联系人姓名查询电话号码
	 */
	public String queryPhoneNoByCusNameandTname(int cusId,String tName) {
		ActionRecordPojo actionRecordPojo =actionRecordDao.queryPhoneNoByCusNameandTname(cusId, tName);
		if(actionRecordPojo!=null){
			if(actionRecordPojo.getRcptPhone()!=null){
				String tellPhone=actionRecordPojo.getRcptPhone();
				return tellPhone;
			}		   
	}
		 return  "";
	}
	
	
	/**
	 * 校验客户名称是否真实存在
	 */
	 public boolean isCustomer(String cusName){
		 CustomerPojo customerPojo=actionRecordDao.isCustomer(cusName);
		 if(customerPojo!=null){
			 return true;  
		 }
		 return false; 
		
	 }
	 /**
		 * 根据客户名称查询所属联系人
		 */
	public List<ActionRecordPojo> queryContactsListByOwer(int cusName) {
		List<ActionRecordPojo> queryContactsListByOwer=actionRecordDao.queryContactsListByOwer(cusName);
		return queryContactsListByOwer;
	}
	
	   /**
	    * 查询行动记录详情
		 */
	public ActionRecordDoman queryActionRecodDetail(int id) {
		ActionRecordDoman actionRecordDoman=actionRecordDao.queryActionRecodDetail(id);
		actionRecordDoman.setAttachmentDto(getDetailAttachmentList(actionRecordDoman.getGid()));
		return actionRecordDoman;
	}
	
	/**
	 * 返回图片路径通过接口
     */
	 public List<AttachmentDto> getDetailAttachmentList(String subID){
		List<AttachmentDto> attachmentDtoList=actionRecordDao.queryAttachmentPojoById(subID);
		for (int i=0;i<attachmentDtoList.size();i++) {
			AttachmentDto dto = attachmentDtoList.get(i);
			String url=GlobalContants.P_CRM_DOWNLOAD_ABSOLUTEPATH+dto.getStoragePath()+GlobalContants.P_OPERATE_SIGN +dto.getStorageName()+GlobalContants.P_OPERATE_POINT+dto.getExtensions();
			System.out.println(url);
			dto.setUrl(url);
		}
		return attachmentDtoList;
	}
	 
	     /**
		 * 上传成功自动刷新图片路径通过接口
	     */
	 public List<AttachmentDto> getDetailAttachmentListFlash(int id){
		 String subID=actionRecordDao.queryRgidByRid(id);
			List<AttachmentDto> attachmentDtoList=actionRecordDao.queryAttachmentPojoById(subID);
			for (int i=0;i<attachmentDtoList.size();i++) {
				AttachmentDto dto = attachmentDtoList.get(i);
				String url=GlobalContants.P_CRM_DOWNLOAD_ABSOLUTEPATH+dto.getStoragePath()+GlobalContants.P_OPERATE_SIGN +dto.getStorageName()+GlobalContants.P_OPERATE_POINT+dto.getExtensions();
				System.out.println(url);
				dto.setUrl(url);
			}
			return attachmentDtoList;
		}
	
	   /**
	     * 保存附件主表
		 */
	public int saveAttachments(AttachmentBaseBean ttachmentBaseBean,String id){
		AttachmentPojo attachmentPojo=new AttachmentPojo();
		attachmentPojo.setAttaType(0);
		attachmentPojo.setSubScriberType("actionRecord");
		attachmentPojo.setSubScriberID(id);
		//attachmentPojo.setGroup("");
		attachmentPojo.setPrimitiveName(ttachmentBaseBean.getPrimitiveName());
		attachmentPojo.setStorageName(ttachmentBaseBean.getStorageName());
		attachmentPojo.setStoragePath(ttachmentBaseBean.getStoragePath());
		attachmentPojo.setAlgorithm(ttachmentBaseBean.getAlgorithm());
		attachmentPojo.setBytes(ttachmentBaseBean.getBytes());
		attachmentPojo.setCheckNo(ttachmentBaseBean.getCheckNo());
		attachmentPojo.setCreateTime(ttachmentBaseBean.getCreateTime());
		attachmentPojo.setExtensions(ttachmentBaseBean.getExtensions());
		attachmentPojo.setDeleted(0);
		attachmentPojo.setGID(ttachmentBaseBean.getGID());
		int a=actionRecordDao.saveAttachments(attachmentPojo);
	     return a;
	}
	
	/**
     * 保存附件主表附MediaAttachs
	 */
	public int saveMediaAttachs(MediaAttachsBaseBean mAttachMentBean){
		MediaAttachsPojo mediaAttachsPojo=new MediaAttachsPojo();
		mediaAttachsPojo.setHeight(mAttachMentBean.getHeight());
		mediaAttachsPojo.setCreateTime(mAttachMentBean.getCreateTime());
		mediaAttachsPojo.setWidth(mAttachMentBean.getWidth());
		mediaAttachsPojo.setGID(mAttachMentBean.getGID());
		int b=actionRecordDao.saveMediaAttachs(mediaAttachsPojo);
		return b;
	}
	/**
     * 保存附件主表附StreamAttachs
	 */
     public int saveStreamAttachs(StreamAttachsBaseBean streamAttachsBaseBean){
    	  StreamAttachsPojo streamAttachsPojo=new StreamAttachsPojo();
    	  streamAttachsPojo.setEncoder(streamAttachsBaseBean.getEncoder());
    	  streamAttachsPojo.setFrames(streamAttachsBaseBean.getFrames());
    	  streamAttachsPojo.setGID(streamAttachsBaseBean.getGID());
    	  int c=actionRecordDao.saveStreamAttachs(streamAttachsPojo);
    	 return c;
     }
     /**
      * 保存行动记录
     * @throws Exception 
 	 */
     public ActionRecordPojo updateRecord(ActionRecordDto actionrecord,UserPojo userPojo) throws Exception{
 		ActionRecordPojo actionRecordPojo=new ActionRecordPojo();
 		actionRecordPojo.setOwners(actionrecord.getOwer());
 		actionRecordPojo.setRcpCid(actionrecord.getRcpCid());
 		actionRecordPojo.setRecepter(actionrecord.getRecepter());
 		actionRecordPojo.setRcptPhone(actionrecord.getRcptPhone());
 		actionRecordPojo.setRcptTitle(actionrecord.getRcptTitle());
 		actionRecordPojo.setBeginTime(DateUtil.jsonDate2Date(actionrecord.getBeginTime()));
 		actionRecordPojo.setEndTime(DateUtil.jsonDate2Date(actionrecord.getEndTime()));
 		actionRecordPojo.setContent(actionrecord.getContent());
 		actionRecordPojo.setMethod(actionrecord.getMethod());
 		actionRecordPojo.setResults(actionrecord.getResults());
 		actionRecordPojo.setDesription(actionrecord.getDesription());
 		actionRecordPojo.setCsID(userPojo.getGID());
 		actionRecordPojo.setID(actionrecord.getId());
 		System.out.println(actionRecordPojo.getGID());
 		logger.info("---保存图片开始---"+actionRecordPojo.getGID());
 		int a=actionRecordDao.updateActionRecord(actionRecordPojo);
 		System.out.println(actionRecordPojo.getID());
 		//根据行动记录id查询gid
 		String id=actionRecordDao.queryRgidByRid(actionrecord.getId());
 		AddressPojo addressPojo=new AddressPojo();
 		addressPojo.setSubscriberID(id);
 		addressPojo.setAddress(actionrecord.getAddress());
 		int b=actionRecordDao.updateAddress(addressPojo);
 		commonTracesService.saveTraces("T_CRM_ServiceNotes",actionRecordPojo.getGID(), "actionrecord", "actionRecordPojo", "1",userPojo); //记录日志的方法
 		return actionRecordPojo;
     }
     
     /**
      * 修改新增行动记录
     * @throws Exception 
 	 */
     public String saveRecord(ActionRecordDto actionrecord,UserPojo userPojo) throws Exception{
 		ActionRecordPojo actionRecordPojo=new ActionRecordPojo();
 		actionRecordPojo.setOwners(actionrecord.getOwer());
 		actionRecordPojo.setRcpCid(actionrecord.getRcpCid());
 		actionRecordPojo.setRecepter(actionrecord.getRecepter());
 		actionRecordPojo.setRcptPhone(actionrecord.getRcptPhone());
 		actionRecordPojo.setRcptTitle(actionrecord.getRcptTitle());
 		actionRecordPojo.setBeginTime(DateUtil.jsonDate2Date(actionrecord.getBeginTime()));
 		actionRecordPojo.setEndTime(DateUtil.jsonDate2Date(actionrecord.getEndTime()));
 		actionRecordPojo.setContent(actionrecord.getContent());
 		actionRecordPojo.setMethod(actionrecord.getMethod());
 		actionRecordPojo.setCsName(actionrecord.getCsName());
 		actionRecordPojo.setResults(actionrecord.getResults());
 		actionRecordPojo.setDesription(actionrecord.getDesription());
 		actionRecordPojo.setDeleted(0);
 		actionRecordPojo.setCsID(userPojo.getGID());
 		actionRecordPojo.setCreateTime(new Date());
 		AddressPojo addressPojo=new AddressPojo();
 		addressPojo.setOwner(userPojo.getGID());
 		addressPojo.setSubscriberType("T_CRM_ServiceNotes");
 		addressPojo.setSubscriberID(actionRecordPojo.getGID());
 		addressPojo.setName("详细");
 		addressPojo.setAddress(actionrecord.getAddress());
 		addressPojo.setCreateTime(new Date());
 		addressPojo.setDeleted(false);
 		int a=actionRecordDao.saveActionRecords(actionRecordPojo);
 		int b=actionRecordDao.saveAddress(addressPojo);
 		commonTracesService.saveTraces("T_CRM_ServiceNotes", actionRecordPojo.getGID(), "", "", "0",userPojo); //记录日志的方法
 		if(a==1){
 			return actionRecordPojo.getGID();
 		}
 		return "";
     }
     /**
      * 得到现在时间
      * 
      * @return 字符串 yyyyMMdd HHmmss
      */
   public static String getStringToday() {
      Date currentTime = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
      String dateString = formatter.format(currentTime);
      return dateString;
   }
   /*
    * 张鹏
    *     * @see com.jg2b.api.crm.actionRecord.service.IActionRecordService#queryCustomer()
    */
	@Override
	public List<CustomerPojo> queryCustomer(int owner) {
		List<CustomerPojo> CustomerPojoList= actionRecordDao.queryCustomer(owner);
		if(CustomerPojoList!=null){
			return CustomerPojoList;
		}
		return null;
	}
	
	/**
     * 客户详情页面跳转到新增行动记录页面
	 */
	@Override
	public ActionRecordDoman jumpAddActionJspByCusDetailId(int id) {
		return actionRecordDao.jumpAddActionJspByCusDetailId(id);
	}
	/**
     * 本地图片上传方法
	 */
	@Override
	public void saveImages(int id, HttpServletRequest request,String name) {
		String gid=actionRecordDao.queryRgidByRid(id);
		String dateString=getStringToday();
		String relativePath=dateString+GlobalContants.P_OPERATE_SIGN+"actionrecord"+GlobalContants.P_OPERATE_SIGN+name;
		saveImage( gid,request,relativePath);	
	}
	public void saveImage(String gid,HttpServletRequest request,String relativePath){
		FileUploadUtil fileUploadUtil=new FileUploadUtil(relativePath, request);
		List<UploadCommonBean> uploadList=fileUploadUtil.UploadFile();
		for (UploadCommonBean uploadCommonBean : uploadList) {
			//获去文件信息
			AttachmentBaseBean ttachmentBaseBean=uploadCommonBean.getAttachMentBean();
			MediaAttachsBaseBean mAttachMentBean=uploadCommonBean.getmAttachMentBean();
			StreamAttachsBaseBean streamAttachsBaseBean=uploadCommonBean.getsAttachMentBean();
			//保存附件信息
			if(ttachmentBaseBean!=null){
			saveAttachments(ttachmentBaseBean,gid);
			logger.info("---保存Attachment结束---"+ttachmentBaseBean.getID());}
			if(mAttachMentBean!=null){
			//保存附件信息长宽高
			saveMediaAttachs( mAttachMentBean);
			logger.info("---保存MediaAttachs结束---"+ttachmentBaseBean.getID());}
			if(streamAttachsBaseBean!=null){
			saveStreamAttachs(streamAttachsBaseBean);
			logger.info("---保存StreamAttachs结束---"+ttachmentBaseBean.getID());	}
		}
		logger.info("---保存行动结束---");	
		
		
	}
	/**
     * 批量删除图片
	 */
	@Override
	public int deleAttachmentByAcgid(int id) {
		String subID=actionRecordDao.queryRgidByRid(id);
		int a=actionRecordDao.updateAttachment(subID);
		return  a;
	}
	
	/**
     * 单张删除图片
	 */
	@Override
	public int deleteAttachment(int attId) {
		int a =actionRecordDao.deleteAttachment(attId);
		if(a==1){
			return a;	
		}
		return 0;
	}

}
