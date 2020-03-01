package com.Lph.project.samplebright.bright.controller;

import com.Lph.project.samplebright.bright.service.BrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/project")
public class BrightController {

    @Autowired
    private BrightService brightService;

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
    @RequestMapping(value = "/getMgrs")
    @ResponseBody
    public List<String> getLines(){
        return brightService.getMgrs();
    }

    /**
     * 获取营业状态， 为督查抽样界面填充营业状态select
     */
    @RequestMapping(value = "/getStates")
    @ResponseBody
    public List<String> getStates(){
        return brightService.getStates();
    }

    /**
     * 获取客户分类， 为督查抽样界面填充客户分类select
     */
    @RequestMapping(value = "/getTypes")
    @ResponseBody
    public List<String> getTypes(){
        return brightService.getTypes();
    }

}
