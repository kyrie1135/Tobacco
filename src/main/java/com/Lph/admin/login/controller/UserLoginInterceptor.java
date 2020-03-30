package com.Lph.admin.login.controller;

import com.Lph.admin.login.model.UserLogin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * 不拦截的请求
     */
    // 不拦截 "/login" 请求
    private static final String[] IGNORE_URI = {"/login", "/noright", "/error"};

    /**
     * 在controller调用之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断flag
        boolean flag = false;
        //获取请求的url
        String url = request.getServletPath();
        //不拦截toLogin请求
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            //判断session中是否有登陆信息
            UserLogin userLogin = (UserLogin) request.getSession().getAttribute("USER_SESSION");
            if (userLogin == null) {
                // 如果未登录，进行拦截，跳转到登录页面
                response.sendRedirect("/login/gologin");
            } else {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
