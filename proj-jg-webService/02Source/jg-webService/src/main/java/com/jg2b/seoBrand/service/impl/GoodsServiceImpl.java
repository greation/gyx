package com.jg2b.seoBrand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.conts.BaseConts;
import com.jg2b.seoBrand.dao.GoodsDao;
import com.jg2b.seoBrand.service.GoodsService;
import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.seoPojo.QueryGoodsByCompanyPojo;
/**
 * <p>[描述信息：商品接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午10:27:31
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
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
	@Override
	public List<GoodsPojo> queryGoodsList(GoodsPojo goodsPojo,
			Integer rowNum, Integer startIndex) {
		return goodsDao.queryGoodsList(goodsPojo, rowNum, startIndex);
	}
	/**
	 * <p>根据goodsUuid查询商品详情(包括主表信息+属性key-value信息)</p>
	 * 
	 * @param goodsUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午6:43:00
	 */
	@Override
	public GoodsPojo queryGoodsByUuid(String goodsUuid) {
		GoodsPojo queryGoodsParam=new GoodsPojo();
		queryGoodsParam.setGoodsUuid(goodsUuid);
		queryGoodsParam.setDeleted(BaseConts.DELETE_INVALID);
		GoodsPojo goodsPojo=goodsDao.queryGoodsByUuid(queryGoodsParam);
		return goodsPojo;
	}
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
	@Override
	public List<GoodsPojo> queryGoodsByCompanyUuid(String companyUuid,
			Integer rowNum, Integer startIndex) {
		GoodsPojo queryParam=new GoodsPojo();
		queryParam.setCompanyUuid(companyUuid);
		return this.queryGoodsList(queryParam, rowNum, startIndex);
	}
	/**
	 * <p>根据goodsUuid查询商品所有key-value信息</p>
	 * 
	 * @param goodsInfoPojo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午7:24:40
	 */
	@Override
	public List<GoodsInfoPojo> queryGoodsAttributesByUuid(String goodsUuid) {
		GoodsInfoPojo queryParam=new GoodsInfoPojo();
		queryParam.setGoodsUuid(goodsUuid);
		queryParam.setDeleted(BaseConts.DELETE_INVALID);
		return goodsDao.queryGoodsAttributesByUuid(queryParam);
	}
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
	@Override
	public List<GoodsPojo> queryGoodsByBrandUuid(String brandUuid,
			Integer rowNum, Integer startIndex) {
		GoodsPojo queryParam=new GoodsPojo();
		queryParam.setBrandUuid(brandUuid);
		return this.queryGoodsList(queryParam, rowNum, startIndex);
	}
	
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
	@Override
	public List<GoodsPojo> queryGoodsBySkuUuidUuid(String skuUuid,
			Integer rowNum, Integer startIndex) {
		GoodsPojo queryParam=new GoodsPojo();
		queryParam.setSkuUuid(skuUuid);
		return this.queryGoodsList(queryParam, rowNum, startIndex);
	}
	
	/**
	 * <p>根据供应商id查询对应的产品信息（goodsUuid，name,image）</p>
	 * 
	 * @param companyUuid
	 * @return List<GoodsPojo>
	 * @author:gongjp 
	 * @date: Created on 2016年7月01日 上午9:28:22
	 */
	@Override
	public List<QueryGoodsByCompanyPojo> queryGoodsByCompanyId(String companyUuid) {
		return goodsDao.queryGoodsByCompanyId(companyUuid);
	}

}
