package com.jg2b.api.crm.staffsOperation.service;

import java.util.List;

import com.jg2b.api.crm.staffsOperation.pojo.StaffsPojo;

public interface IStaffsOperationService {
	/** 
	 * 根据登陆用户ID查到下属员工信息
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 下午4:16:50 
	 * @version 1.0 
	 * @param userId 用户ID
	 * @return
	 */
	List<StaffsPojo> findUnderlingInfo(String userId,String name);
}
