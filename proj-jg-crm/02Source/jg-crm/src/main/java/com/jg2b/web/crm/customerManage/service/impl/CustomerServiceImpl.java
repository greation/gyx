package com.jg2b.web.crm.customerManage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jg2b.api.crm.actionRecord.dto.AttachmentDto;
import com.jg2b.api.crm.actionRecord.service.IActionRecordService;
import com.jg2b.api.crm.customerManage.bean.CustomerInformationBean;
import com.jg2b.api.crm.customerManage.dao.ActionRecordDao;
import com.jg2b.api.crm.customerManage.dao.AddressDao;
import com.jg2b.api.crm.customerManage.dao.CodeDao;
import com.jg2b.api.crm.customerManage.dao.CompCustomerDao;
import com.jg2b.api.crm.customerManage.dao.ContactsDao;
import com.jg2b.api.crm.customerManage.dao.CustomerDao;
import com.jg2b.api.crm.customerManage.dao.TracesDao;
import com.jg2b.api.crm.customerManage.pojo.AddressPojo;
import com.jg2b.api.crm.customerManage.pojo.CodesPojo;
import com.jg2b.api.crm.customerManage.pojo.CompCustomersPojo;
import com.jg2b.api.crm.customerManage.pojo.ContactsPojo;
import com.jg2b.api.crm.customerManage.pojo.CustomerPojo;
import com.jg2b.api.crm.customerManage.service.ICustomerService;
import com.jg2b.api.crm.customerManage.vo.CustomerVO;
import com.jg2b.api.crm.customerManage.vo.TracesVO;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.traces.service.ICommonTracesService;
import com.jg2b.common.baseBean.AttachmentBaseBean;
import com.jg2b.common.baseBean.MediaAttachsBaseBean;
import com.jg2b.common.baseBean.StreamAttachsBaseBean;
import com.jg2b.common.baseBean.UploadCommonBean;
import com.jg2b.common.contants.GlobalContants;
import com.jg2b.common.pojo.AttachmentPojo;
import com.jg2b.common.utils.FileUploadUtil;
import com.jg2b.common.utils.ObjectUtils;
import com.jg2b.web.crm.actionRecord.service.impl.ActionRecordServiceImpl;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	private ActionRecordDao actionRecordDao;

	@Autowired
	private ICommonTracesService commonTracesService;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CodeDao codesDao;

	@Autowired
	private TracesDao tracesDao;

	@Autowired
	private ContactsDao contactsDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private CompCustomerDao compCustomerDao;

	@Autowired
	private IActionRecordService actionRecordService;

	// UserPojo userpojo
	@Transactional
	public CustomerPojo insertCustomers(String uGId, CustomerVO vo,
			HttpServletRequest request, UserPojo userpojo) throws Exception {

		CustomerPojo cust = new CustomerPojo();
		cust = (CustomerPojo) ObjectUtils.copyObjProperties(vo, cust);
		cust.setChannel("01");
		cust.setCreater(uGId);
		cust.setOwner(uGId);
		this.customerDao.insertCustomers(cust);

		ContactsPojo cont = new ContactsPojo();
		cont.setOwner(cust.getGID());
		cont.setName(vo.getConname());
		cont.setTelphone(vo.getTelphone());
		cont.setGroup("0");
		this.contactsDao.insertContacts(cont);

		CompCustomersPojo comp = new CompCustomersPojo();
		comp.setGID(cust.getGID());
		comp = (CompCustomersPojo) ObjectUtils.copyObjProperties(vo, comp);
		this.compCustomerDao.insertCompCustomers(comp);

		if (vo.getAddressList() != null && vo.getAddressList().size() > 0) {
			List<AddressPojo> addsList = new ArrayList<AddressPojo>();
			for (int i = 0; i < vo.getAddressList().size(); i++) {
				AddressPojo address = new AddressPojo();
				String addGID = address.getGID();
				address = vo.getAddressList().get(i);
				// address = (AddressPojo) ObjectUtils.copyObjProperties(vo,
				// address);
				address.setRegion(vo.getRegion());
				address.setOwner(uGId);
				address.setSubscriberID(cust.getGID());
				address.setGID(addGID);
				address.setSubscriberType(GlobalContants.ENUM_SUBSCRIBERTYPE.COMM_CUSTOMER_SUBTYPE
						.getCode());
				addsList.add(address);
			}
			this.addressDao.insertAdress(addsList);

			commonTracesService.saveTraces("T_CRM_Customers", cust.getGID(),
					null, null, "0", userpojo);

		}
		return cust;
	}

	@Transactional
	public int updateCustomers(CustomerVO vo, HttpServletRequest request,
			UserPojo userpojo) throws Exception {
		/*
		 * commonTracesService.saveTraces("T_Common_Traces", vo.getCustID(),
		 * null, null, "0", userpojo);
		 */
		CustomerPojo cust = new CustomerPojo();
		cust = (CustomerPojo) ObjectUtils.copyObjProperties(vo, cust);
		cust.setID(vo.getCustID());
		this.customerDao.updateCustomers(cust);

		ContactsPojo cont = new ContactsPojo();
		cont.setName(vo.getConname());
		cont.setTelphone(vo.getTelphone());
		cont.setID(vo.getContID());
		this.contactsDao.updateContacts(cont);

		CompCustomersPojo comp = new CompCustomersPojo();
		comp.setLegal(vo.getLegal());
		comp.setCapital(vo.getCapital());
		comp.setCorpKind(vo.getCorpKind());
		comp.setIndustry(vo.getIndustry());
		comp.setID(vo.getCompID());
		this.compCustomerDao.updateCompCustomers(comp);

		if (vo.getAddressList() != null && vo.getAddressList().size() > 0) {
			List<AddressPojo> addsList = new ArrayList<AddressPojo>();

			for (int i = 0; i < vo.getAddressList().size(); i++) {

				AddressPojo address = vo.getAddressList().get(i);
				if (address.getAddress() != null
						&& !"".equals(address.getAddress())) {
					address.setRegion(vo.getRegion());
					addsList.add(address);
				}
			}
			if (addsList.size() > 0) {
				this.addressDao.updateAdress(addsList);
			}

		}
		return SUCCESS;
	}

	@Transactional
	public int queryCustomerName(String name) {
		return this.customerDao.queryCustomerName(name);
	}

	@Transactional
	public Map<String, Object> queryCustomerInformation(Integer custId,
			Integer uId, String uGId) {

		List<CustomerInformationBean> custBeanList = this.customerDao
				.querCustomerInfo(custId);
		// 客户的GID
		String custGID = custBeanList.get(0).getCustGID();

		ContactsPojo cont = new ContactsPojo();
		cont.setOwner(custGID);
		List<ContactsPojo> contList = this.contactsDao.queryContactsInfo(cont);

		CompCustomersPojo comp = new CompCustomersPojo();
		comp.setGID(custGID);
		this.compCustomerDao.queryCompCustomerInfo(comp);

		AddressPojo address = new AddressPojo();
		address.setSubscriberID(custGID);
		List<AddressPojo> addList = this.addressDao.queryAddressInfo(address);

		List<TracesVO> tracesList = this.tracesDao.queryTracesInfo(custId);// 查询历史记录

		// tracesDao.queryUserName();
		// -------------------
		for (int i = 0; i < tracesList.size(); i++) {
			if (tracesList.get(i).getText().length() != 0) {
				String[] stNum = tracesList.get(i).getText().split("。");
				StringBuffer sb = new StringBuffer("");
				String[] strText = stNum[1].split(",");// 属性值
				int count = 0;
				for (int j = 0; j < stNum.length - 1; j++) {
					for (int k = 0; k < strText.length; k++) {
						if (strText[k].equals("")) {

							count = 1;
						}
						if (!strText[k].equals("")) {
							if (count == 1) {
								sb.append("检入"
										+ tracesDao
												.queryUserNameByGID(strText[k])
										+ "的私海");
							} else {
								sb.append("检出"
										+ tracesDao
												.queryUserNameByGID(strText[k])
										+ "的私海");
							}

						}

					}

				}

				tracesList.get(i).setText(sb.toString());

			}
		}

		// ----------------------

		System.out.println(tracesList);

		if (custBeanList.size() > 0) {
			map.put("custBeanList", custBeanList.get(0));
		}
		map.put("contList", contList);
		map.put("addList", addList);
		map.put("tracesList", tracesList);
		return map;
	}

	@Transactional
	public List<CodesPojo> queryCodesAndIndustry() {
		return codesDao.queryCodesAndIndustry();
	}

	@Transactional
	public List<CodesPojo> queryCodesAndCorpKind() {
		return codesDao.queryCodesAndCorpKind();
	}

	@Transactional
	public Object queryCodeAndRegion() {
		List<CodesPojo> resList = codesDao.queryCodeAndRegion();

		// 用CODE为key存放地区信息
		Map<String, CodesPojo> codeMap = new HashMap<String, CodesPojo>();

		// 获取叶子节点的信息
		List<CodesPojo> leafList = new ArrayList<CodesPojo>();
		for (CodesPojo bean : resList) {
			boolean flag = true;
			for (CodesPojo bean1 : resList) {
				if (bean.getCode().equals(bean1.getParent())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				leafList.add(bean);
			}

			codeMap.put(bean.getCode(), bean);
		}

		for (int i = 0; i < leafList.size(); i++) {
			CodesPojo bean = leafList.get(i);
			getNodePath(bean, bean.getParent(), codeMap);
		}

		return leafList;
	}

	/**
	 * <p>
	 * 递归获取父节点信息
	 * </p>
	 * 
	 * @param bean
	 * @param parentCode
	 * @param codeMap
	 * @return
	 * @author: 林雨竹 - linyuzhu@jg2b.com
	 * @date: Created on 2016年5月12日 下午9:03:25
	 */

	public CodesPojo getNodePath(CodesPojo bean, String parentCode,
			Map<String, CodesPojo> codeMap) {
		if (codeMap.containsKey(parentCode)) {
			CodesPojo parentBean = codeMap.get(parentCode);
			bean.setCaption(parentBean.getCaption() + " " + bean.getCaption());
			getNodePath(bean, parentBean.getParent(), codeMap);
		} else {
			return bean;
		}

		return bean;

	}

	@Transactional
	public List<CodesPojo> queryCodeAndChannel() {
		return this.codesDao.queryCodeAndChannel();
	}

	@Transactional
	public List<UserPojo> queryCodesAndUser() {
		return this.codesDao.queryCodesAndUser();
	}

	/**
	 * 渠道来源
	 */
	@Transactional
	public Object queryCodeAndsource() {
		return this.codesDao.queryCodeAndsource();
	}

	@Transactional
	public void insertCustInfo(Integer custId, HttpServletRequest request,
			String userName) {
		// 客户的GID
		String custGID = this.customerDao.queryCustGid(custId);
		String dateString = ActionRecordServiceImpl.getStringToday();
		System.out.println(dateString);
		String relativePath = dateString + GlobalContants.P_OPERATE_SIGN
				+ "Customer" + GlobalContants.P_OPERATE_SIGN + userName;

		FileUploadUtil fileUploadUtil = new FileUploadUtil(relativePath,
				request);
		List<UploadCommonBean> uploadList = fileUploadUtil.UploadFile();
		for (UploadCommonBean uploadCommonBean : uploadList) {
			// 获去文件信息
			AttachmentBaseBean ttachmentBaseBean = uploadCommonBean
					.getAttachMentBean();
			MediaAttachsBaseBean mAttachMentBean = uploadCommonBean
					.getmAttachMentBean();
			StreamAttachsBaseBean streamAttachsBaseBean = uploadCommonBean
					.getsAttachMentBean();
			// 保存附件信息
			saveAttachments(ttachmentBaseBean, custGID);
			if (mAttachMentBean != null) {
				// 保存附件信息长宽高
				actionRecordService.saveMediaAttachs(mAttachMentBean);
			}
			if (streamAttachsBaseBean != null) {
				// 流文件
				actionRecordService.saveStreamAttachs(streamAttachsBaseBean);
			}
		}
	}

	/**
	 * 保存附件主表
	 */
	@Transactional
	public int saveAttachments(AttachmentBaseBean ttachmentBaseBean,
			String subID) {
		AttachmentPojo attachmentPojo = new AttachmentPojo();
		attachmentPojo.setGID(ttachmentBaseBean.getGID());
		attachmentPojo.setAttaType(0);
		attachmentPojo.setSubScriberType("T_CRM_Customers");
		attachmentPojo.setSubScriberID(subID);
		attachmentPojo.setGroup("");
		attachmentPojo.setPrimitiveName(ttachmentBaseBean.getPrimitiveName());
		attachmentPojo.setStorageName(ttachmentBaseBean.getStorageName());
		attachmentPojo.setStoragePath(ttachmentBaseBean.getStoragePath());
		attachmentPojo.setAlgorithm(ttachmentBaseBean.getAlgorithm());
		attachmentPojo.setBytes(ttachmentBaseBean.getBytes());
		attachmentPojo.setCheckNo(ttachmentBaseBean.getCheckNo());
		attachmentPojo.setCreateTime(ttachmentBaseBean.getCreateTime());
		attachmentPojo.setExtensions(ttachmentBaseBean.getExtensions());
		int a = actionRecordDao.saveAttachments(attachmentPojo);
		return a;
	}

	/**
	 * 返回图片路径通过接口
	 */
	@Transactional
	public List<AttachmentDto> getDetailAttachmentList(Integer custId) {
		String subID = this.customerDao.queryCustGid(custId);

		List<AttachmentDto> attachmentDtoList = actionRecordDao
				.queryAttachmentPojoById(subID);
		for (int i = 0; i < attachmentDtoList.size(); i++) {
			AttachmentDto dto = attachmentDtoList.get(i);
			String url = GlobalContants.P_CRM_DOWNLOAD_ABSOLUTEPATH
					+ dto.getStoragePath() + GlobalContants.P_OPERATE_SIGN
					+ dto.getStorageName() + GlobalContants.P_OPERATE_POINT
					+ dto.getExtensions();
			System.out.println(url);
			dto.setUrl(url);
		}
		return attachmentDtoList;
	}

	@Transactional
	public int deleteCustInfo(Integer attId) {
		this.actionRecordDao.deleteCustInfo(attId);
		return SUCCESS;
	}

	@Transactional
	public void updateCustImgInfo(Integer custId) {
		String subID = this.customerDao.queryCustGid(custId);
		this.actionRecordDao.updateAttachment(subID);

	}
}