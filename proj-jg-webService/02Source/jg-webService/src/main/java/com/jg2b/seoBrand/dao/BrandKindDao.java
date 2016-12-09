package com.jg2b.seoBrand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jg2b.seoDto.BrandListDto;
import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.KindCompanyDto;
import com.jg2b.seoPojo.CompanyPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.seoPojo.KindPojo;

public interface BrandKindDao {
	/**
	 * 查询当前分类 鲸工入驻的供应商数量（未入住的供应商数量 ）
	 * @param kindUuid
	 * @param status
	 * @return
	 */
	int queryCompanyCountUdKingId(String kindUuid,int status);
	/**
	 * 当前分类 已询价的次数
	 * @param kindUuid
	 * @return
	 */
	int queryInqueryUdKingId(String kindUuid);
	/**
	 * 当前分类 已撮合的报价次数(返回参数随机)
	 * @param kindUuid
	 * @return
	 */
	int queryHaveMatch(String kindUuid);
	 
	/**
	 * 当前分类 采集库中 供应商最多的3个品牌显示
	 * @param kindUuid
	 * @return
	 */
     List<KindCompanyDto> queryCompanyListByKind(String kindUuid);
   
     /**
      * 分类商品分页
      * @param kindUuid
      * @return
      */
     List<GoodsInfoDto> queryKindGood(@Param("kindUuid")String kindUuid,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
    
     /**
      * 分类商品分页
      * @param kindUuid
      * @return
      */
     int queryKindGoodCounts(String kindUuid);
     /**
      * 分类供应商
      * @param kindUuid
     * @param rowNum 
     * @param page 
      * @return
      */
     List<CompanyDto> queryCompanyUpKind(String kindUuid,Integer page,Integer rowNum);
     /**
      * 分类供应商
      * @param kindUuid
      * @return
      */
     List<CompanyDto> queryCompanyUpKind(String kindUuid);
     /**
      * 
      * @param kindUuid
     * @param PageNum
     * @param PageSize 
      * @return
      */
	List<BrandListDto> queryBrandByKind(String kindUuid, int PageNum,
			int PageSize);
	/**
	 * 查询分类品牌总页数
	 * @param kindUuid
	 * @return
	 */
	int queryTotalCounts(String kindUuid);
	/**
	 * 查询当前品牌供应商总数
	 * @param brandUuid
	 * @return
	 */
	int queryBrandCount(String brandUuid);
	/**
	 * 查询当前品牌商品询价总次数
	 * @param brandUuid
	 * @return
	 */
	int queryInqueriedCounts(String brandUuid);
	/**
	 * 查询品牌信息
	 * @param brandUuid
	 * @return
	 */
	List<BrandListDto> queryBrandDetails(String brandUuid);
	/**
	 * 查询供应商信息
	 * @param companyUuid
	 * @return
	 */
	List<CompanyPojo> queryCompany(String companyUuid);
	
	/**
	 * 供应商列表总数
	 * @param kindUuid
	 * @return
	 */
	int queryCompanyUpKindCounts(String kindUuid);
	/**
	 * 根据供应商UUid查询商品 两个
	 * @param companyUuid
	 */
	List<GoodsPojo> queryGoodsBycompanyUuid(String companyUuid);
	/**
	 * <p>根据kindUuid查询分类详细</p>
	 * 
	 * @param kindUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月30日 下午7:16:07
	 */
	KindPojo queryKindPojoByKindUuid(String kindUuid);	
     
    
     
     
     
     
     
     
     
     
	 
	
	
	
	
	
	

}
