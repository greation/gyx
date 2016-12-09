package com.jg2b.web.crm.contactsManage.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jg2b.api.crm.contactInfo.dao.ContactDao;
import com.jg2b.api.crm.contactInfo.dto.ContactDto;
import com.jg2b.api.crm.contactInfo.dto.TraceDto;
import com.jg2b.api.crm.contactInfo.service.IContactService;
import com.jg2b.api.crm.contants.CrmCommCtants;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.traces.service.ICommonTracesService;
import com.jg2b.common.baseBean.AttachmentBaseBean;
import com.jg2b.common.pojo.AttachmentPojo;

@Service("contactservice")
public class ContactServiceImpl implements IContactService {
	@Autowired
	private ContactDao contactDao;

	@Autowired
	private ICommonTracesService commonTracesService;

	/**
	 * 添加联系人
	 * 
	 */
	@Transactional
	public int insertContacts(ContactDto contactsdto,
			HttpServletRequest request, UserPojo userpojo) {
		try {
			commonTracesService.saveTraces("T_CRM_Contacts",
					contactsdto.getGID(), null, null, "0", userpojo);
			contactsdto.setAddowner(String.valueOf(contactsdto.getGID()));
			contactsdto.setSubscriberID(String.valueOf(contactsdto.getGID()));
			contactsdto
					.setSubscriberType(CrmCommCtants.COMM_SUBSCRIBERTYPE.COMM_CONTACTS_SUBTYPE
							.getCode());
			contactsdto.setOwner(contactDao.searchCustByName(contactsdto));
			contactDao.insertContacts(contactsdto);
			contactsdto.setAddowner(String.valueOf(contactsdto.getGID()));
			contactDao.insertConAddress(contactsdto);
			/*
			 * //上传图片 String
			 * relativePath=getDate()+GlobalContants.P_OPERATE_SIGN
			 * +"contacts"+GlobalContants.P_OPERATE_SIGN+userpojo.getName();
			 * FileUploadUtil fileUploadUtil=new FileUploadUtil(relativePath,
			 * request); List<UploadCommonBean>
			 * uploadList=fileUploadUtil.UploadFile(); for(UploadCommonBean
			 * bean:uploadList){ //获去文件信息 AttachmentBaseBean
			 * ttachmentBaseBean=bean.getAttachMentBean(); MediaAttachsBaseBean
			 * mAttachMentBean=bean.getmAttachMentBean(); StreamAttachsBaseBean
			 * streamAttachsBaseBean=bean.getsAttachMentBean();
			 * ttachmentBaseBean.setGID(contactsdto.getGID());
			 * saveAttachments(ttachmentBaseBean); //录入图片 }
			 */
			return RESULT_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RESULT_ERROR;
	}

	/**
	 * 保存附件主表
	 */
	public void saveAttachments(AttachmentBaseBean ttachmentBaseBean) {
		AttachmentPojo attachmentPojo = new AttachmentPojo();
		attachmentPojo.setAttaType(0);
		attachmentPojo.setSubScriberType("T_CRM_Contacts");
		attachmentPojo
				.setSubScriberID(String.valueOf(ttachmentBaseBean.getID()));
		// attachmentPojo.setGroup("");
		attachmentPojo.setPrimitiveName(ttachmentBaseBean.getPrimitiveName());
		attachmentPojo.setStorageName(ttachmentBaseBean.getStorageName());
		attachmentPojo.setStoragePath(ttachmentBaseBean.getStoragePath());
		attachmentPojo.setAlgorithm(ttachmentBaseBean.getAlgorithm());
		attachmentPojo.setBytes(ttachmentBaseBean.getBytes());
		attachmentPojo.setCheckNo(ttachmentBaseBean.getCheckNo());
		attachmentPojo.setCreateTime(ttachmentBaseBean.getCreateTime());
		attachmentPojo.setExtensions(ttachmentBaseBean.getExtensions());
		contactDao.saveAttachments(attachmentPojo);

	}

	/**
	 * 修改联系人
	 */
	@Transactional
	public int updateContacts(ContactDto contactsdto, UserPojo userpojo) {
		try {

			// contactsdto.setID(contactsdto.getAddowner());
			ContactDto dto = contactDao.searchContactAllByID(contactsdto
					.getyID());
			dto.setyID(contactsdto.getyID());
			contactsdto.setOwner(contactDao.searchCustByName(contactsdto));
			contactDao.updateContacts(contactsdto);
			contactsdto.setID(Integer.valueOf(contactsdto.getyID()));
			commonTracesService.saveTraces("T_CRM_Contacts", contactsdto.GID,
					dto, contactsdto, "1", userpojo);
			contactDao.updateAddress(contactsdto);
			return RESULT_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RESULT_ERROR;
	}

	/**
	 * 联系人查重 error:重复 success:不重复
	 */
	@Transactional
	public List<ContactDto> checkContacts(ContactDto contactsdto) {
		return contactDao.checkContacts(contactsdto);

	}

	/**
	 * 查询客户姓名
	 */
	@Transactional
	public List<String> searchCustAll(ContactDto dto) {

		return contactDao.searchCustAll(dto);
	}

	/**
	 * 通过ID查询联系人
	 */
	@Transactional
	public List<ContactDto> searchContsByID(ContactDto contactsdto) {
		return contactDao.searchContsByID(contactsdto);
	}

	public String getDate() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(d);
		return dateString;
	}

	@Override
	public List<ContactDto> search_CustByID(ContactDto dto) {
		return contactDao.search_CustByID(dto);
	}

	/**
	 * 历史记录
	 */
	@Override
	public List<TraceDto> searchPast(ContactDto dto) {
		List<TraceDto> list = contactDao.searchPast(dto);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().length() != 0) {
				String[] stNum = list.get(i).getText().split("。");
				StringBuffer sb = new StringBuffer("");
				String[] strField = stNum[0].split(",");// 字段值
				String[] strText = stNum[1].split(",");// 属性值
				for (int j = 0; j < stNum.length - 1; j++) {
					for (int k = 0; k < strField.length; k++) {
						if (strField[k].equals("name")) {
							sb.append("姓名:" + strText[k] + "<br>");
						}
						if (strField[k].equals("email")) {
							sb.append("邮箱:" + strText[k] + "<br>");
						}
						if (strField[k].equals("title")) {
							sb.append("称呼:" + strText[k] + "<br>");
						}
						if (strField[k].equals("position")) {
							sb.append("职位:" + strText[k] + "<br>");
						}
						if (strField[k].equals("telphone")) {
							sb.append("联系方式:" + strText[k] + "<br>");
						}
						if (strField[k].equals("description")) {
							sb.append("描述:" + strText[k] + "<br>");
						}
						if (strField[k].equals("gender")) {
							String[] genText = strText[k].split("-->");
							String str = null;
							if (genText[0] == "0") {
								str = "男-->女";
							} else {
								str = "女-->男";
							}
							sb.append("性别:" + str + "<br>");
						}
						if (strField[k].equals("address")) {
							sb.append("详细地址:" + strText[k] + "<br>");
						}
					}
					System.out.println("输出第：" + j + "次");
					//
				}

				list.get(i).setText(sb.toString());

			}
		}
		return list;
	}

	@Transactional
	public int deleteContact(Integer contId) {
		this.contactDao.deleteContace(contId);
		return RESULT_SUCCESS;
	}
}
