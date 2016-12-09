package com.jg2b.api.crm.contactInfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jg2b.api.crm.contactInfo.dto.ContactDto;
import com.jg2b.api.crm.contactInfo.dto.TraceDto;
import com.jg2b.api.crm.login.pojo.UserPojo;

public interface IContactService {
	final Integer RESULT_SUCCESS = 1;
	final Integer RESULT_ERROR = 0;

	public int insertContacts(ContactDto contactsdto,
			HttpServletRequest request, UserPojo userpojo);

	public int updateContacts(ContactDto contactsdto, UserPojo userpojo);

	public List<ContactDto> checkContacts(ContactDto contactsdto);

	public List<String> searchCustAll(ContactDto dto);

	public List<ContactDto> searchContsByID(ContactDto contactsdto);

	public List<ContactDto> search_CustByID(ContactDto dto);

	public List<TraceDto> searchPast(ContactDto dto);

	public int deleteContact(Integer contId);
}
