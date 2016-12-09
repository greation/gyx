package com.jg2b.h5.dao;

import java.util.List;

import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.UserDetailDto;
import com.jg2b.h5.pojo.CompanyPagePojo;
import com.jg2b.h5.pojo.ContactPojo;
import com.jg2b.h5.vo.MainPageQueryVo;

public interface CompanyDao {
	
	/**
	 * 根据用户ID查询该用户最近联系的公司详情
	 * @param userId
	 * @author liucongcong
	 * @param pageSize 
	 * @param pageNum 
	 * @return
	 * 2016年7月5日
	 */
	public List<CompanyDto> queryCompanyDetail(int userId, int pageNum, int pageSize);
	/**
	 * 根据供应商ID查询公司主营产品
	 * @param userId
	 * @author liucongcong
	 * @return
	 * 2016年7月5日
	 */
	public List<String> queryCompanyGoodsName(int companyId);
	/**
	 * 根据供应商ID查询公司主营品牌
	 * @param userId
	 * @author liucongcong
	 * @return
	 * 2016年7月5日
	 */
	public List<String> queryCompanyBrandName(int companyId);
	/**
	 * 添加用户最近联系
	 * @param contactVo
	 * 2016年7月5日
	 */
	public int addContact(ContactPojo contactPojo);

	
	public List<String> queryCompanyIdsForMainSearch(MainPageQueryVo vo);
	
	/**
	 * <p>根据一列id查询公司信息</p>
	 * 
	 * @param companyIds
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年7月5日 下午7:53:12
	 */
	public List<CompanyDto> queryCompanysByIds(List<String> companyIds);

	/**
	 * 根据用户ID查询用户信息
	 * @param userId
	 * @return
	 * 2016年7月5日
	 */
	public UserDetailDto queryDetailUserInfo(int userId);
	/**
	 * 根据用户ID查询公司经营品类
	 * @param companyId
	 * @return
	 * 2016年7月5日
	 */
	public List<String> queryCompanyCategoryName(int userId);
	/**
	 * 根据regionID查询地区名字
	 * @param regionId
	 * @return
	 * 2016年7月5日
	 */
	public String queryRegionName(int regionId);
	public CompanyPagePojo queryCompanysById(String company_id);


}
