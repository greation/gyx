package com.jg2b.seoBrand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.seoPojo.QueryGoodsByCompanyPojo;

/**
 * <p>[描述信息：商品dao]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月28日 上午9:58:03
 */
public interface GoodsDao {
	/**
	 * <p>查询商品key-value信息</p>
	 * 
	 * @param goodsInfoPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:57:08
	 */
	List<GoodsInfoPojo> queryGoodsAttributesByUuid(GoodsInfoPojo goodsInfoPojo);
	
	/**
	 * <p>查询商品主表信息</p>
	 * 
	 * @param goodsPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:57:29
	 */
	GoodsPojo queryGoodsByUuid(GoodsPojo goodsPojo);
	
	/**
	 * <p>分页查询商品主表信息</p>
	 * 
	 * @param goodsPojo
	 * @param rowNum
	 * @param page
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 上午9:57:42
	 */
	List<GoodsPojo> queryGoodsList(@Param("goodsPojo")GoodsPojo goodsPojo,
			@Param("rowNum")Integer rowNum,@Param("startIndex")Integer startIndex);
	
	/**
	 * <p>根据供应商id查询对应的产品信息（goodsUuid，name,image）</p>
	 * 
	 * @param companyUuid
	 * @return List<GoodsPojo>
	 * @author:gongjp 
	 * @date: Created on 2016年7月01日 上午9:28:22
	 */
	List<QueryGoodsByCompanyPojo> queryGoodsByCompanyId(String companyUuid);
}
