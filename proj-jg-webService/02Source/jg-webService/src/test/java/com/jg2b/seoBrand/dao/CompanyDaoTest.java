package com.jg2b.seoBrand.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.CompanyPojo;

public class CompanyDaoTest  extends BaseDaoTest{
	@Autowired
	CompanyDao companyDao;
	
	@Test
	public void queryCompanysByUuid(){
		CompanyPojo companyPojo=new CompanyPojo();
		companyPojo.setCompanyUuid("40b01c9429ba4f9faf0136a64be654ea");
		companyDao.queryCompanysByUuid(companyPojo);
	}
	
	@Test
	public void queryGoodsList(){
		CompanyInfoPojo companyPojo=new CompanyInfoPojo();
		companyDao.queryCompanyInfoList(companyPojo, null, null);
	}
	
	
	@Test
	public void queryCompanyInfosByBrandUuid(){
		companyDao.queryCompanyInfosByBrandUuid("0676d0a9cbbe4812b11bccd0386ef915",new Integer(10),new Integer(0));
	}
}
