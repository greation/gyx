package com.jg2b.seoBrand.service;

import java.util.List;

import com.jg2b.seoDto.BrandListDto;
import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.KindCompanyDto;
import com.jg2b.seoDto.Response.BrandCompanysKindInfo;
import com.jg2b.seoDto.Response.BrandMainPageInfo;
import com.jg2b.seoDto.Response.KindGoodsPageInfo;
import com.jg2b.utils.PageRequest;
import com.jg2b.utils.PageResponse;
import com.jg2b.vo.BrandVo;
import com.jg2b.vo.KindPageVo;

/**
 * <p>[描述信息：分类接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午9:56:58
 */
public interface BrandKindService {
	/**
	 * 同类商品分页查询
	 * @param kindUuid
	 * @param pageRequest
	 * @return
	 */
	PageResponse<BrandListDto> queryBrandDetails(String kindUuid,
			PageRequest pageRequest); 
	
	/**
	 * 品牌页面数据展示
	 * 包括（查询当前品牌下鲸工入驻的供应商数量
	 * 	        当前品牌已询价的次数（按单商品计算）
	 *     品牌感兴趣/采购过计数
	 *     品牌介绍：有内容就显示，点击更多查看详情页；若无内容则不显示
	 *     
	 * 	）
	 * 
	 * @param requestParam(品牌ID)
	 * @return
	 */
	BrandMainPageInfo queryKindMainPageInfo(KindPageVo requestParam);
	
	/***
	 * 当前分类 采集库中 供应商最多的3个品牌显示
	 * @param kindUuid(分类ID)
	 */
	List<KindCompanyDto> queryCompanyListByKind(String kindUuid);
	
	
	 /**
     * 分类商品分页
     * @param kindUuid
     * @return
     */
	KindGoodsPageInfo queryKindGood(String kindUuid,PageRequest pageRequest);
	
	 /**
 	 * 当前分类 品牌商家：供应商列表包含鲸工入驻供应商未入驻供应商
 	 * @param kindUuid
 	 * @return
 	 */
     BrandCompanysKindInfo queryCompanyUpKind(String kindUuid,
			PageRequest pageRequest);
	
}
