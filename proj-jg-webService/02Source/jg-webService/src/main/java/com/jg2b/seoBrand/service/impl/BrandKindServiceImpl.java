package com.jg2b.seoBrand.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.conts.BaseConts;
import com.jg2b.seoBrand.dao.BrandDao;
import com.jg2b.seoBrand.dao.BrandKindDao;
import com.jg2b.seoBrand.service.BrandKindService;
import com.jg2b.seoBrand.service.GoodsService;
import com.jg2b.seoDto.BrandListDto;
import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.KindCompanyDto;
import com.jg2b.seoDto.Response.BrandCompanysKindInfo;
import com.jg2b.seoDto.Response.BrandMainPageInfo;
import com.jg2b.seoDto.Response.KindGoodsPageInfo;
import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.CompanyPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.seoPojo.KindPojo;
import com.jg2b.seoPojo.QueryGoodsByCompanyPojo;
import com.jg2b.utils.PageRequest;
import com.jg2b.utils.PageResponse;
import com.jg2b.vo.KindPageVo;
/**
 * <p>[描述信息：门户页面 分类模块页面相关接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午9:56:58
 */
@Service
public class BrandKindServiceImpl implements BrandKindService {
	@Autowired
	private BrandKindDao brandKindDao;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private BrandDao brandDao;
	
	
	/**
	 * 同类商品分页查询
	 * @param kindUuid
	 * @param pageRequest
	 * @return
	 */
	public PageResponse<BrandListDto> queryBrandDetails(String kindUuid,PageRequest pageRequest){
		List<BrandListDto> brandListList = new ArrayList<BrandListDto>();
		List<CompanyPojo> companyPojoList = null;
		List<GoodsPojo> goodsList = null;
		BrandListDto brandListDto = null;
		List<BrandListDto> brandByKind = this.brandKindDao.queryBrandByKind(kindUuid,pageRequest.getPageNum(), pageRequest.getPageSize());
		int totalCounts = brandKindDao.queryTotalCounts(kindUuid);
		if (CollectionUtils.isNotEmpty(brandByKind)) {
		for (BrandListDto brandListDto1 : brandByKind) {
			companyPojoList=new ArrayList<CompanyPojo>();
			goodsList=new ArrayList<GoodsPojo>();
			int companyNum = brandKindDao.queryBrandCount(brandListDto1.getBrandUuid());
			int inquiryNum = brandKindDao.queryInqueriedCounts(brandListDto1.getBrandUuid());
			List<BrandListDto> queryBrandDetails = this.brandKindDao.queryBrandDetails(brandListDto1.getBrandUuid());
			if (CollectionUtils.isNotEmpty(queryBrandDetails)) {
				for (BrandListDto brandListDto2 : queryBrandDetails) {
					brandListDto = new BrandListDto();
					brandListDto.setName(brandListDto2.getName());
					brandListDto.setBrand_name(brandListDto2.getBrand_name());
					List<CompanyPojo> queryCompany = this.brandKindDao.queryCompany(brandListDto2.getCompanyUuid());
					companyPojoList.addAll(queryCompany); 
					brandListDto.setCompanyPojo(companyPojoList);
					List<GoodsPojo> goods =this.brandKindDao.queryGoodsBycompanyUuid(brandListDto2.getCompanyUuid());
					goodsList.addAll(goods);
					brandListDto.setGoodsPojo(goods);
				}
			}
			brandListDto.setBrandUuid(brandListDto1.getBrandUuid());
			brandListDto.setInquiryNum(inquiryNum);
			brandListDto.setCompanyNum(companyNum);
			brandListList.add(brandListDto);
		}
	}
		PageResponse<BrandListDto> PageResponse = new PageResponse<BrandListDto>();
		PageResponse.setTotalCounts(totalCounts);
		PageResponse.setT(brandListList);
		PageResponse.setPageNum(pageRequest.getPageNum());
		PageResponse.setPageSize(pageRequest.getPageSize());
		return PageResponse;
	}

	
	/**
	 * 品牌页面数据展示
	 * 包括（查询当前品牌下鲸工入驻的供应商数量
	 * 	        当前品牌已询价的次数（按单商品计算）
	 *     品牌感兴趣/采购过计数
	 *     品牌介绍：有内容就显示，点击更多查看详情页；若无内容则不显示
	 *     
	 * 	）
	 * 
	 * @param requestParam(分类ID)
	 * @return
	 */
	@Override
	public BrandMainPageInfo queryKindMainPageInfo(KindPageVo requestParam) {
		        BrandMainPageInfo mainInfo=new BrandMainPageInfo();
		        //查询分类信息
		        KindPojo kindPojo=brandKindDao.queryKindPojoByKindUuid(requestParam.getKindUuid());
		        mainInfo.setKindPojo(kindPojo);
		        
	         	//查询当前分类下鲸工入驻的供应商数量(0未入驻1入住)
				int enteringSupplierNum = brandKindDao.queryCompanyCountUdKingId(requestParam.getKindUuid(),BaseConts.NOT_AUDIT_PASS);
				//当前分类已询价的次数（按单商品计算）
				int enquiryNum=	brandKindDao.queryInqueryUdKingId(requestParam.getKindUuid());
				mainInfo.setEnquiryNum(enquiryNum);
				mainInfo.setEnteringSupplierNum(enteringSupplierNum);
				//品牌感兴趣/采购过计数(暂无数据来源) 默认为0
				mainInfo.setInterestedNum(0);
				mainInfo.setPurchasedNum(0);
				return mainInfo;
	}

