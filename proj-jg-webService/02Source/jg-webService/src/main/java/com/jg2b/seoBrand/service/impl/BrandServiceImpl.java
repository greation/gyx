package com.jg2b.seoBrand.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jg2b.seoBrand.dao.BrandDao;
import com.jg2b.seoBrand.dao.GoodsDao;
import com.jg2b.seoBrand.service.BrandService;
import com.jg2b.seoBrand.service.CompanyService;
import com.jg2b.seoBrand.service.GoodsService;
import com.jg2b.seoDto.BrandDto;
import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.Response.BrandCompanysPageInfo;
import com.jg2b.seoDto.Response.BrandMainPageInfo;
import com.jg2b.seoDto.Response.CompanyGoodsPageInfo;
import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.CompanyIntroducePojo;
import com.jg2b.seoPojo.CompanyPojo;
import com.jg2b.seoPojo.GoodsInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.seoPojo.KindPojo;
import com.jg2b.seoPojo.SkuInfoPojo;
import com.jg2b.utils.PageRequest;
import com.jg2b.utils.PageResponse;
import com.jg2b.vo.BrandVo;


/**
 * <p>[描述信息：品牌接口]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午10:30:05
 */
@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 查询当前品牌下鲸工入驻的供应商数量
	 */
	public int queryBrandCounts(String brandUuid) {
		return brandDao.queryBrandCount(brandUuid);
	}

	/**
	 * 查询当前品牌的品牌介绍
	 */
	public List<BrandDto> queryBrandInfos(String brandUuid) {
		List<BrandDto> brandDtoList = null;
		BrandDto brandDto = null;
		try {
			brandDtoList = new ArrayList<BrandDto>();
			brandDto = new BrandDto();
			List<BrandPojo> brandInfosList = this.brandDao
					.queryBrandInfos(brandUuid);
			if (brandInfosList != null && brandInfosList.size() > 0) {
				brandDto.setBrandPojo(brandInfosList);
			} else {
				brandDto.setBrandPojo(null);
			}
			brandDtoList.add(brandDto);
		} catch (Exception e) {
			brandDto.setBrandPojo(null);
		}

		return brandDtoList;
	}

	/**
	 * 当前品牌已询价的次数（按单商品计算）
	 */
	@Override
	public int queryInqueriedCounts(String brandUuid) {

		return brandDao.queryInqueriedCounts(brandUuid);
	}

	/**
	 * 当前品牌供应商的数量
	 */
	/*@SuppressWarnings("null")
	@Override
	public PageResponse<CompanyDto> queryCompanysBybranId(String brandUuid,
			PageRequest pageRequest) {
		List<CompanyDto> compangList = new ArrayList<CompanyDto>();
		CompanyDto companyDto =null;
		int totalCounts = brandDao.queryComanyTotalCountsByBrandId(brandUuid);
		List<CompanyPojo> companyList = brandDao.queryCompanysBybranId(brandUuid,
				pageRequest.getPageNum(), pageRequest.getPageSize());
		if (companyList != null && companyList.size() > 0) {
			for (CompanyPojo companyPojo : companyList) {
				companyDto= new CompanyDto();
				companyDto.setCompanyName(companyPojo.getCompany());
				String companyUuid = companyPojo.getCompanyUuid();
				List<CompanyIntroducePojo> introduce = brandDao.queryCompanyIntroduce(companyUuid);
				
				
				companyDto.setIntroduce(introduce);
				List<BrandPojo> brands = brandDao.queryCompayUpBrand7(companyUuid);
				companyDto.setBrands(brands);
				compangList.add(companyDto);
			}
		}
		PageResponse<CompanyDto> PageResponse = new PageResponse<CompanyDto>();
		PageResponse.setTotalCounts(totalCounts);
		PageResponse.setT(compangList);
		PageResponse.setPageNum(pageRequest.getPageNum());
		PageResponse.setPageSize(pageRequest.getPageSize());
		return PageResponse;
	}*/
	
	public BrandCompanysPageInfo queryCompanysBybranId(String brandUuid,
			PageRequest pageRequest) {
		//查询某品牌下的供应商信息
		List<CompanyInfoPojo>companyList=companyService.queryCompanyInfosByBrandUuid(brandUuid, pageRequest);
		if(companyList==null)
			return null;
		//查询某品牌下的供应商信息 总数
		int count=companyService.queryCompanyInfosByBrandUuidCount(brandUuid);
		//返回给前段的实体
		BrandCompanysPageInfo brandCompanysPageInfo=new BrandCompanysPageInfo();
		
		List<CompanyGoodsPageInfo> companys=new ArrayList<CompanyGoodsPageInfo>();
		for(CompanyInfoPojo company:companyList){
			//具体供应商+产品包装实体
			CompanyGoodsPageInfo companyGoodsPageInfo=new CompanyGoodsPageInfo();
			
			//封装供应商信息
			companyGoodsPageInfo.setCompanyInfo(company);
			//封装供应商下面产品信息    (查询2个该供应商的产品   条件为供应商id)
			if(!StringUtils.isEmpty(company.getCompanyUuid())){
				companyGoodsPageInfo.setGoodsList(goodsService.queryGoodsByCompanyUuid(company.getCompanyUuid(), 2, 0));
				companyGoodsPageInfo.setBrands(brandDao.queryCompayUpBrand7(company.getCompanyUuid()));
			}
			companys.add(companyGoodsPageInfo);
		}
		
		brandCompanysPageInfo.setCompanys(companys);
		brandCompanysPageInfo.setCount(count);
		return brandCompanysPageInfo;
	}
	
	

	/**
	 * 当前品牌下的所有商品
	 */
	@Override
	public PageResponse<GoodDto> queryGoodsUpBrand(String brandUuid,
			PageRequest pageRequest) {
		List<GoodDto> GoodList = new ArrayList<GoodDto>();
		int totalCount=brandDao.queryGoodsUpBrandIdCount(brandUuid);
		List<GoodDto> goodsList = brandDao.queryGoodsUpBrandId(brandUuid,pageRequest.getPageNum(),pageRequest.getPageSize());
		if (goodsList != null && goodsList.size() > 0) {
			for (GoodDto goodDto : goodsList) {
				/*List<SkuInfoPojo> skuInfoPojoList = brandDao
						.querySkuInfoBySkuId(goodDto.getSkuUuid());
				List<GoodsInfoPojo> goodsInfoPojoList = brandDao.queryGoodsInfo(goodDto.getGoodsUuid());
				
				goodDto.setSkuInfoPojo(skuInfoPojoList);
				goodDto.setGoodsInfoPojo(goodsInfoPojoList);*/
				GoodList.add(goodDto);
			}
		}
		PageResponse<GoodDto> PageResponse = new PageResponse<GoodDto>();
		PageResponse.setTotalCounts(totalCount);
		PageResponse.setT(GoodList);
		PageResponse.setPageNum(pageRequest.getPageNum());
		PageResponse.setPageSize(pageRequest.getPageSize());
		return PageResponse;
	}

	/**
	 * 品牌商品：点击标题→商品详情页
	 * 
	 * @param brandId
	 * @return
	 */
	@Override
	@Transactional
	public List<GoodsInfoDto> queryProductDetails(String goodsUuid) {
		
		GoodsInfoDto goodsInfoDto = brandDao.querySkuDetails(goodsUuid);
		String skuUuid = goodsInfoDto.getSkuUuid();

		List<SkuInfoPojo> skuInfoPojo = brandDao.querySkuInfo(skuUuid);
		
		
		
			goodsInfoDto.setSkuInfoPojo(skuInfoPojo);
			
			
		
		return null;
	}

	/**
	 * 查询同类商品
	 */
	@Transactional
	public List<GoodDto> querySimilarGoods(String kindUuid) {
		
		List<GoodDto> goodList = new ArrayList<GoodDto>();
		GoodDto goodDto = null;
		List<GoodDto> kindGoodsUuidList = this.brandDao.queryGoodsUuidByKindUuid(kindUuid);
		for (GoodDto goodDto1 : kindGoodsUuidList) {
			goodDto= new GoodDto();
			
			List<GoodDto> goodsList = this.brandDao.querySimilarGoods(goodDto1.getGoodsUuid());
			if (goodsList != null && goodsList.size() > 0) {
				for (GoodDto goodDto2 : goodsList) {
					/*List<SkuInfoPojo> skuInfoPojoList = brandDao
							.querySkuInfoBySkuUuid(goodDto2.getSkuUuid());
				List<GoodsInfoPojo> goodsInfoPojoList = brandDao.queryGoodsInfo(goodDto2.getGoodsUuid());*/
					goodDto.setSkuUuid(goodDto2.getSkuUuid());
					goodDto.setGoodsUuid(goodDto2.getGoodsUuid());
					goodDto.setBrandName(goodDto2.getBrandName());
					goodDto.setCompany(goodDto2.getCompany());
					goodDto.setCompanyUuid(goodDto2.getCompanyUuid());
					goodDto.setTitle(goodDto2.getTitle());
					goodDto.setName(goodDto2.getName());
					goodDto.setSize(goodDto2.getSize());
					goodDto.setMaterial(goodDto2.getMaterial());
					goodDto.setBrandUuid(goodDto2.getBrandUuid());
					goodDto.setImage(goodDto2.getImage());
					goodDto.setSkuvalue(goodDto2.getSkuvalue()+"");
					goodDto.setGoodsvalue(goodDto2.getGoodsvalue()+"");
				}
			}
			goodList.add(goodDto);
		}
		return goodList;
	}

	/**
	 * 品牌商品：右侧边栏同类供应商
	 * 
	 * @param brandId
	 * @return companyDtoList
	 */
	@Override
	public List<CompanyDto> queryCompanyUpBrandId(String brandUuid) {
		List<CompanyDto> companyDtoList = brandDao
				.queryCompanyUpBrandId(brandUuid);
		if (companyDtoList == null || companyDtoList.size() <= 0)
			return null;
		return companyDtoList;
	}

	/**
	 * 品牌商品：右侧边栏相关类别
	 * 
	 * @param （无参）
	 * @return String
	 */
	@Override
	public List<KindPojo> queryKingPojo12UpGoods() {
		List<KindPojo> kindPojoList = brandDao.queryKingPojo12UpGoods();
		if (kindPojoList == null || kindPojoList.size() <= 0)
			return null;
		return kindPojoList;
	}

	/**
	 * 品牌商品：右侧边栏同类供应商(未入驻)
	 * 
	 * @param brandId
	 * @return companyDtoList
	 */
	@Override
	public List<CompanyDto> queryUnCompanyUpBrandId(String brandUuid) {
		List<CompanyDto> companyDtoList = brandDao
				.queryUnCompanyUpBrandId(brandUuid);
		if (companyDtoList == null || companyDtoList.size() <= 0)
			return null;
		return companyDtoList;
	}

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
	@Override
	public List<BrandPojo> queryBrandsList(BrandPojo brandPojo, int PageNum,
			int PageSize) {
		List<BrandPojo> brandsList=brandDao.queryBrandsList(brandPojo,PageNum,PageSize);
		if(brandsList!=null&&brandsList.size()>0)
			 return brandsList;
		return null;
	}
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
	@Override
	public BrandMainPageInfo queryBrandMainPageInfo(BrandVo requestParam) {
		BrandMainPageInfo mainInfo=new BrandMainPageInfo();
		//查询当前品牌下鲸工入驻的供应商数量
		int enteringSupplierNum = this.queryBrandCounts(requestParam.getBrandUuid());
		//当前品牌已询价的次数（按单商品计算）
		int enquiryNum=	this.queryInqueriedCounts(requestParam.getBrandUuid());
		//TODO  撮合订单数 暂无数据来源
		mainInfo.setOrderNum(88);
		//品牌介绍
		BrandPojo brandPojo = this.queryBrandInfoByBrandUuid(requestParam.getBrandUuid());
		//TODO 品牌感兴趣/采购过计数(暂无数据来源)
		mainInfo.setBrandPojo(brandPojo);
		mainInfo.setEnquiryNum(enquiryNum);
		mainInfo.setEnteringSupplierNum(enteringSupplierNum);
		
		//品牌感兴趣/采购过计数(暂无数据来源) 默认为0
		mainInfo.setInterestedNum(0);
		mainInfo.setPurchasedNum(0);
		return mainInfo;
	}

	private BrandPojo queryBrandInfoByBrandUuid(String brandUuid) {
		return brandDao.queryBrandInfoByBrandUuid(brandUuid);
	}
}
