package com.jg2b.web.crm.customerAssignment.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jg2b.api.crm.customerAssignment.dao.ICustomerAssignmentDao;
import com.jg2b.api.crm.customerAssignment.service.ICustomerAssignmentService;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.pojo.CustomerPojo;
import com.jg2b.api.crm.traces.service.ICommonTracesService;

@Service("customerAssignmentService")
public class CustomerAssignmentServiceImpl implements
		ICustomerAssignmentService {

	@Autowired
	private ICustomerAssignmentDao customerAssignmentDao;
	
	@Autowired
	private ICommonTracesService commonTracesService;

	@Override
	@Transactional
	public String CustCheck(String custid, String type,String uid,UserPojo user) throws Exception {
		if (type == null || type.equals("")) {
			return null;
		}
		CustomerPojo oldCust = customerAssignmentDao.findCustById(custid); //获得旧的数据信息-记日志使用
		if (type.equals("in")) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("custid", custid);
			if(!"".equals(uid)&&uid!=null){
				map.put("ownerid", uid);
			}else{
				map.put("ownerid", user.getGID());
			}
			customerAssignmentDao.CustCheckIn(map);
			CustomerPojo nowCust = customerAssignmentDao.findCustById(custid); //获得更新后的数据信息-记日志使用
			commonTracesService.saveTraces("T_CRM_Customers", custid, oldCust, nowCust, "1",user); //记录日志的方法
			return "success";
		}
		if (type.equals("out")) {
			customerAssignmentDao.CustCheckOut(custid);
			CustomerPojo nowCust = customerAssignmentDao.findCustById(custid);//获得更新后的数据信息-记日志使用
			commonTracesService.saveTraces("T_CRM_Customers", custid, oldCust, nowCust, "1",user);//记录日志的方法
			return "success";
		}
		return null;
	}

}
