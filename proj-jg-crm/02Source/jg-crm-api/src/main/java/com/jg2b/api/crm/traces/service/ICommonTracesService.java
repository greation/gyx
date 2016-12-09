package com.jg2b.api.crm.traces.service;

import com.jg2b.api.crm.login.pojo.UserPojo;


public interface ICommonTracesService {
	
	/** 
	 * @author  作者：zhangyaotang
	 * @date 创建时间：2016年5月11日 上午10:10:02 
	 * @version 1.0 
	 * @param tabeName 表名
	 * @param dataId 数据的ID
	 * @param old 旧数据(新增or删除时设置null)
	 * @param now 新数据(新增or删除时设置null)
	 * @param operation 操作类型0：新增，1：修改，2：删除
	 * @throws Exception
	 */
	<T> void saveTraces(String tabeName,String dataId, T old, T now,String operation,UserPojo user) throws Exception;
}
