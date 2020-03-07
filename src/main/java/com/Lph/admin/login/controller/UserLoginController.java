package com.Lph.admin.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class UserLoginController {

    /**
     * 跳转到用户登陆界面
     * @return
     */
    @RequestMapping(value = "/gologin", method = RequestMethod.GET)
    public String goLogin(){
        return "/login/login.html";
    }


}
