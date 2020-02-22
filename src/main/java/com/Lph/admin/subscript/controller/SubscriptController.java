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

@Controller
@RequestMapping("/admin")
public class SubscriptController {
    @Autowired
    private SubscriptService subscriptService;

    //获取组织树
    @RequestMapping(value = "/orgTree/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Node> getOrgTree(@PathVariable("id") String id){
        return subscriptService.getOrgTree(id);
    }

    @RequestMapping(value = "/roleTree/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Node> getRoleTree(@PathVariable("id") String id){
        return subscriptService.getRoleTree(id);
    }

    @RequestMapping("/subscriptAdd")
    public String subscriptAdd(){
        return "/admin/subscript/subscriptAdd.html";
    }
}
