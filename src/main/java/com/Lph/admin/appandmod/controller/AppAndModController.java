package com.Lph.admin.appandmod.controller;

import com.Lph.admin.appandmod.model.Application;
import com.Lph.admin.appandmod.model.Module;
import com.Lph.admin.appandmod.service.AppAndModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 功能和模块
 * 主要功能： 为主页面左侧菜单栏填充内容， 跳转到主页面功能
 */
@Controller
@RequestMapping("/main")
public class AppAndModController {

    @Autowired
    private AppAndModService appAndModService;

    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping("/main")
    public String main(){
        return "/include/Navigation.html";
    }

    /**
     * 获得所有父级菜单  App
     * @return
     */
    @RequestMapping("/menuApp")
    @ResponseBody
    public List<Application> getMenuApp(){
        return appAndModService.getMenuApp();
    }

    /**
     * 获得所有子菜单  Mod
     * @return
     */
    @RequestMapping("/menuMod")
    @ResponseBody
    public List<Module> getMenuMod(){
        return appAndModService.getMenuMod();
    }
}
