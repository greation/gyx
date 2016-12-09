package com.jg2b.h5.service;

import java.util.List;

import com.jg2b.h5.dto.CircleDto;
import com.jg2b.h5.dto.ProductDto;
import com.jg2b.h5.pojo.BrandPojo;
import com.jg2b.h5.pojo.ProductPojo;
import com.jg2b.utils.PageRequest;


public interface CircleService {
/**
 * 查询商圈信息
 * @param pageRequest 
 * @return
 */
	List<CircleDto> queryCircleInfo(PageRequest pageRequest);
	/**
	 * 查询我的发布的产品信息 列表
	 * @param user_id
	 * @param pageRequest 
	 * @return
	 */

	List<ProductPojo> queryReleaseProductInfo(Integer user_id, PageRequest pageRequest);

	/**
	 * 逻辑删除我的发布的产品信息 列表
	 * @param id
	 * @return
	 */
	int updateProdel(Integer id);
	/**
	 * 根据输入商品名称模糊查询品牌
	 * @param integer
	 * @return
	 */
	List<BrandPojo> queryBrandName(Integer user_id);
	/**
	 * 发布产品
	 * @param prodictDot
	 * @return
	 *@author bianchenglong
	 * @param user_id 
	 */
	int releaseProduct(ProductDto productDto, Integer userId);

}
