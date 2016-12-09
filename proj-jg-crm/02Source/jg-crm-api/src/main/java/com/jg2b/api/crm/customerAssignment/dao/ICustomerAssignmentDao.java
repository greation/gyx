package com.jg2b.api.crm.customerAssignment.dao;

import java.util.Map;

import com.jg2b.api.crm.queryCustInfo.pojo.CustomerPojo;


public interface ICustomerAssignmentDao {
	void CustCheckIn(Map<String,String> map);
	void CustCheckOut(String custid);
	CustomerPojo findCustById(String id);
}
