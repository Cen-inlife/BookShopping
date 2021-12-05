package com.shoppingweb_manager.service;

import com.shoppingweb.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ManagerUserService {

    /**
     * 根据账号以及密码获取用户信息
     */
    User getUserByNameAndPass(User user);

    /**
     * 用户信息注册
     */
    void saveUser(User user, HttpServletRequest request) throws Exception;

    /**
     * 用户信息激活
     */
    void activeUser(String activeCode);

    /**
     * 根据账号获取用户信息
     */
    String getUserByLoginName(String loginName);

    //获取所有用户信息
    List<User> userList(String name);

    //用户信息激活或者冻结
    void activeServlet(User user);

}