	/***
	 * 当前分类 采集库中 供应商最多的3个品牌显示
	 * @param kindUuid(分类ID)
	 */
	@Override
	public  List<KindCompanyDto> queryCompanyListByKind(String kindUuid) {
		 List<KindCompanyDto> companyList=brandKindDao.queryCompanyListByKind(kindUuid);
		 if(companyList==null)
		 return null;
		 return companyList;
	}
	
	 /**
     * 分类商品分页
     * @param kindUuid
     * @return
     */
	@Override
	public KindGoodsPageInfo queryKindGood(String kindUuid,PageRequest pageRequest) {
		
		KindGoodsPageInfo kindGoodsPageInfo=new KindGoodsPageInfo();
		//分页查询当前分类下的商品
		List<GoodsInfoDto> goodsInfoList=brandKindDao.queryKindGood(kindUuid,pageRequest.getStartIndex(),pageRequest.getPageSize());
		//查询某分类下的商品信息 总数
		int count=brandKindDao.queryKindGoodCounts(kindUuid);
		kindGoodsPageInfo.setGoodsInfoList(goodsInfoList);
		kindGoodsPageInfo.setCount(count);
		return kindGoodsPageInfo;
	}
	
	/** @param kindUuid
 	 * @function 当前分类 品牌商家：供应商列表包含鲸工入驻供应商未入驻供应商
 	 * @return BrandCompanysKindInfo
 	 * @author gongjp
 	 * @date  2016-06-29 下午 16:37:21
 	 */
	@Override
	public BrandCompanysKindInfo queryCompanyUpKind(String kindUuid,PageRequest pageRequest) {
		BrandCompanysKindInfo brandCompanysKindInfo=new BrandCompanysKindInfo();
		List<CompanyDto> list = brandKindDao.queryCompanyUpKind(kindUuid,pageRequest.getPageNum(),pageRequest.getPageSize());
		//当前分类 品牌商家：供应商列表包含鲸工入驻供应商未入驻供应商总数
        int count=brandKindDao.queryCompanyUpKindCounts(kindUuid);
        //查询当前分类中供应商列表总数
        brandCompanysKindInfo.setCount(count);
        //供应商列表下面对应的经销品牌信息
        List<BrandPojo> brands=null;
        //供应商下面的产品信息
        List<QueryGoodsByCompanyPojo> goodsList=null;
		if(CollectionUtils.isNotEmpty(list)){
			for (CompanyDto companyDto : list) {
				brands=new ArrayList<BrandPojo>();
				goodsList=new ArrayList<QueryGoodsByCompanyPojo>();
				//根据供应商id查询对应的品牌信息
				List<BrandPojo> brand7List = brandDao.queryCompayUpBrand7(companyDto.getCompanyUuid());
				//封装经营品牌信息
				brands.addAll(brand7List);
				//根据供应商id查询对应的产品id，name，图片信息
				 List<QueryGoodsByCompanyPojo> gList = goodsService.queryGoodsByCompanyId(companyDto.getCompanyUuid());
				 goodsList.addAll(gList);
				//将品牌信息添加到实体类中
				companyDto.setBrands(brands);
				//将商品信息添加到实体类中
				companyDto.setGoods(goodsList);
			}
		}
		//设置供应商信息
		 brandCompanysKindInfo.setCompanys(list);
		 return brandCompanysKindInfo;
	}
}
