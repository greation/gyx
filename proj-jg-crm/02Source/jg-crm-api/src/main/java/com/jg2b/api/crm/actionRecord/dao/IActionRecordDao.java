package com.jg2b.api.crm.actionRecord.dao;

import java.util.List;

import com.jg2b.api.crm.actionRecord.doman.ActionRecordDoman;
import com.jg2b.api.crm.actionRecord.dto.ActionRecordDto;
import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.actionRecord.pojo.ActionRecordPojo;
import com.jg2b.api.crm.actionRecord.pojo.ContactsPojo;
import com.jg2b.api.crm.actionRecord.pojo.CustomerPojo;
import com.jg2b.api.crm.contactInfo.pojo.AddressPojo;
import com.jg2b.common.pojo.AttachmentPojo;
import com.jg2b.common.pojo.MediaAttachsPojo;
import com.jg2b.common.pojo.StreamAttachsPojo;

public interface IActionRecordDao {
	
	/**
	 * 根据用户查询行动记录
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 */
	List<ActionRecordPojo> queryActionByCsname(String csName);
	
	/**
	 * 根据行动记录id查询行动记录
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 */
	ActionRecordPojo queryActionById(String csName);
	
	/**
	 * 根据公司名称时间段查询当前公司行动记录
	 * @author JG.Developer 张鹏
	 * @param <ActionRecordDto>
 	 * @param Id
	 * List<UserFollowDto>
	 */
	List<ActionRecordDto> queryActionByOwnerAndTime(ActionRecordDto actionrecord);
	
	/**
	 * 
	 * <p> 保存行动记录</p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com 
	 * @date: Created on 2016年4月25日 上午10:35:24
	 */
    int saveActionRecords(ActionRecordPojo actionRecordPojo);
    
    /**
	 * 
	 * <p> 新增图片</p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com 
	 * @date: Created on 2016年4月25日 上午10:35:24
	 */
	 int saveAttachments(AttachmentPojo image);
	    /**
		 * 
		 * <p> 新增图片子附件</p>
		 * 
		 * @param userfollow
		 * @return
		 * @author: zhangpeng - zhangpeng@jg2b.com 
		 * @date: Created on 2016年4月25日 上午10:35:24
		 */
     int  saveMediaAttachs(MediaAttachsPojo mediaAttachsPojo);
     /**
		 * 
		 * <p> 新增图片子附件</p>
		 * 
		 * @param userfollow
		 * @return
		 * @author: zhangpeng - zhangpeng@jg2b.com 
		 * @date: Created on 2016年4月25日 上午10:35:24
		 */
     int  saveStreamAttachs(StreamAttachsPojo streamAttachsPojo);
	 
    /**
	 * 
	 * <p> 判断当前客户名称是否存在</p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com 
	 * @date: Created on 2016年4月25日 上午10:35:24
	 */
	 CustomerPojo isCustomer(String cusName);
    
    /**
	 * 
	 * <p> 通过公司名称查询共公司名下联系人</p>
	 * 
	 * @param userfollow
	 * @return
	 * @author: zhangpeng - zhangpeng@jg2b.com 
	 * @date: Created on 2016年4月25日 上午10:35:24
	 */
    List<ContactsPojo> queryContactsByCusname(String cusName);

    /**
	   * 
	   * <p>通过公司名称联系人名称获取电话与联系人id</p>
	   * 
	   * @param userfollow
	   * @return
	   * @author: zhangpeng - zhangpeng@jg2b.com 
	   * @date: Created on 2016年4月25日 上午10:34:32
	   */
    ActionRecordPojo queryPhoneNoByCusNameandTname(int cusId,String tName);
	
	 /**
	  * 
	  * <p>删除行动记录</p>
	  * 
	  * @param Id
	  * @return
	  * @author: zhangpeng - zhangpeng@jg2b.com 
	  * @date: Created on 2016年4月25日 上午10:34:24
	  */
	 int deleActionRecord(String id);
	  
