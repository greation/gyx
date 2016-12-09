package com.jg2b.api.crm.customerManage.dao;

import java.util.List;

import com.jg2b.api.crm.customerManage.vo.TracesVO;

public interface TracesDao {

	List<TracesVO> queryTracesInfo(Integer custId);

	List<TracesVO> queryPrivateInfo(String userId);

	List<TracesVO> queryPublicTracesInfo(String userId);

	String queryUserNameByGID(String gid);

}
