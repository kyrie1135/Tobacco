package com.Lph.project.samplebright.bright.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project")
public class BrightController {

    /**
     * 跳转到督查抽样填写页面
     */
    @RequestMapping(value = "/brightFull")
    public String brightFull(){
        return "/project/samplebright/bright.html";
    }

    /**
     * 获取路段， 为督查抽样界面客户经理填充select
     */
    @RequestMapping(value = "/getLines/{type}")
    public List<String> getLines(@PathVariable("type") String type){
        return null;
    }
}
