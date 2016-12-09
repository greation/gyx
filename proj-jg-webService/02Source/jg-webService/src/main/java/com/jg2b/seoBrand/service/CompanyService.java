package com.jg2b.seoBrand.service;

import java.util.List;

import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.utils.PageRequest;

/**
 * <p>[描述信息：供应商接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午10:29:45
 */
public interface CompanyService {

	/**
	 * 查询供应商详细信息
	 * 
	 * 
	 * @param companyPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:47:09
	 */
	CompanyInfoPojo queryCompanyInfoByUuid(CompanyInfoPojo CompanyInfoPojo);
	
	/**
	 * 查询某品牌下的供应商信息
	 * 
	 * @param brandUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午2:42:50
	 */
	List<CompanyInfoPojo> queryCompanyInfosByBrandUuid(String brandUuid,PageRequest pageRequest);
	
	/**
	 * 查询某品牌下的供应商信息总数
	 * 
	 * @param brandUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午2:42:50
	 */
	int queryCompanyInfosByBrandUuidCount(String brandUuid);

}
