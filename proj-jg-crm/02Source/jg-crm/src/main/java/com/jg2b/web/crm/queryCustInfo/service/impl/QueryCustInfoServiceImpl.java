package com.jg2b.web.crm.queryCustInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.queryCustInfo.dao.IQueryCustInfoDao;
import com.jg2b.api.crm.queryCustInfo.dto.FindActivitiesDTO;
import com.jg2b.api.crm.queryCustInfo.dto.QueryCustInfoDTO;
import com.jg2b.api.crm.queryCustInfo.dto.ServiceNotesDTO;
import com.jg2b.api.crm.queryCustInfo.service.IQueryCustInfoService;
import com.jg2b.common.utils.DateUtil;

@Service("customerManageService")
public class QueryCustInfoServiceImpl implements IQueryCustInfoService {

	@Autowired
	private IQueryCustInfoDao customerManageDao;

	public List<QueryCustInfoDTO> findCustomerInfo(QueryCustInfoDTO dto,
			UserPojo user) {
		List<QueryCustInfoDTO> custs = customerManageDao.findCustomerInfo(dto);
		return custs;
	}

	public Integer checkCustomerByName(String name) {
		return null;
	}

	public List<QueryCustInfoDTO> findContactInfo(QueryCustInfoDTO dto,
			UserPojo user) {
		if (user != null && user.getID() != null) {
			dto.setUserid(String.valueOf(user.getID()));
		} else {
			throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		}
		return customerManageDao.findContactInfo(dto);
	}

	@Override
	public List<FindActivitiesDTO> findActivities(QueryCustInfoDTO dto,
			UserPojo user) {
		if (user != null && !"".equals(user.getID()) && user.getID() != 0) {
			dto.setUserid(user.getGID());
		} else {
			throw new RuntimeException("当前无登陆用户,请登录后重新操作!");
		}
		dto.setUserid(user.getGID());
		System.out.println(user.getGID());
		List<ServiceNotesDTO> snts = customerManageDao.findActivities(dto);
		List<FindActivitiesDTO> fas = new ArrayList<FindActivitiesDTO>();
		boolean blo;
		tag: for (ServiceNotesDTO snt : snts) {
			blo = false;
			for (FindActivitiesDTO fat : fas) {
				if (fat.getNowDate().equals(
						DateUtil.jsonDate2String(snt.getBegintime()))) {
					fat.getSnts().add(snt);
					continue tag;
				}
			}
			if (!blo) {
				FindActivitiesDTO fa = new FindActivitiesDTO();
				List<ServiceNotesDTO> sts = new ArrayList<ServiceNotesDTO>();
				String nowDate = DateUtil.jsonDate2String(snt.getBegintime());
				sts.add(snt);
				fa.setNowDate(nowDate);
				fa.setSnts(sts);
				fas.add(fa);
			}
		}
		return fas;
	}

}
