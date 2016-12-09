package com.jg2b.seoBrand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.CompanyIntroducePojo;
import com.jg2b.seoPojo.CompanyPojo;

/**
 * <p>[描述信息：供应商dao]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月28日 上午9:58:19
 */
public interface CompanyDao {
	
	/**
	 * <p>查询供应商信息</p>
	 * 
	 * @param companyInfoPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午2:28:24
	 */
	CompanyInfoPojo queryCompanyInfoByUuid(CompanyInfoPojo companyInfoPojo);
	
	/**
	 * <p>查询某品牌下的供应商信息</p>
	 * 
	 * @param companyPojo
	 * @param rowNum  每页个数
	 * @param page 页码
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:56:40
	 */
	List<CompanyInfoPojo> queryCompanyInfosByBrandUuid(String brandUuid,
			Integer startIndex,Integer rowNum);
	
	/**
	 * <p>查询某品牌下的供应商总数</p>
	 * 
	 * @param brandUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午2:54:33
	 */
	int queryCompanyInfosByBrandUuidCount(String brandUuid);
	
	/**
	 * <p>查询供应商主表信息</p>
	 * 
	 * @param companyPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:56:23
	 */
	CompanyPojo queryCompanysByUuid(CompanyPojo companyPojo);
	
	/**
	 * <p>分页查询供应商信息</p>
	 * 
	 * @param companyPojo
	 * @param rowNum
	 * @param page
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:56:40
	 */
	List<CompanyInfoPojo>	queryCompanyInfoList(@Param("companyInfoPojo")CompanyInfoPojo companyInfoPojo,
			@Param("rowNum")Integer rowNum,@Param("startIndex")Integer startIndex);
	
	/**
	 * <p>查询供应商公司介绍信息</p>
	 * 
	 * @param companyUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:56:38
	 */
	CompanyIntroducePojo queryCompanyIntroduceByUuid(String companyUuid);

	
}
