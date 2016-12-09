package com.jg2b.seoBrand.dao;

import java.util.List;

import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.CompanyIntroducePojo;
import com.jg2b.seoPojo.CompanyPojo;
import com.jg2b.seoPojo.FactoryPojo;
import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.KindPojo;
import com.jg2b.seoPojo.SkuInfoPojo;




public interface BrandDao {
	/**
	 * 查询当前品牌下鲸工入驻的供应商数量
	 */
	int queryBrandCount(String brandUuid);

	/**
	 * 查询当前品牌的品牌介绍
	 */
	List<BrandPojo> queryBrandInfos(String brandUuid);

	/**
	 * 当前品牌已询价的次数（按单商品计算）
	 */
	int queryInqueriedCounts(String brandUuid);

	/**
	 * 当前供应商所经营的品牌数量（取前七条）
	 */

	List<BrandPojo> queryCompayUpBrand7(String companyUuid);

	/**
	 * 查询公司介绍信息
	 */
	List<CompanyIntroducePojo> queryCompanyIntroduce(String companyUuid);

	/**
	 * 查询当前品牌下的所有供应商信息
	 */
	List<CompanyPojo> queryCompanysBybranId(String brandUuid, int PageNum,
			int PageSize);

	/**
	 * 查询当前品牌下的所有供应商数量
	 */
	int queryComanyTotalCountsByBrandId(String brandUuid);

	/**
	 * 根据skuUuid查询当前商品的skuInfo信息
	 */
	List<SkuInfoPojo> querySkuInfoBySkuId(String skuUuid);

	/**
	 * 根据工厂id查询当前商品所属厂家信息
	 */
	FactoryPojo queryFactory(String factoryUuid);

	/**
	 * 查询当前品牌下的所有商品
	 */
	List<GoodDto> queryGoodsUpBrandId(String brandUuid,int pageNum,int pageSize);

	/**
	 * 查询当前sku的属性 商品属性 供应商介绍
	 * 
	 * @param brand_id
	 * @return
	 */
	GoodsInfoDto querySkuDetails(String goodsUuid);


	/**
	 * 查询当前品牌下所有数量
	 * 
	 * @param string
	 * @return
	 */
	int queryGoodsUpBrandIdCount(String brandUuid);
     

	/**
	 * 查询skuinfo key value
	 * 
	 * @param string
	 * @return
	 */
	List<SkuInfoPojo> querySkuInfo(String skuUuid);

	/**
	 * 查询goodsInfo key value
	 * 
	 * @param skuId
	 * @return
	 */
	List<GoodsInfoPojo> queryGoodsInfo(String goodsUuid);

	/**
	 * 根据goodsId查询 所在类目
	 * 
	 * @param goodsId
	 * @return
	 */
	String querySameKindNum(String goodsUuid);

	/**
	 * 根据kindId 查询该类目下的商品
	 * 
	 * @param kindId
	 * @return
	 */
	List<GoodDto> querySameKindInfo(String kindUuid);
	/**
	 * 查询skuinfo 信息
	 * @param skuUuid
	 * @return
	 */
	List<SkuInfoPojo> querySkuInfoBySkuUuid(String skuUuid);

	/**
	 * 商品—查询品牌下同类供应商（入驻）
	 * 
	 * @param brandId
	 * @return
	 */
	List<CompanyDto> queryCompanyUpBrandId(String brandUuid);

	/**
	 * 商品—查询品牌下同类供应商（未入驻）
	 * 
	 * @param brandId
	 * @return
	 */
	List<CompanyDto> queryUnCompanyUpBrandId(String brandUuid);

	/**
	 * 商品—侧边公共栏相关类别
	 * 
	 * @param 无参数
	 * @return
	 */
	List<KindPojo> queryKingPojo12UpGoods();

	/**
	 * <p>品牌信息分页查询 cms_brand</p>
	 * 
	 * @param brandPojo
	 * @return
	 * @author: 刘毅 - liuyi@jg2b.com
	 * @date: Created on 2016年6月22日 下午2:00:32
	 */
	List<BrandPojo> queryBrandsList(BrandPojo brandPojo, int PageNum,
			int PageSize);

	/**
	 * <p>根据brandUuid查询品牌信息</p>
	 * 
	 * @param brandPojo
	 * @return
	 * @author: 刘毅 - liuyi@jg2b.com
	 * @date: Created on 2016年6月22日 下午2:00:32
	 */
	BrandPojo queryBrandInfoByBrandUuid(String brandUuid);
/**
 * 根据分类uuid  查询分类下的商品uuid
 * @param kindUuid
 * @return
 */
	List<GoodDto> queryGoodsUuidByKindUuid(String kindUuid);
	/**
	 * 查询同类商品信息
	 * @param goodsUuid
	 * @return
	 */
	List<GoodDto> querySimilarGoods(String goodsUuid); 
	
}
