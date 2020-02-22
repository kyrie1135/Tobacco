package com.Lph.admin.appandmod.controller;

import com.Lph.admin.appandmod.model.Application;
import com.Lph.admin.appandmod.model.Module;
import com.Lph.admin.appandmod.service.AppAndModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/main")
public class AppAndModController {

    @Autowired
    private AppAndModService appAndModService;

    @RequestMapping("/main")
    public String main(){
        return "/include/Navigation.html";
    }

    @RequestMapping("/menuApp")
    @ResponseBody
    public List<Application> getMenuApp(){
        return appAndModService.getMenuApp();
    }

    @RequestMapping("/menuMod")
    @ResponseBody
    public List<Module> getMenuMod(){
        return appAndModService.getMenuMod();
    }
}
