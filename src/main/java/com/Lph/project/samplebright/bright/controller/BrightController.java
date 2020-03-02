package com.Lph.project.samplebright.bright.controller;

import com.Lph.project.samplebright.bright.model.TBCClient;
import com.Lph.project.samplebright.bright.service.BrightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
@Slf4j
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

    /**
     * 点击筛选触发
     * @param clientType 客户分类
     * @param workState 经营状态
     * @param clientMgr 客户经理
     * @param num 抽样数量
     * @return
     */
    @RequestMapping(value = "/searchClients/{clientType}/{workState}/{clientMgr}/{num}", method = RequestMethod.GET)
    @ResponseBody
    public List<TBCClient> searchClients(@PathVariable("clientType") String clientType, @PathVariable("workState") String workState, @PathVariable("clientMgr")String clientMgr, @PathVariable("num")String num){
        return brightService.searchClients(clientType, workState, clientMgr, num);
    }

    /**
     * 点击筛选-》保存触发
     * @param params
     * @return
     */

    @RequestMapping(value = "/saveSearchClients", method = RequestMethod.POST)
    @ResponseBody
    public String saveSearchClients(@RequestParam(value = "params", required = false) String params){
        return brightService.saveSearchClients(params);
    }
}
