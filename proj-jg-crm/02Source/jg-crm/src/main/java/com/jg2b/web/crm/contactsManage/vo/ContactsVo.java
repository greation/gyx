package com.jg2b.web.crm.contactsManage.vo;

import com.jg2b.api.crm.contactInfo.dto.ContactDto;

public class ContactsVo extends ContactDto{
	// private String name;
	
	private ContactDto contactsdto;

	/*
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public ContactDto getContactsdto() {
		return contactsdto;
	}

	public void setContactsdto(ContactDto contactsdto) {
		this.contactsdto = contactsdto;
	}
	
}
