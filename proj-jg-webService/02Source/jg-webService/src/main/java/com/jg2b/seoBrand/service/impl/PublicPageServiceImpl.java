package com.jg2b.seoBrand.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.jg2b.conts.BaseConts;
import com.jg2b.seoBrand.service.CompanyService;
import com.jg2b.seoBrand.service.GoodsService;
import com.jg2b.seoBrand.service.PublicPageService;
import com.jg2b.seoDto.Response.GoodDetailsPageInfo;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;
/**
 * <p>[描述信息：门户页面 公共模块页面相关接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午9:58:14
 */
@Service
public class PublicPageServiceImpl implements PublicPageService {
	/**
	 * 商品接口
	 */
	@Autowired
	private GoodsService goodsService; 
	/**
	 * 供应商接口
	 */
	@Autowired
	private CompanyService companyService;
	
	@Override
	public GoodDetailsPageInfo queryGoodDetailsPage(String goodsUuid) {
		GoodDetailsPageInfo detail=new GoodDetailsPageInfo();
		//商品详情
		GoodsPojo goodsInfo=goodsService.queryGoodsByUuid(goodsUuid);
		detail.setGoodsInfo(goodsInfo);
		
		//所属供应商及信息
		CompanyInfoPojo companyInfoPojo=null;
		
		if(goodsInfo==null)
			return detail;
		
		if(!StringUtils.isEmpty(goodsInfo.getCompanyUuid())){
			CompanyInfoPojo queryCompanyParam=new CompanyInfoPojo();
			queryCompanyParam.setCompanyUuid(goodsInfo.getCompanyUuid());
			companyInfoPojo=companyService.queryCompanyInfoByUuid(queryCompanyParam);
			detail.setCompanyInfoPojo(companyInfoPojo);
		}
		
		//当前商品所属分类的下的其它商品(10条)
		List<GoodsPojo> goodsList=null;
		if(!StringUtils.isEmpty(goodsInfo.getSkuUuid())){
			GoodsPojo queryGoodsParam=new GoodsPojo();
			queryGoodsParam.setSkuUuid(goodsInfo.getSkuUuid());
			queryGoodsParam.setDeleted(BaseConts.DELETE_INVALID);
			goodsList=goodsService.queryGoodsList(queryGoodsParam,10,0);
			detail.setRelatedGoodsInfo(goodsList);
		}
		//detail.setCompanyPojo(companyPojo);
		return detail;
	}
	
}
