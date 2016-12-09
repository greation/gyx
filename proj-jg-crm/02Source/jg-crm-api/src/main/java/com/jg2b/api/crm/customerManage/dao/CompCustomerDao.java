package com.jg2b.api.crm.customerManage.dao;

import com.jg2b.api.crm.customerManage.pojo.CompCustomersPojo;

public interface CompCustomerDao {

	void insertCompCustomers(CompCustomersPojo compCustomers);

	void updateCompCustomers(CompCustomersPojo compCustomers);

	void queryCompCustomerInfo(CompCustomersPojo comp);

}
