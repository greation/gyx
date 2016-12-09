package com.jg2b.h5.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.h5.dao.CircleDao;
import com.jg2b.h5.dao.CompanyDao;
import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.UserDetailDto;
import com.jg2b.h5.pojo.CompanyPagePojo;
import com.jg2b.h5.pojo.ContactPojo;
import com.jg2b.h5.pojo.ProductPojo;
import com.jg2b.h5.service.CompanyService;
import com.jg2b.h5.vo.CompanyPageVo;
import com.jg2b.h5.vo.ContactVo;
import com.jg2b.h5.vo.MainPageQueryVo;
import com.jg2b.utils.PageRequest;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private CircleDao circleDao;
	
	@Override
	public List<CompanyDto> queryCompanyDto(int userId, PageRequest pageRequest) {
		List<CompanyDto> companyDtoList=new ArrayList<CompanyDto>();
		companyDtoList=companyDao.queryCompanyDetail(userId,pageRequest.getStartIndex(),pageRequest.getPageSize());
		List<String> goodsList=new ArrayList<String>();
		List<String> brandList=new ArrayList<String>();
		for (CompanyDto cd : companyDtoList) {
			goodsList=companyDao.queryCompanyGoodsName(cd.getCompany_id());
			brandList=companyDao.queryCompanyBrandName(cd.getCompany_id());
			cd.setBrandList(brandList);
			cd.setGoodsList(goodsList);
		}
		return companyDtoList;
	}

	@Override
	public int insertContact(ContactVo contactVo) {
		ContactPojo contactPojo=new ContactPojo();
		contactPojo.setCompany_id(contactVo.getUser_id());
		contactPojo.setUser_id(contactVo.getUserId());
		int add_time=(int) (System.currentTimeMillis()/1000);
		contactPojo.setAdd_time(add_time);
		int a=companyDao.addContact(contactPojo);
		return a;
	}


	@Override
	public List<CompanyDto> queryCompanyMainSearch(MainPageQueryVo vo) {
		List<String> companyIds=companyDao.queryCompanyIdsForMainSearch(vo);
		if(companyIds==null||companyIds.size()<=0)
			return null;

		List<CompanyDto> companyDtoList=new ArrayList<CompanyDto>();
		companyDtoList=companyDao.queryCompanysByIds(companyIds);
		List<String> goodsList=new ArrayList<String>();
		List<String> brandList=new ArrayList<String>();
		for (CompanyDto cd : companyDtoList) {
			goodsList=companyDao.queryCompanyGoodsName(cd.getCompany_id());
			brandList=companyDao.queryCompanyBrandName(cd.getCompany_id());
			cd.setBrandList(brandList);
			cd.setGoodsList(goodsList);
		}
		return companyDtoList;
	}

	@Override
	public UserDetailDto queryDetailUserInfo(int userId) {
		UserDetailDto udd=companyDao.queryDetailUserInfo(userId);
		String province=companyDao.queryRegionName(udd.getProvince());
		if(province==null){
			province="";
		}
		String city=companyDao.queryRegionName(udd.getCity());
		if(city==null){
			city="";
		}
		String region=companyDao.queryRegionName(udd.getRegion());
		if(region==null){
			region="";
		}
		String area=province+city+region;
		List<String> categoryList=companyDao.queryCompanyCategoryName(userId);
		List<String> brandList=new ArrayList<String>();
		System.out.println(udd);
		if(udd.getCompany_id()!=null){
			brandList=companyDao.queryCompanyBrandName(udd.getCompany_id());
		}
		udd.setArea(area);
		udd.setBrandList(brandList);
		udd.setCategoryList(categoryList);
		
		return udd;
	}
	@Override
	public CompanyPagePojo queryCompanyPageInfo(CompanyPageVo vo) {
		CompanyPagePojo pojo=companyDao.queryCompanysById(vo.getCompany_id());
		List<ProductPojo> productList = circleDao.queryProductsByCompanyIdForPage(vo);
		if(pojo==null)
			return null;
		pojo.setProducts(productList);
		List<String> goodsList=new ArrayList<String>();
		List<String> brandList=new ArrayList<String>();
		goodsList=companyDao.queryCompanyGoodsName(pojo.getCompany_id());
		brandList=companyDao.queryCompanyBrandName(pojo.getCompany_id());
		pojo.setGoodsList(goodsList);
		pojo.setBrandList(brandList);
		return pojo;
	}

}
