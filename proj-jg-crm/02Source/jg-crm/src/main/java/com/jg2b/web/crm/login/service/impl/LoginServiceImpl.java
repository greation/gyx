package com.jg2b.web.crm.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.api.crm.login.dao.ILoginDao;
import com.jg2b.api.crm.login.pojo.UserPojo;
import com.jg2b.api.crm.login.service.ILoginService;

/**
 * <p>[描述信息：登录服务实现类]</p>
 *
 * @author 林雨竹 - linyuzhu@jg2b.com
 * @version 1.0 Created on 2016年5月5日 下午1:59:32
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
    private ILoginDao loginDao;

	@Override
	public List<UserPojo> searchUser(String userName, String pwd) {
		return loginDao.searchUser(userName, pwd);
	}

}
