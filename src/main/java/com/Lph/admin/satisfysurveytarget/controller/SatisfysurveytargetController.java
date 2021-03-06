package com.Lph.admin.satisfysurveytarget.controller;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;
import com.Lph.admin.satisfysurveytarget.service.SatisfysurveytargetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 主要功能： 评分标准增删改查（满意， 比较满意。。。）
 * @author
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class SatisfysurveytargetController {

    @Autowired
    private SatisfysurveytargetService satisfysurveytargetService;

    @RequestMapping(value = "/satisfysurveytargetList", method = RequestMethod.GET)
    public String getSatisfysurveytargetList(){
        return "/admin/satisfysurveytarget/satisfysurveytargetTable.html";
    }

    /**
     * 为评分标准（满意、不满意）显示Table
     * @return
     */
    @RequestMapping(value = "/standard",method = RequestMethod.GET)
    @ResponseBody
    public List<TCCSatisfysurveytarget> getTable(){
        return satisfysurveytargetService.getTable();
    }

    /**
     * 评分标准维护-》添加弹窗-》确定
     * 添加评分标准
     */
    @RequestMapping(value = "/standard",method = RequestMethod.POST)
    @ResponseBody
    public String addStandard(@RequestBody @Valid TCCSatisfysurveytarget target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评分标准维护插入错误 {}: ",bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return satisfysurveytargetService.addStandard(target);
    }

    /**
     * 评分标准维护-》确认删除弹窗-》确定
     * 删除评分标准
     */
    @RequestMapping(value = "/standard", method = RequestMethod.DELETE)
    @ResponseBody
    public String delStandard(@RequestBody TCCSatisfysurveytarget tccSatisfysurveytarget){
        return satisfysurveytargetService.delStandard(tccSatisfysurveytarget.getBickid());
    }

    /**
     * 评分标准维护-》修改弹窗-》确定
     * 修改评分标准
     */
    @RequestMapping(value = "/standard",method = RequestMethod.PUT)
    @ResponseBody
    public String editStandard(@RequestBody @Valid TCCSatisfysurveytarget target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评分标准维护修改错误 {}",bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return satisfysurveytargetService.editStandard(target);
    }

    /**
     * 根据评测指标bickid和评测标准bickid返回数量
     * @param subscriptBickid
     * @param targetBickid
     * @return
     */
    @RequestMapping(value = "/gettargetnum",method = RequestMethod.GET)
    @ResponseBody
    public Integer editStandard(@RequestParam("subscriptBickid") String subscriptBickid, @RequestParam("targetBickid") String targetBickid){
        return satisfysurveytargetService.getTargetNum(subscriptBickid, targetBickid);
    }
}
