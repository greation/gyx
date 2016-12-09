package com.jg2b.seoBrand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.seoBrand.service.BrandKindService;
import com.jg2b.seoDto.BrandListDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.KindCompanyDto;
import com.jg2b.seoDto.Response.BrandCompanysKindInfo;
import com.jg2b.seoDto.Response.BrandMainPageInfo;
import com.jg2b.seoDto.Response.KindGoodsPageInfo;
import com.jg2b.seoDto.Response.Response;
import com.jg2b.seoDto.Response.ResultResponse;
import com.jg2b.utils.PageResponse;
import com.jg2b.vo.KindPageVo;

/**
 * <p>[描述信息：门户页面 分类模块控制器]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年6月27日 下午5:41:30
 */
@Controller
@RequestMapping("/kindPage")
public class KindPageContronller {

	@Autowired
	private BrandKindService brandKindService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(KindPageContronller.class);  
	
	/**
	  　　品牌包含“鲸工入驻品牌”“未入驻品牌”，已入驻的需特别标明；
	  　　　　　品牌下供应商、商品调用，最多两条（没有则不显示），点击可查看详情；
	  　　询价→JG2B询价单商品发布页
	 * 分类下的品牌分类 15条
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/queryBrandInfo",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody 
	public 
	ResultResponse queryBrandInfo(@RequestBody KindPageVo requestParam
		) {
		ResultResponse response=new ResultResponse();
		try {	
			// 每一次请求页码和每页记录数
			PageResponse<BrandListDto> pageResponse = brandKindService
				.queryBrandDetails(requestParam.getKindUuid(), requestParam.getPageRequest());
			response.setData(pageResponse);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("分类下的品牌分类（15条）异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}


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
	 * @param requestParam(品牌ID)
	 * @return
	 */
	@RequestMapping(value = "/queryKindMainPageInfo", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryKindMainPageInfo(@RequestBody KindPageVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			BrandMainPageInfo mainInfo=brandKindService.queryKindMainPageInfo(requestParam);
			response.setData(mainInfo);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询当前品牌下鲸工入驻的供应商数量异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
    
	
	/**
	 * 
	 * 当前分类 采集库中 供应商最多的3个品牌显示
	 * @param kindUuid
	 * @return
	 */
	
	@RequestMapping(value = "/queryCompanyListByKind", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryCompanyListByKind(@RequestBody KindPageVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			List<KindCompanyDto> CompanyList=brandKindService.queryCompanyListByKind(requestParam.getKindUuid());
			response.setData(CompanyList);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询当前品牌下鲸工入驻的供应商数量异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	
	/**
	 * 分类下的商品分类 15条
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/queryKindGood",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody 
	public 
	ResultResponse queryKindGood(@RequestBody KindPageVo requestParam
		) {
		ResultResponse response=new ResultResponse();
		try {	
			// 每一次请求页码和每页记录数
			KindGoodsPageInfo kindGoodsPageInfo = brandKindService
				.queryKindGood(requestParam.getKindUuid(), requestParam.getPageRequest());
			response.setData(kindGoodsPageInfo);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("分类下的品牌分类（15条）异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}


	}
	
	/**
	 * @function 查询当前分类下的供应商
	 * @param brand_id
	 * @param request
	 * @return ResultResponse
	 * @author gongjp
	 * @date  2016-06-29 下午 16:37:21
	 */
	@RequestMapping(value = "/queryCompanyUpKind", method = RequestMethod.POST)
	public @ResponseBody ResultResponse queryCompanyUpKind(@RequestBody KindPageVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam.getPageRequest() ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {	
			// 每一次请求页码和每页记录数
			BrandCompanysKindInfo pageResponse = brandKindService.queryCompanyUpKind(requestParam.getKindUuid(), requestParam.getPageRequest());
			response.setData(pageResponse);
			response.setState(Response.IsOkState);
			response.setMessage("success");
			return response;
		} catch (Exception e) {
			LOGGER.error("分类供应商分页（15条）异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	
}
