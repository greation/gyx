package com.jg2b.api.crm.customerManage.dao;

import java.util.List;

import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.common.pojo.AttachmentPojo;

public interface ActionRecordDao {

	List<AttachmentDto> queryAttachmentPojoById(String subID);

	void deleteCustInfo(Integer custId);

	int saveAttachments(AttachmentPojo attachmentPojo);

	void updateAttachment(String subID);

}
