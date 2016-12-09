package com.jg2b.seoBrand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.seoBrand.dao.CompanyDao;
import com.jg2b.seoBrand.service.CompanyService;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.utils.PageRequest;
/**
 * <p>[描述信息：供应商接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午10:29:45
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;
	/**
	 * 	查询供应商信息[主表+公司介绍]
	 * @param companyPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:47:09
	 */
	@Override
	public CompanyInfoPojo queryCompanyInfoByUuid(CompanyInfoPojo queryCompanyPojo) {
		return companyDao.queryCompanyInfoByUuid(queryCompanyPojo);
	}
	
	/**
	 * 查询某品牌下的供应商信息
	 * 
	 * @param brandUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午2:42:50
	 */
	@Override
	public List<CompanyInfoPojo> queryCompanyInfosByBrandUuid(String brandUuid,PageRequest pageRequest){ 
		return companyDao.queryCompanyInfosByBrandUuid(brandUuid,pageRequest.getStartIndex(),pageRequest.getPageSize());
	}
	
	/**
	 * 查询某品牌下的供应商信息总数
	 * 
	 * @param brandUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午2:42:50
	 */
	@Override
	public int queryCompanyInfosByBrandUuidCount(String brandUuid){ 
		return companyDao.queryCompanyInfosByBrandUuidCount(brandUuid);
	}

}
