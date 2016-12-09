package com.jg2b.api.crm.customerManage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.customerManage.pojo.CustomerPojo;
import com.jg2b.api.crm.customerManage.vo.CustomerVO;
import com.jg2b.api.crm.login.pojo.UserPojo;

public interface ICustomerService {
	static final int SUCCESS = 1;

	int updateCustomers(CustomerVO vo, HttpServletRequest request,
			UserPojo userpojo) throws Exception;

	CustomerPojo insertCustomers(String uGId, CustomerVO vo,
			HttpServletRequest request, UserPojo userpojo) throws Exception;

	int queryCustomerName(String name);

	Object queryCustomerInformation(Integer custId, Integer uId, String uGId);

	Object queryCodesAndIndustry();

	Object queryCodesAndCorpKind();

	Object queryCodeAndRegion();

	Object queryCodeAndChannel();

	Object queryCodesAndUser();

	Object queryCodeAndsource();

	void insertCustInfo(Integer custId, HttpServletRequest request,
			String userName);

	List<AttachmentDto> getDetailAttachmentList(Integer custId);

	int deleteCustInfo(Integer attId);

	void updateCustImgInfo(Integer custId);

}
