package com.jg2b.api.crm.userManage.service;

import java.util.List;

import com.jg2b.api.crm.userManage.dto.UserDTO;
import com.jg2b.api.crm.userManage.pojo.TestPojo;

public interface ITestService {
	
	List<TestPojo> searchList();
	
	int delUserInfo(UserDTO user);

}
