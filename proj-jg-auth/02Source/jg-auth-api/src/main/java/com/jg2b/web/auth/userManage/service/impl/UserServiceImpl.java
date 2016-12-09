package com.jg2b.web.auth.userManage.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg2b.web.auth.userManage.dao.UserDao;
import com.jg2b.web.auth.userManage.pojo.T_Auth_Users;
import com.jg2b.web.auth.userManage.service.UserService;
import com.jg2b.web.auth.util.PasswordHelper;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao;
	
	@Autowired
    private PasswordHelper passwordHelper;


    /**
     * 创建用户
     * @param user
     */
    public T_Auth_Users createUser(T_Auth_Users user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
    	T_Auth_Users user =userDao.findOne(userId);
        user.setPassword(newPassword);
        //对密码进行加密
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public T_Auth_Users findByUsername(String username) {
    	T_Auth_Users u = userDao.findByUsername(username);
        return u;
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
    
    
//    public static void main(String[] args) {
//    	T_Auth_Users u = new T_Auth_Users();
//    	u.setPassword("123");
//    	PasswordHelper ph = new PasswordHelper();
//    	ph.encryptPassword(u);
//    	System.out.println(u.getPassword());
//	}
}
