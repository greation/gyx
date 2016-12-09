package com.jg2b.h5.dao;

import java.util.List;

import com.jg2b.h5.dto.CircleDto;
import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.ProductDto;
import com.jg2b.h5.pojo.BrandPojo;
import com.jg2b.h5.pojo.CirclePojo;
import com.jg2b.h5.pojo.CompanyPagePojo;
import com.jg2b.h5.pojo.ProductPojo;
import com.jg2b.h5.vo.CompanyPageVo;
/**
 * 
* @ClassName: CircleDao 
* @Description: 商圈和发布商品
* @author bianchenglong
* @date 2016年7月4日 下午7:10:11 
*
 */

public interface CircleDao {
	/**
	 * 查询商圈信息
	 * @return
	 *@author bianchenglong
	 * @param pageNum
	 * @param pageSize
	 */
	List<CircleDto> queryCircleInfo(int pageNum,int pageSize);
	
	/**
	 *  查询我发布的产品信息列表 
	 * @param user_id
	 * @return
	 *@author bianchenglong
	 * @param pageSize 
	 * @param pageNum 
	 */
	List<ProductPojo> queryReleaseProductInfo(Integer user_id, int pageNum, int pageSize);
	/**
	 * 逻辑删除我发布的产品信息
	 * @param id
	 * @return
	 *@author bianchenglong
	 */
	int updateProdel(Integer id);
	/**
	 * 发布商品 ---> 品牌  查询我代理的品牌名称
	 * @param user_id
	 * @return
	 *@author bianchenglong
	 */
	List<BrandPojo> queryBrandName(Integer user_id);
	/**
	 * 发布产品
	 * @param productDot
	 * @return
	 *@author bianchenglong
	 */
	int releaseProduct(ProductDto productDot);
	/**
	 * 根据id查询商圈id
	 * @param user_id
	 * @return
	 *@author bianchenglong
	 */
	Integer queryCircleId(Integer user_id);
	
	
	/**
	 *  查询我所在的商圈信息
	 * @param userId
	 * @return
	 *@author bianchenglong
	 */
	List<CirclePojo> queryCircleByUserId(Integer userId);

	List<ProductPojo> queryProductsByCompanyIdForPage(CompanyPageVo vo);
	
}
