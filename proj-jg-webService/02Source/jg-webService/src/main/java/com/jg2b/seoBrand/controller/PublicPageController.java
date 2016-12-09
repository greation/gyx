package com.jg2b.seoBrand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.seoBrand.service.CompanyService;
import com.jg2b.seoBrand.service.GoodsService;
import com.jg2b.seoBrand.service.PublicPageService;
import com.jg2b.seoDto.Response.GoodDetailsPageInfo;
import com.jg2b.seoDto.Response.Response;
import com.jg2b.seoDto.Response.ResultResponse;
import com.jg2b.seoPojo.CompanyInfoPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.vo.CompanyVo;
import com.jg2b.vo.GoodsVo;

/**
 * <p>[描述信息：门户页面 公共模块控制器]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 下午5:41:57
 */
@Controller
@RequestMapping("/publicPage")
public class PublicPageController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(PublicPageController.class);  
	/**
	 * 门户页面 公共模块service
	 */
	@Autowired
	private PublicPageService publicPageService;
	/**
	 * 供应商service
	 */
	@Autowired
	private CompanyService companyService;
	/**
	 * 商品service
	 */
	@Autowired
	private GoodsService goodsService;
    
	/**
	 *商品详情页
	 *	商品详情
	 *	所属供应商及信息
	 *	其它同类商品：当前商品所属分类的下的其它商品，（10条）
	 * @param requestParam
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午8:01:00
	 */
	@RequestMapping(value = "/queryGoodDetailsPage", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryGoodDetailsPage(@RequestBody GoodsVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null||StringUtils.isEmpty(requestParam.getGoodsUuid())) {
			LOGGER.error("商品详情页请求参数异常:"+requestParam.toString());
			response.setState(Response.ErrorState);
			response.setMessage("必要参数不能为空");
			return response;
		}
		try {
			GoodDetailsPageInfo details=publicPageService.queryGoodDetailsPage(requestParam.getGoodsUuid());
			response.setData(details);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("商品详情页请求异常:"+requestParam.toString(),e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	/**
	 *供应商详情页
	 *	供应商详情
	 *	供应商包含“鲸工入驻供应商”“未入驻供应商”，已入驻的需特别标明；
	 *	我是供货商？→JG2B供应商入住页
     *
	 * @param requestParam
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午8:01:00
	 */
	@RequestMapping(value = "/queryCompanyDetailsPage", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryCompanyDetailsPage(@RequestBody CompanyVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null||StringUtils.isEmpty(requestParam.getCompanyUuid())) {
			LOGGER.error("供应商详情页请求参数异常:"+requestParam.toString());
			response.setState(Response.ErrorState);
			response.setMessage("必要参数不能为空");
			return response;
		}
		try {
			CompanyInfoPojo queryParam=new CompanyInfoPojo();
			queryParam.setCompanyUuid(requestParam.getCompanyUuid());
			CompanyInfoPojo companyInfo=companyService.queryCompanyInfoByUuid(queryParam);
			response.setData(companyInfo);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("供应商详情页请求异常",e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	/**
	 *供应商详情页面
	 *		供应商下的产品 (3个)
	 * @param requestParam
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年6月27日 下午8:01:00
	 */
	@RequestMapping(value = "/queryCompanyGoodsPage", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryCompanyGoodsPage(@RequestBody CompanyVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null||StringUtils.isEmpty(requestParam.getCompanyUuid())) {
			LOGGER.error("供应商详情页[供应商下的产品 ]请求参数异常:"+requestParam.toString());
			response.setState(Response.ErrorState);
			response.setMessage("必要参数不能为空");
			return response;
		}
		try {
			List<GoodsPojo>goodsList= goodsService.queryGoodsByCompanyUuid(requestParam.getCompanyUuid(),
					new Integer(3),new Integer(0));
			response.setData(goodsList);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("供应商详情页[供应商下的产品 ]请求",e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
