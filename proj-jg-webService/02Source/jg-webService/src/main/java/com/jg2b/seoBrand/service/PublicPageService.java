package com.jg2b.seoBrand.service;

import com.jg2b.seoDto.Response.GoodDetailsPageInfo;


/**
 * <p>[描述信息：门户页面:公共模块页面相关接口]</p>
 *	
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 上午9:58:14
 */
public interface PublicPageService {

	/**
	 * <p>功能实现描述</p>
	 * 
	 * @param goodsUuid
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月30日 下午2:39:48
	 */
	GoodDetailsPageInfo queryGoodDetailsPage(String goodsUuid);
	
}
