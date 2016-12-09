package com.jg2b.h5.service;

import java.util.List;

import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.UserDetailDto;
import com.jg2b.h5.pojo.CompanyPagePojo;
import com.jg2b.h5.vo.CompanyPageVo;
import com.jg2b.h5.vo.ContactVo;
import com.jg2b.h5.vo.MainPageQueryVo;
import com.jg2b.utils.PageRequest;

/**
 * 公司详情接口
 * @author liucongcong
 *
 */
public interface CompanyService {
	/**
	 * 根据用户ID得到最近联系的公司详情的集合
	 * @param userId
	 * @return
	 * 2016年7月5日
	 */
	public List<CompanyDto> queryCompanyDto(int userId, PageRequest pageRequest);
	/**
	 * 添加用户最近联系
	 */
	public int insertContact(ContactVo contactVo);
	
	/**
	 * <p>搜索功能</p>
	 * 
	 * @param vo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年7月5日 下午6:58:53
	 */
	public List<CompanyDto> queryCompanyMainSearch(MainPageQueryVo vo); 
	/**
	 * 根据用户ID查询用户详细信息
	 * @param userId
	 * @return
	 * 2016年7月5日
	 */
	public UserDetailDto queryDetailUserInfo(int userId);
	/**
	 * <p>查询供应商详情页面信息</p>
	 * 
	 * @param string
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年7月7日 下午1:08:44
	 */
	public CompanyPagePojo queryCompanyPageInfo(CompanyPageVo vo);
}
