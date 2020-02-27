package com.Lph.admin.subscript.controller;

import com.Lph.admin.Utils.Node;
import com.Lph.admin.subscript.model.TCCClientsatisfy;
import com.Lph.admin.subscript.service.SubscriptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 评测指标维护
 * 主要功能： 展示指标维护列表， 添加指标维护， 修改指标维护
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class SubscriptController {

    @Autowired
    private SubscriptService subscriptService;

    /**
     * 跳转到评测指标维护界面
     * @return
     */
    @RequestMapping("/subscriptList")
    public String subscriptAdd(){
        return "/admin/subscript/subscript.html";
    }

    /**
     * 选择调查人员功能， 展示岗位树
     * @param id
     * @return
     */
    @RequestMapping(value = "/orgTree/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Node> getOrgTree(@PathVariable("id") String id){
        return subscriptService.getOrgTree(id);
    }

    /**
     * 选择调查人员功能， 展示角色树
     * @param id
     * @return
     */
    @RequestMapping(value = "/roleTree/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Node> getRoleTree(@PathVariable("id") String id){
        return subscriptService.getRoleTree(id);
    }

    /**
     * 获取所有评测指标
     * @return
     */
    @RequestMapping(value = "/subscript", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCClientsatisfy> getSubscriptions(){
        return subscriptService.getSubscriptions();
    }

    /**
     * 添加评测指标
     */
    @RequestMapping(value = "/subscript", method = RequestMethod.POST)
    @ResponseBody
    public String addSubsrciption(@RequestBody @Valid TCCClientsatisfy target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评分标准维护插入错误 {}: ",bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return subscriptService.addSubsrciption(target);
    }

}