       /**
	   * 
	   * <p>根据图片id删除图片</p>
	   * 
	   * @param userfollow
	   * @return
	   * @author: zhangpeng - zhangpeng@jg2b.com 
	   * @date: Created on 2016年4月25日 上午10:34:32
	   */
	  int  deleImage(String id);
	  /**
	   * 
	   * <p>根据图片id删除图片</p>
	   * 
	   * @param userfollow
	   * @return
	   * @author: zhangpeng - zhangpeng@jg2b.com 
	   * @date: Created on 2016年4月25日 上午10:34:32
	   */
	  int updateActionRecord(ActionRecordPojo actionRecordPojo);
	  /**
	   * 
	   * <p>根据客户名称查询所属于联系人集合</p>
	   * 
	   * @param userfollow
	   * @return
	   * @author: zhangpeng - zhangpeng@jg2b.com 
	   * @date: Created on 2016年4月25日 上午10:34:32
	   */
	  List<ActionRecordPojo> queryContactsListByOwer(int cusName);
	  /**
	   * 
	   * <p>查询行动记录详情</p>
	   * 
	   * @param userfollow
	   * @return
	   * @author: zhangpeng - zhangpeng@jg2b.com 
	   * @date: Created on 2016年4月25日 上午10:34:32
	   */
	  ActionRecordDoman queryActionRecodDetail(int id);
	  /**
		  * 
		  * <p>根据订阅者id（行动记录id）查询图片</p>
		  * 
		  * @param Id
		  * @return
		  * @author: zhangpeng - zhangpeng@jg2b.com 
		  * @date: Created on 2016年4月25日 上午10:34:24
		  */
	  List<AttachmentDto> queryAttachmentPojoById(String id);
	  /**
		  * 
		  * <p>根据id查询所属客户</p>
		  * 
		  * @param Id
		  * @return
		  * @author: zhangpeng - zhangpeng@jg2b.com 
		  * @date: Created on 2016年4月25日 上午10:34:24
		  */
	  List<CustomerPojo> queryCustomer(int owner);
	  
	  /**
	   * <p>修改客户活跃度</p>
	   * 
	   * @param active
	   * @param custID
	   * @return
	   * @author: 林雨竹 - linyuzhu@jg2b.com 
	   * @date: Created on 2016年5月12日 上午10:08:00
	   */
	  int updateCustomerActive(int active,int custID);
	  /**
	   * <p>修改客户活跃度</p>
	   * 
	   * @param active
	   * @param custID
	   * @return
	   * @author: 林雨竹 - linyuzhu@jg2b.com 
	   * @date: Created on 2016年5月12日 上午10:08:00
	   */
	  int saveAddress(AddressPojo addressPojo);
	  /**
	   * <p>根据客户id查询客GID</p>
	   * 
	   * @param active
	   * @param custID
	   * @return
	   * @author: 林雨竹 - linyuzhu@jg2b.com 
	   * @date: Created on 2016年5月12日 上午10:08:00
	   */
	  String queryGidbyCusid(int id);
	  
	  /**
	   * <p>客户详情页面跳转到新增行动记录页面</p>
	   * 
	   * @param active
	   * @param custID
	   * @return
	   * @author: zhagnpeng - linyuzhu@jg2b.com 
	   * @date: Created on 2016年5月12日 上午10:08:00
	   */
	  
	  ActionRecordDoman jumpAddActionJspByCusDetailId(int id);
	  
	  /**
	   * <p>根据附件id更新地址信息</p>
	   * 
	   * @param active
	   * @param custID
	   * @return
	   * @author: zhagnpeng - linyuzhu@jg2b.com 
	   * @date: Created on 2016年5月12日 上午10:08:00
	   */
	   int updateAddress(AddressPojo addressPojo);
	   
	   /**
		   * 根据行动记录id查询gid --></p>
		   * 
		   * @param active
		   * @param custID
		   * @return
		   * @author: zhagnpeng - linyuzhu@jg2b.com 
		   * @date: Created on 2016年5月12日 上午10:08:00
		   */
	   String  queryRgidByRid(int id);
	   
	   /**
		   * 根据行动记录id查询gid --></p>
		   * 
		   * @param active
		   * @param custID
		   * @return
		   * @author: zhagnpeng - linyuzhu@jg2b.com 
		   * @date: Created on 2016年5月12日 上午10:08:00
		   */
	   int updateAttachment(String subID);
	       /**
		   * 根据图片id逻辑删除图片 --></p>
		   * 
		   * @param active
		   * @param custID
		   * @return
		   * @author: zhagnpeng - linyuzhu@jg2b.com 
		   * @date: Created on 2016年5月12日 上午10:08:00
		   */
	   
	   int  deleteAttachment(int attId);
	   
	 
	  
}
