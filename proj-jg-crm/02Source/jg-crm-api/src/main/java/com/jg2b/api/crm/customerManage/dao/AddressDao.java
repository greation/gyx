package com.jg2b.api.crm.customerManage.dao;

import java.util.List;

import com.jg2b.api.crm.customerManage.pojo.AddressPojo;

public interface AddressDao {

	void insertAdress(List<AddressPojo> addressList);

	void updateAdress(List<AddressPojo> addsList);

	List<AddressPojo> queryAddressInfo(AddressPojo address);

	int updateAddressType(AddressPojo add);

}
