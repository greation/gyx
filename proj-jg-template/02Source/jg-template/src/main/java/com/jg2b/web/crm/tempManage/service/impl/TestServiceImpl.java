package com.jg2b.web.crm.tempManage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.api.crm.userManage.dao.TestDao;
import com.jg2b.api.crm.userManage.dto.UserDTO;
import com.jg2b.api.crm.userManage.pojo.TestPojo;
import com.jg2b.api.crm.userManage.service.ITestService;

@Service("testService")  
public class TestServiceImpl implements ITestService{
	
    private TestDao testDao;
    
    @Autowired
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
    
    public List<TestPojo> searchList(){
    	return testDao.searchList();
	}

	public int delUserInfo(UserDTO user) {
		return 0;
	}
	
	
}
