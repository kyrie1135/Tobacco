package com.Lph.admin.login.controller;

import com.Lph.admin.login.model.UserLogin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * 不拦截的请求
     */
    private static final String[] IGNORE_URL = {"/login/gologin"};

    /**
     * 在controller调用之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        boolean flag = false;
//        String url = request.getServletPath();  //获取请求的URL
//        //不拦截IGNORE_URL中的请求
//        for (String s : IGNORE_URL){
//            if (url.contains(s)){
//                flag = true;
//                break;
//            }
//        }
//        //如果不在INGNORE_URL中， 判断session中是否有登陆信息
//        if (!flag){
//            UserLogin userLogin = (UserLogin) request.getSession().getAttribute("USER_SESSION");
//            if (userLogin == null){
//                //跳转到登陆页面
//            }else {
//                //账号密码正确， 为账户填充拥有的权限
//
//            }
//        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
