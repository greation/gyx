package com.jg2b.h5.service.impl;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.h5.dao.CircleDao;
import com.jg2b.h5.dao.CompanyDao;
import com.jg2b.h5.dto.CircleDto;
import com.jg2b.h5.dto.ProductDto;
import com.jg2b.h5.pojo.BrandPojo;
import com.jg2b.h5.pojo.ProductPojo;
import com.jg2b.h5.service.CircleService;
import com.jg2b.utils.PageRequest;
@Service
public class CircleServiceImpl implements CircleService{
	@Autowired
	private CircleDao circleDao;
	
	@Autowired
	private CompanyDao companyDao;
	/**
	 * 查询商圈信息
	 */
	@Override
	public List<CircleDto> queryCircleInfo(PageRequest pageRequest) {
		
		return  this.circleDao.queryCircleInfo(pageRequest.getStartIndex(),pageRequest.getPageSize());
		
	}
	/**
	 *  查询我发布的产品列表
	 */
	public List<ProductPojo> queryReleaseProductInfo(Integer user_id,PageRequest pageRequest) {
		List<ProductPojo> productList = this.circleDao.queryReleaseProductInfo(user_id,pageRequest.getStartIndex(),pageRequest.getPageSize());
		if (CollectionUtils.isNotEmpty(productList)){
			return productList;
		}
		return null;
	}
	
	/**
	 * 逻辑删除我发布的产品
	 */
	@Override
	public int updateProdel(Integer id) {
		int i  = this.circleDao.updateProdel(id);
		return i;
	}
	/**
	 * 查询我代理的品牌
	 */
	@Override
	public List<BrandPojo> queryBrandName(Integer user_id) {
			List<BrandPojo> brandPojoList = this.circleDao.queryBrandName(user_id);
		if(CollectionUtils.isNotEmpty(brandPojoList)){
			return brandPojoList;
		}
		return null;
	}
	/**
	 * 发布产品
	 */
	@Override
	public int releaseProduct(ProductDto productDto,Integer userId) {
		if(this.circleDao.queryCircleId(userId)==null){
			return 0;	
		}
		productDto.setUser_id(userId);
		productDto.setCircle_id(this.circleDao.queryCircleId(userId));
		productDto.setAdd_time((int)(System.currentTimeMillis()/1000));
		int i = this.circleDao.releaseProduct(productDto);
		return i;
	}
}
