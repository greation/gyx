package com.jg2b.h5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jg2b.h5.conts.BaseConts;
import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.UserDetailDto;
import com.jg2b.h5.pojo.Category;
import com.jg2b.h5.pojo.CompanyPagePojo;
import com.jg2b.h5.pojo.UserPojo;
import com.jg2b.h5.respons.ResultResponse;
import com.jg2b.h5.service.CategoryService;
import com.jg2b.h5.service.CircleService;
import com.jg2b.h5.service.CompanyService;
import com.jg2b.h5.service.UserService;
import com.jg2b.h5.vo.CategoryVo;
import com.jg2b.h5.vo.CompanyPageVo;
import com.jg2b.h5.vo.CircleVo;
import com.jg2b.h5.vo.ContactVo;
import com.jg2b.h5.vo.MainPageQueryVo;
import com.jg2b.h5.vo.ReleaseVo;
import com.jg2b.h5.vo.CompanyVo;
import com.jg2b.h5.vo.UserVo;
import com.jg2b.utils.PageRequest;

/**
 * <p>[描述信息：商家控制器  包括品牌、品类、商圈接口在内]</p>
 *
 * @author 刘毅 
 * @version 1.0 Created on 2016年7月4日 下午3:48:57
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CircleService circleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CompanyService companyService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(CompanyController.class); 
	
	
	/**
	 * 查询父类品类
	 *  @param requestParam
	 *  @return
	 */
	@RequestMapping(value = "/queryTopCategoryInfo.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryTopCategoryInfo (){
		ResultResponse response = new ResultResponse();
		try {
			List<Category> topCategoryList=categoryService.queryTopCategoryInfo();
			response.setData(topCategoryList);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询父类品类异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	/**
	 * 查询父类品类下的子类品类
	 *  @param requestParam
	 *  @return
	 */
	@RequestMapping(value = "/queryChildCategoryInfo.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryChildCategoryInfo (@RequestBody CategoryVo requestParam){
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			List<Category> childCategoryList=categoryService.queryChildCategoryInfo(requestParam.getTopid());
			response.setData(childCategoryList);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询父类品类下的子类信息异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	
	/**
	 * 查询商圈信息
	 * @return
	 *@author bianchenglong
	 */
	@RequestMapping(value = "/queryCircleInfo.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryCircleInfo(@RequestBody CircleVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null) {
			response.setState(response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		
		try {
			response.setState(response.IsOkState);
			response.setData(this.circleService.queryCircleInfo(requestParam.getPageRequest()));
			return response;
		} catch (Exception e) {
			LOGGER.error("查询商圈信息", e);
			response.setState(response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	
	/**
	 * 查询我发布的产品详细
	 * @param requestParam
	 * @return
	 *@author bianchenglong
	 */
	@RequestMapping(value = "/queryReleaseProductInfo.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryReleaseProductInfo(@RequestBody ReleaseVo requestParam, HttpServletRequest request) {
	UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
		ResultResponse response = new ResultResponse();
	if (userPojo ==null||requestParam == null) {
		response.setState(response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			LOGGER.info("查询我发布的产品详细");
			response.setState(response.IsOkState);
			response.setData(this.circleService.queryReleaseProductInfo(userPojo.getUserId(),requestParam.getPageRequest()));
			//response.setData(this.circleService.queryReleaseProductInfo(11465));
			return response;
		} catch (Exception e) {
			LOGGER.error("查询我发布的产品详细", e);
			response.setState(response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	/**
	 * 逻辑删除  我发布的产品
	 * @param requestParam
	 * @return
	 *@author bianchenglong
	 */
	@RequestMapping(value = "/deleteReleaseProduct.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse updateProdel(@RequestBody ReleaseVo requestParam) {
		ResultResponse response = new ResultResponse();
		if (requestParam ==null||StringUtils.isEmpty(requestParam.getId())) {
			response.setState(response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			LOGGER.info("逻辑删除  我发布的产品信息");
			int i = this.circleService.updateProdel(requestParam.getId());
			if(i==1){
			response.setState(response.IsOkState);
			response.setData(true);
			}else{
				response.setState(response.IsOkState);
				response.setData(false);
			}
			return response;
		} catch (Exception e) {
			LOGGER.error("逻辑删除  我发布的产品信息", e);
			response.setState(response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	
	
	/**
	 * <p>用户注册</p>
	 * 
	 * @param requestParam
	 * @author:刘毅 
	 * @date: Created on 2016年7月4日 下午12:00:34
	 */
	@RequestMapping(value = "/userRegistered.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse userRegistered(@RequestBody UserVo requestParam) {
		ResultResponse response =new ResultResponse();
		LOGGER.info("注册开始");
	try {	
		// 每一次请求页码和每页记录数
		int a=userService.userRegistered(requestParam.getUserDto());
		response.setData(a);
		response.setState(ResultResponse.IsOkState);
		return response;
	} catch (Exception e) {
		LOGGER.error("品牌商家分页（15条）异常", e);
		response.setState(ResultResponse.ErrorState);
		response.setMessage(e.getMessage());
		return response;
	}
	}
	
	
	/**
	 * <p>注册信息</p>
	 * 
	 * @param requestParam
	 * @author:张鹏
	 * @date: Created on 2016年7月4日 下午12:00:34
	 */
	@RequestMapping(value = "/companyRegistered.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse companyRegistered(@RequestBody CompanyVo requestParam) {
		ResultResponse response =new ResultResponse();
		LOGGER.info("注册开始");
	try {	
		// 每一次请求页码和每页记录数
		int a=userService.companyRegistered(requestParam.getCompanyDto());
		response.setData(a);
		response.setState(ResultResponse.IsOkState);
		return response;
	} catch (Exception e) {
		LOGGER.error("品牌商家分页（15条）异常", e);
		response.setState(ResultResponse.ErrorState);
		response.setMessage(e.getMessage());
		return response;
	}
	}
	
	
	
	/**
	 * 发布商品 ---> 品牌  查询我代理的品牌名称
	 * @param requestParam
	 * @return
	 *@author bianchenglong
	 */

	@RequestMapping(value = "/queryBrandName.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryBrandName(HttpServletRequest request) {
		UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
		
		ResultResponse response = new ResultResponse();
		if (userPojo ==null) {
			response.setState(response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			response.setState(response.IsOkState);
			response.setData(this.circleService.queryBrandName(userPojo.getUserId()));
			return response;
		} catch (Exception e) {
			LOGGER.error("发布商品 ---> 品牌  查询我代理的品牌名称", e);
			response.setState(response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	/**
	 * 查询最近联系的公司详情
	 * @param request
	 * @author liucongcong
	 * @return
	 * 2016年7月5日
	 */
	@RequestMapping(value = "/queryRecentCompanyDto.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryRecentCompanyDto (@RequestBody ContactVo requestParam,HttpServletRequest request){
		ResultResponse response = new ResultResponse();
		UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
		try {
			List<CompanyDto> companyDtoList=companyService.queryCompanyDto(userPojo.getUserId(),requestParam.getPageRequest());
			response.setData(companyDtoList);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询最近联系的公司详情", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	/**
	 * 增加用户最近联系
	 * @param requestParam
	 * @param request
	 * @return
	 * 2016年7月5日
	 */
	@RequestMapping(value = "/insertRecentContact.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse insertRecentContact (@RequestBody ContactVo requestParam,HttpServletRequest request){
		ResultResponse response = new ResultResponse();
		UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
		try {
			requestParam.setUserId(userPojo.getUserId());
			int a=companyService.insertContact(requestParam);
			response.setData(a);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("增加用户最近联系", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	

	
	
	/**
	 * 发布商品
	 * @param requestParam
	 * @return
	 *@author bianchenglong
	 */

	@RequestMapping(value = "/releaseProduct.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse releaseProduct(@RequestBody ReleaseVo requestParam,HttpServletRequest request) {
		UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
		Integer userId = null;
		if(userPojo != null){
				userId = userPojo.getUserId();
		}
		ResultResponse response = new ResultResponse();
		if (userPojo ==null) {
			response.setState(response.ErrorState);
			response.setMessage("无效参数");
			return response;
		}
		try {
			int i= this.circleService.releaseProduct(requestParam.getProductDto(),userId);
			if(i == 1){
				response.setState(response.IsOkState);
				response.setData(true);
			}else{
				response.setState(response.IsOkState);
				response.setData(false);
			}
			return response;
		} catch (Exception e) {
			LOGGER.error("发布商品 ---> 品牌  查询我代理的品牌名称", e);
			response.setState(response.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	/**
	 * 主要搜索页
	 * @param requestParam
	 * @return
	 */

	@RequestMapping(value = "/queryCompanyMainSearch.do", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse queryCompanyMainSearch(@RequestBody MainPageQueryVo vo,HttpServletRequest request) {
		ResultResponse response = new ResultResponse();
		if(vo==null){
			response.setState(ResultResponse.ErrorState);
			response.setMessage("参数不能为空");
			return response;
		}
		/**查询框有条件的情况下*/
		if(!StringUtils.isEmpty(vo.getPageQueryParam())){
			vo.setSearch_type(BaseConts.GENERAL_SEARCH);
		}else{
			vo.setSearch_type(BaseConts.PRECISE_SEARCH);
		}
		if(vo.getPageNum()<=0){
			vo.setPageNum(1);
		}
		if(vo.getPageSize()<=0){
			vo.setPageSize(10);
		}
		vo.setStartIndex(vo.getStartIndex());
		List<CompanyDto> list=companyService.queryCompanyMainSearch(vo);
		if(list==null||list.size()<=0){
			response.setState(ResultResponse.ErrorState);
			response.setData(list);
			response.setMessage("查询结果为null");
		}else{
			response.setState(ResultResponse.IsOkState);
			response.setData(list);
			response.setMessage("查询成功");
		}
		
		return response;
	}
	
	/**
	 * 查询用户个人信息
	 * @param request
	 * @return
	 * @author liucongcong
	 * 2016年7月5日
	 */
	@RequestMapping(value = "/queryDetailUserInfo.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryDetailUserInfo (HttpServletRequest request){
		ResultResponse response = new ResultResponse();
		UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
		try {
			UserDetailDto userDetailDto=companyService.queryDetailUserInfo(userPojo.getUserId());
			response.setData(userDetailDto);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("用户个人信息", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	/**
	 * 查询父类品类下的子类品类
	 *  @param requestParam
	 *  @return
	 */
	@RequestMapping(value = "/queryEveryChildCategory.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryEveryChildCategory (){
		ResultResponse response = new ResultResponse();
		try {
			List<Category> childCategoryList=categoryService.queryEveryChildCategory();
			response.setData(childCategoryList);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询父类品类下的子类信息异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}
	
	
	
	/**
	 * <p>查询公司信息</p>
	 * 
	 * @param vo
	 * @return
	 * @author:刘毅 
	 * @date: Created on 2016年7月7日 下午1:05:34
	 */
	@RequestMapping(value = "/queryCompanyPageInfo.do",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody 
	ResultResponse queryCompanyPageInfo(@RequestBody CompanyPageVo vo,HttpServletRequest request){
		ResultResponse response = new ResultResponse();
		if(vo==null||StringUtils.isEmpty(vo.getCompany_id())){
			LOGGER.error("查询公司信息,必要参数为null");
			response.setState(ResultResponse.ErrorState);
			response.setMessage("查询公司信息,必要参数为null");
			return response;
		}
		try {
			CompanyPagePojo pojo=companyService.queryCompanyPageInfo(vo);
			UserPojo userPojo=(UserPojo) request.getSession().getAttribute("userPojo");
			String uploadImg=BaseConts.FALSE;
			if(userPojo!=null){
				//当前操作人与当前公司信息匹配  支持上传图片功能
				if(userPojo.getUserId().equals(pojo.getUser_id())){
					uploadImg=BaseConts.TRUE;
				}
			}
			pojo.setUploadImg(uploadImg);
			response.setData(pojo);
			response.setState(ResultResponse.IsOkState);
			return response;
		} catch (Exception e) {
			LOGGER.error("查询父类品类下的子类信息异常", e);
			response.setState(ResultResponse.ErrorState);
			response.setMessage(e.getMessage());
			return response;
		}
	}

}
