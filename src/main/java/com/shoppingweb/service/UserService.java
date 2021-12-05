package com.shoppingweb.service;

import com.shoppingweb.bean.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     *根据用户输入的账号以及密码获取用户的信息
     */
    User findUserByNameAndPass(User user);

    /**
     *异步校验账号是否存在
     */
    String validLoginName(String loginName);

    /**
     * 用户注册
     */
    void saveUser(User user, HttpServletRequest request);

    /**
     * 用户信息激活
     */
    String active(String activeCode);

    //更新个人信息
    void userUpdate(User user);

}
