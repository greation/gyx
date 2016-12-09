package com.jg2b.api.crm.customerAssignment.service;

import com.jg2b.api.crm.login.pojo.UserPojo;

public interface ICustomerAssignmentService {
	String CustCheck(String custid,String type,String uid,UserPojo user) throws Exception;
}
