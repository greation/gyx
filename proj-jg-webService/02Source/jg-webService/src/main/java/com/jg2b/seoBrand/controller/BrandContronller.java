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

import com.jg2b.seoBrand.service.BrandService;
import com.jg2b.seoBrand.service.GoodsService;
import com.jg2b.seoDto.BrandDto;
import com.jg2b.seoDto.CompanyDto;
import com.jg2b.seoDto.GoodDto;
import com.jg2b.seoDto.GoodsInfoDto;
import com.jg2b.seoDto.Response.BrandCompanysPageInfo;
import com.jg2b.seoDto.Response.BrandMainPageInfo;
import com.jg2b.seoDto.Response.Response;
import com.jg2b.seoDto.Response.ResultResponse;
import com.jg2b.seoPojo.BrandPojo;
import com.jg2b.seoPojo.GoodsPojo;
import com.jg2b.utils.PageRequest;
import com.jg2b.utils.PageResponse;
import com.jg2b.vo.BrandPageVo;
import com.jg2b.vo.BrandVo;
@Controller
@RequestMapping("/brand")
public class BrandContronller {

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private GoodsService goodsService;

	private static Logger LOGGER = LoggerFactory.getLogger(BrandContronller.class);  
    
	
	
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
	@RequestMapping(value = "/queryBrandMainPageInfo", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryBrandMainPageInfo(@RequestBody BrandVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			BrandMainPageInfo mainInfo=brandService.queryBrandMainPageInfo(requestParam);
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
	 * 查询当前品牌下鲸工入驻的供应商数量
	 * 
	 * @name(品牌ID)
	 * @return
	 */
	@RequestMapping(value = "/queryBrandCounts", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryBrandCounts(@RequestBody BrandVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");

			return response;
		}
		try {
			int count = brandService.queryBrandCounts(requestParam.getBrandUuid());
			response.setData(count);
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
	 * 当前品牌已询价的次数（按单商品计算）
	 * 
	 * @name(品牌ID)
	 * @return
	 */
	@RequestMapping(value = "/queryInqueriedCounts", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryInqueriedCounts(@RequestBody BrandVo requestParam) {
		ResultResponse response=new ResultResponse();
		if (requestParam ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			int inqueriedCount=	brandService.queryInqueriedCounts(requestParam.getBrandUuid());
			response.setData(inqueriedCount);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("当前品牌已询价的次数（按单商品计算）异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 品牌介绍：有内容就显示，点击更多查看详情页；若无内容则不显示
	 * 
	 * @param brandId
	 * @return
	 */
	@RequestMapping(value = "/queryBrandInfos", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryBrandInfos(@RequestBody BrandVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam == null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			String brandUuid = requestParam.getBrandUuid();
			List<BrandDto> brandList = this.brandService
					.queryBrandInfos(brandUuid);
			response.setData(brandList);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("品牌介绍：有内容就显示，点击更多查看详情页；若无内容则不显示异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 查询当前品牌下的供应商
	 * @param brand_id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryBrandMerchantsInfo",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryBrandMerchantsInfo(@RequestBody BrandPageVo requestParam
		) {
		ResultResponse response=new ResultResponse();
		try {	
			// 每一次请求页码和每页记录数
			BrandCompanysPageInfo pageResponse = brandService
				.queryCompanysBybranId(requestParam.getBrandUuid(), requestParam.getPageRequest());
			response.setData(pageResponse);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("品牌商家分页（15条）异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}


	}

	/**
	 * 品牌商品：点击标题→商品详情页
	 * 
	 * @param brandId
	 * @return
	 */
	@RequestMapping(value = "/queryProductDetails", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryProductDetails(@RequestBody BrandVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam == null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}

		try {
			String goodsUuid = requestParam.getGoodsUuid();
			List<GoodsInfoDto> queryProductDetails = this.brandService
					.queryProductDetails(goodsUuid);
			response.setState(Response.IsOkState);
			response.setData(queryProductDetails);
			return response;
		} catch (Exception e) {
			LOGGER.error("品牌商品：点击标题→商品详情页异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}

	}

	/**
	 * 品牌商品分页（15条）
	 * 
	 */
	@RequestMapping(value = "/queryGoodsUpBrand", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse queryGoodsUpBrand(@RequestBody BrandPageVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(Response.ErrorState);
			response.setMessage("参数无效");
			return response;
		}
		try {
			PageRequest pageRequest = new PageRequest();
			// 每一次请求页码和每页记录数
			PageResponse<GoodDto> pageResponse = brandService
					.queryGoodsUpBrand(requestParam.getBrandUuid(), requestParam.getPageRequest());
			
			response.setData(pageResponse);
			response.setState(Response.IsOkState);
			return response;

		} catch (Exception e) {
			LOGGER.error("品牌商品分页异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 查询同类商品
	 * @param requestParam
	 * @return
	 */
	@RequestMapping(value = "/querySimilarGoods", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse querySimilarGoods(
			@RequestBody BrandVo requestParam) {
		ResultResponse response = new ResultResponse();

		if (requestParam == null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}

		try {
			String kindUuid = requestParam.getKindUuid();
			List<GoodDto> similarGoodsList = this.brandService
					.querySimilarGoods(kindUuid);
			if (similarGoodsList != null) {
				response.setData(similarGoodsList);
				response.setState(Response.IsOkState);
				return response;
			}

			response.setState(Response.IsOkState);
			response.setMessage("无数据");
			return response;

		} catch (Exception e) {
			LOGGER.error("查询同类商家异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 查询品牌下右侧边栏同类供应商（入驻）
	 */
	@RequestMapping(value = "/queryCompanyUpBrandId", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse queryCompanyUpBrandId(@RequestBody BrandVo requestParam) {

		ResultResponse response = new ResultResponse();

		if (requestParam == null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}

		try {

			List<CompanyDto> result = this.brandService
					.queryCompanyUpBrandId(requestParam.getBrandUuid());
			response.setData(result);
			response.setState(Response.IsOkState);
			return response;

		} catch (Exception e) {
			LOGGER.error("查询品牌下右侧边栏同类供应商[入驻]异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 商品相关类别-相关类别（随机）
	 */
	@RequestMapping(value = "/queryKingPojo12UpGoods", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse queryKingPojo12UpGoods() {
		ResultResponse response = new ResultResponse();
		try {
			response.setState(Response.IsOkState);
			response.setData(this.brandService.queryKingPojo12UpGoods());
		} catch (Exception e) {
			LOGGER.error("商品相关类别-相关类别（随机）异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
		return response;
	}

	/**
	 * 查询品牌下右侧边栏同类供应商（未入驻）
	 */
	@RequestMapping(value = "/queryUnCompanyUpBrandId", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse queryUnCompanyUpBrandId(@RequestBody BrandVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam==null) {
			response.setState(Response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			List<CompanyDto> companyDtoList = this.brandService
					.queryUnCompanyUpBrandId(requestParam.getBrandUuid());
			response.setData(companyDtoList);
			response.setState(Response.IsOkState);
			return response;

		} catch (Exception e) {
			LOGGER.error("查询品牌下右侧边栏同类供应商[未入驻]异常", e);
			response.setState(Response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	/**
	 * 随机查询相关品牌
	 */
	@RequestMapping(value = "/queryBrandsList", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse queryBrandsList() {
		ResultResponse response = new ResultResponse();
		try {
			List<BrandPojo> brands=brandService.queryBrandsList(null, 0,12);
			response.setData(brands);
			response.setState(Response.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("随机查询相关品牌异常", e);
			response.setState(Response.ErrorState);
			response.setMessage("系统异常");
			return response;
		}
	}
}
