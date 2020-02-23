package com.Lph.admin.subscript.controller;

import com.Lph.admin.Utils.Node;
import com.Lph.admin.subscript.service.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 评测指标维护
 * 主要功能： 展示指标维护列表， 添加指标维护， 修改指标维护
 */
@Controller
@RequestMapping("/admin")
public class SubscriptController {

    @Autowired
    private SubscriptService subscriptService;

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
     * 跳转到评测指标添加界面
     * @return
     */
    @RequestMapping("/subscriptAdd")
    public String subscriptAdd(){
        return "/admin/subscript/subscriptAdd.html";
    }
}
