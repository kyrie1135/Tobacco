package com.Lph.admin.subscript.controller;

import com.Lph.admin.Utils.Node;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class SubscriptController {
    //获取岗位树
    @RequestMapping(value = "/targetSortTree/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void getATargetSortTree(@PathVariable("id") String id){

    }
}
