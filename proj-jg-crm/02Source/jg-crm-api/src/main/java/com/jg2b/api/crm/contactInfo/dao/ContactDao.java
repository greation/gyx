package com.jg2b.api.crm.contactInfo.dao;

import java.util.List;

import com.jg2b.api.crm.contactInfo.dto.ContactDto;
import com.jg2b.api.crm.contactInfo.dto.TraceDto;
import com.jg2b.api.crm.contactInfo.pojo.ContactPojo;
import com.jg2b.common.pojo.AttachmentPojo;

public interface ContactDao {
	/**
	 * 
	 * <p>
	 * 添加联系人
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:36:11
	 * @param contactsdto
	 * @return
	 */
	public void insertContacts(ContactDto contactsdto);

	/**
	 * 
	 * <p>
	 * 修改联系人
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:37:12
	 * @param contactsdto
	 * @return
	 */
	public void updateContacts(ContactDto contactsdto);

	public String searchCustByName(ContactDto contactsdto);

	public String searchContByName(ContactPojo contactspojo);

	/**
	 * 
	 * <p>
	 * 验证联系人手机号码
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:42:50
	 * @param contactsdto
	 * @return List<ContactDto>
	 */
	public List<ContactDto> checkContacts(ContactDto contactsdto);

	/**
	 * 
	 * <p>
	 * 查询所有客服
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:42:23
	 * @param dto
	 * @return List<String>
	 */
	public List<String> searchCustAll(ContactDto dto);

	/**
	 * 
	 * <p>
	 * 添加联系人地址
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:41:27
	 * @param
	 * @return
	 */
	public void insertConAddress(ContactDto contactsdto);

	public List<ContactDto> searchContsByID(ContactDto contactsdto);

	public List<String> findConNoName(ContactDto contactsdto);

	/**
	 * 
	 * <p>
	 * 修改联系人地址
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:40:43
	 * @param contactsdto
	 * @return ContactDto
	 */
	public void updateAddress(ContactDto contactsdto);

	public ContactDto searchContactAllByID(String id);

	/**
	 * 
	 * <p>
	 * 保存附件
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:40:31
	 * @param attachmentPojo
	 * @return int
	 */
	public int saveAttachments(AttachmentPojo attachmentPojo);

	/**
	 * 
	 * <p>
	 * 根据客服ID 查询客服所拥有的客服姓名
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:39:59
	 * @param dto
	 * @return List<ContactDto>
	 */
	public List<ContactDto> search_CustByID(ContactDto dto);

	/**
	 * 
	 * <p>
	 * 根据联系人ID 查询联系人历史记录
	 * </p>
	 * 
	 * @author 作者：yuanshuai
	 * @date 2016年5月17日 下午2:38:23
	 * @param dto
	 * @return List<TraceDto>
	 */
	public List<TraceDto> searchPast(ContactDto dto);

	public void deleteContace(Integer contId);

}
