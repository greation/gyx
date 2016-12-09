package com.jg2b.seoBrand.service;

import java.util.List;

import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.seoPojo.QueryGoodsByCompanyPojo;

/**
 * <p>[描述信息：商品接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午10:27:31
 */
public interface GoodsService {
	
	/**
	 * <p>根据goodsUuid查询商品详情(包括详细信息+属性key-value信息)</p>
	 * 
	 * @param goodsUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午6:43:00
	 */
	GoodsPojo queryGoodsByUuid(String goodsUuid);
	
	/**
	 * <p>根据goodsUuid查询商品所有key-value信息</p>
	 * 
	 * @param goodsInfoPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午7:24:40
	 */
	List<GoodsInfoPojo> queryGoodsAttributesByUuid(String goodsUuid);
	
	/**
	 * <p>分页查询商品详细信息</p>
	 * 
	 * @param goodsPojo
	 * @param rowNum
	 * @param page
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午7:25:02
	 */
	List<GoodsPojo> queryGoodsList(GoodsPojo goodsPojo,
			Integer rowNum,Integer page);
	
	/**
	 * <p>根据供应商uuid查询产品</p>
	 * 
	 * @param brandUuid
	 * @param rowNum
	 * @param page
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午6:01:19
	 */
	List<GoodsPojo> queryGoodsByCompanyUuid(String companyUuid,
			Integer rowNum,Integer startIndex);
	
	/**
	 * <p>根据品牌uuid查询产品</p>
	 * 
	 * @param companyUuid
	 * @param rowNum
	 * @param startIndex
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月30日 下午1:54:50
	 */
	List<GoodsPojo> queryGoodsByBrandUuid(String brandUuid,
			Integer rowNum,Integer startIndex);
	
	/**
	 * <p>根据品牌uuid查询产品</p>
	 * 
	 * @param companyUuid
	 * @param rowNum
	 * @param startIndex
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月30日 下午1:54:50
	 */
	List<GoodsPojo> queryGoodsBySkuUuidUuid(String skuUuid,
			Integer rowNum,Integer startIndex);
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
