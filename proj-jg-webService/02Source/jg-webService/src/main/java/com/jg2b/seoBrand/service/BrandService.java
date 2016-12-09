package com.jg2b.seoBrand.service;

import java.util.List;

import com.jg2b.seoDto.BrandDto;
import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.Response.BrandCompanysPageInfo;
import com.jg2b.seoDto.Response.BrandMainPageInfo;
import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.KindPojo;
import com.jg2b.utils.PageRequest;
import com.jg2b.utils.PageResponse;
import com.jg2b.vo.BrandVo;



/**
 * <p>[描述信息：品牌接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午10:30:05
 */
public interface BrandService {
	/**
	 * 查询当前品牌下鲸工入驻的供应商数量
	 */
	int queryBrandCounts(String brandUuid);

	/**
	 * 查询当前品牌的品牌介绍
	 */
	List<BrandDto> queryBrandInfos(String brandUuid);

	/**
	 * 当前品牌已询价的次数（按单商品计算）
	 */
	int queryInqueriedCounts(String brandUuid);

	/**
	 * <p>品牌页面查询供应商列表
	 * 		供应商列表包括供应商信息、供应商下产品信息
	 * </p>
	 * 
	 * @param BrandUuid
	 * @param pageRequest
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月28日 下午6:10:10
	 */
	BrandCompanysPageInfo queryCompanysBybranId( String BrandUuid,
			PageRequest pageRequest);

	/**
	 * 当前品牌下的所有商品
	 */
	PageResponse<GoodDto> queryGoodsUpBrand(String BrandUuid, PageRequest pageRequest);

	/**
	 * 查询商品描述 和供应商公司详情
	 * 
	 * @param goodsUuid
	 * @return
	 */
	List<GoodsInfoDto> queryProductDetails(String goodsUuid);

	/**
	 * 查询同类商品
	 * 
	 * @param goodsUuid
	 * @return
	 */
	List<GoodDto> querySimilarGoods(String kindUuid);

	/**
	 * 查询品牌下右侧边栏同类供应商
	 */
	List<CompanyDto> queryCompanyUpBrandId(String BrandUuid);

	/**
	 * 查询品牌下右侧边栏同类供应商(未入驻)
	 */
	List<CompanyDto> queryUnCompanyUpBrandId(String BrandUuid);

	/**
	 * 查询品牌下右侧边栏相关类别
	 */
	List<KindPojo> queryKingPojo12UpGoods();
	/**
	 * <p>
	 * 	品牌详情页右边框 相关品牌
	 * 	查询规则待定，暂时数据库随机查询
	 * </p>
	 * 
	 * @param brandPojo
	 * @return
	 * @author: 刘毅 - liuyi@jg2b.com
	 * @date: Created on 2016年6月22日 下午2:00:32
	 */
	List<BrandPojo> queryBrandsList(BrandPojo brandPojo, int PageNum,
			int PageSize);
	/**
	 * <p>
	 * 	品牌主页内容查询
	 *  包括（查询当前品牌下鲸工入驻的供应商数量
	 * 	         当前品牌已询价的次数（按单商品计算）
	 *     品牌感兴趣/采购过计数
	 *     品牌介绍：有内容就显示，点击更多查看详情页；若无内容则不显示）
	 * </p>
	 * 
	 * @param brandPojo
	 * @return
	 * @author: 刘毅 - liuyi@jg2b.com
	 * @date: Created on 2016年6月22日 下午2:00:32
	 */
	BrandMainPageInfo queryBrandMainPageInfo(BrandVo requestParam);

}
