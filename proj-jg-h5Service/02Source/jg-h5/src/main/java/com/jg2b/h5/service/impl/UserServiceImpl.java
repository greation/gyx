package com.jg2b.h5.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jg2b.h5.dao.UserDao;
import com.jg2b.h5.dto.BrandUpload;
import com.jg2b.h5.dto.CmsCategoryCompanyDto;
import com.jg2b.h5.dto.CompanyDto;
import com.jg2b.h5.dto.SearchDto;
import com.jg2b.h5.dto.UserDto;
import com.jg2b.h5.pojo.UserPojo;
import com.jg2b.h5.service.UserService;
import com.jg2b.utils.MD5;
import com.jg2b.h5.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	public UserPojo queryUserInfoByPh(String phone) {
		return userDao.queryUserInfoByPh(phone);
		
	}

	/**
	 * 重置密码
	 */
	public int resetPassWord(String password,String mobile) {
		int i = this.userDao.resetPassWord(MD5.stringMD5(password),mobile);
		return i;
	}


	public Map<String, Object> queryUserInfoIsSure(UserVo userVo) {
		
		Map< String, Object> map=new HashMap<String, Object>();
		UserPojo user=userDao.queryUserInfoByPh(userVo.getUserDto().getMobile());
		if(user==null){
			map.put("isLogin", false);
		}else{
			String password=MD5.stringMD5(userVo.getUserDto().getPassWord());
			if(password.equals(user.getPassWord())){
				map.put("isLogin", true);
				map.put("user", user);
			}else{
				map.put("isLogin", false);
			}
		}
		return map;
	}


	public boolean isExitUser(String phone) {
		UserPojo user=userDao.queryUserInfoByPh(phone);
		if(user==null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int userRegistered(UserDto userDto) {
		userDto.setUserUuId(UUID.randomUUID().toString().replaceAll("-", ""));
		userDto.setPassWord(MD5.stringMD5(userDto.getPassWord()));
		userDto.setReg_ip("21654");
		userDto.setCompany("中华明国");
		userDto.setContacts("nihao");
		int a =userDao.userRegistered(userDto);
		if(a==0)
			return 0;
		return a;
		
	}

	@Override
	@Transactional
	public int companyRegistered(CompanyDto companyDto) {
		companyDto.setStatus(0);
		companyDto.setEmail("无");
		companyDto.setWebsite("无");
		companyDto.setOffer(1);
		companyDto.setAdd_time(((int)(System.currentTimeMillis()/1000)));
		int a =userDao.companyRegistered(companyDto);
		int user_id=companyDto.getUser_id();
		CmsCategoryCompanyDto cmsCategoryCompanyDto=new CmsCategoryCompanyDto ();
		BrandUpload brandUpload=new BrandUpload();
	    String KingList=companyDto.getKindLlists();
		String[] list = KingList.split(",");
		for (String string : list) {
	     cmsCategoryCompanyDto.setUser_id(user_id);
	     cmsCategoryCompanyDto.setC_id(Integer.parseInt(string));
		 userDao.insertUserKind(cmsCategoryCompanyDto);
		}
		/*String brandList=companyDto.getBrandLists();
		String[] brandLists=brandList.split(",");
		for (String pic : brandLists) {
			brandUpload.setUser_id(user_id);
			brandUpload.setPic(pic);
			userDao.insertUserBrand(brandUpload);
		}*/
		return a;
	}
    /**
     * 首页动态信息
     */
	@Override
	public List<SearchDto> homeDynamic() {
		List<SearchDto> SearchDtoList= userDao.homeDynamic();
		if(SearchDtoList==null)
			return null;
		return SearchDtoList;
	}

	@Override
	public UserPojo queryUserByid(String mobile) {
		return userDao.queryUserByid(mobile);
	}


}
