package com.jg2b.api.crm.customerManage.dao;

import java.util.List;

import com.jg2b.api.crm.customerManage.bean.CustomerInformationBean;
import com.jg2b.api.crm.customerManage.pojo.CustomerPojo;

public interface CustomerDao {

	void insertCustomers(CustomerPojo customer);

	void updateCustomers(CustomerPojo customer);

	Object queryCreatCustomerNumber();

	int queryCustomerName(String name);

	List<CustomerInformationBean> querCustomerInfo(Integer custId);

	String queryCustGid(Integer custId);

}
