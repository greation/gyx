package com.jg2b.api.crm.customerManage.dao;

import java.util.List;

import com.jg2b.api.crm.customerManage.pojo.ContactsPojo;

public interface ContactsDao {

	void insertContacts(ContactsPojo contacts);

	void updateContacts(ContactsPojo contacts);

	List<ContactsPojo> queryContactsInfo(ContactsPojo cont);

}
