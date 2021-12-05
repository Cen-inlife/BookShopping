package com.shoppingweb_manager.util.filter;

import com.shoppingweb.bean.User;
import com.shoppingweb_manager.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器，如果没有登录则直接访问登录页
 */
public class ManagerLoginInterceptor extends HandlerInterceptorAdapter {

    /**
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        //从session中获取用户信息
        User user = (User) request.getSession().getAttribute(Constant.SESSION_USER);

        if (user == null) {
            request.setAttribute("tip","您尚未登录，请先进行登录");
            //跳转至登录页
            request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request,response);
            return false;
        } else {
            return true;
        }
    }

}
