package com.Lph.admin.satisfysurveytarget.controller;

import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;
import com.Lph.admin.satisfysurveytarget.service.SatisfysurveytargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 主要功能： 评分标准增删改查（满意， 比较满意。。。）
 * @author
 */
@Controller
@RequestMapping("/admin")
public class SatisfysurveytargetController {

    @Autowired
    private SatisfysurveytargetService satisfysurveytargetService;

    @RequestMapping("/satisfysurveytargetTable")
    @ResponseBody
    public List<TCCSatisfysurveytarget> getTable(){
        return satisfysurveytargetService.getTable();
    }
}
