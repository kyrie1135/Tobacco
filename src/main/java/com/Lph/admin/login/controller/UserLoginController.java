package com.Lph.admin.login.controller;

import com.Lph.admin.login.dao.UserLoginDAO;
import com.Lph.admin.login.model.UserLogin;
import com.Lph.admin.login.model.UserLoginExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class UserLoginController {

    @Autowired
    private UserLoginDAO userLoginDAO;

    /**
     * 跳转到用户登陆界面
     *
     * @return
     */
    @RequestMapping(value = "/gologin", method = RequestMethod.GET)
    public String goLogin() {
        return "/login/login.html";
    }


    /**
     * 点击登陆按键
     * @param userLogin
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(UserLogin userLogin, HttpServletRequest request) {
        String account = userLogin.getUserId();
        String password = userLogin.getUserPassword();
        if (account != null && password != null) {
                UserLoginExample example = new UserLoginExample();
                example.createCriteria().andUserIdEqualTo(account);
            List<UserLogin> userLogins = userLoginDAO.selectByExample(example);
            if (userLogins.size() > 0) {
                    //将用户添加到Session
                    if (password.equals(userLogins.get(0).getUserPassword())) {
                        request.getSession().setAttribute("USER_SESSION", userLogins.get(0));
                        //重定向
                        return "redirect:/main/main";
                    }
                }
        }
        return "redirect:/login/gologin";
    }

    @RequestMapping(value = "getUserName", method = RequestMethod.GET)
    @ResponseBody
    public String getUserName(HttpServletRequest request){
        UserLogin userLogin = (UserLogin) request.getSession().getAttribute("USER_SESSION");
        return userLogin.getUserName();
    }
}
