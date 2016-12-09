package com.jg2b.web.auth.userManage.dao;


import java.util.Set;

import com.jg2b.web.auth.userManage.pojo.T_Auth_Users;

public interface UserDao {

    public T_Auth_Users createUser(T_Auth_Users user);
    public void updateUser(T_Auth_Users user);
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    T_Auth_Users findOne(Long userId);

    T_Auth_Users findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
