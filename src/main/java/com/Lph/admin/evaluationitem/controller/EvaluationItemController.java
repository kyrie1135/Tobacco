package com.Lph.admin.evaluationitem.controller;

import com.Lph.admin.evaluationitem.model.TCCEvaluationitem;
import com.Lph.admin.evaluationitem.service.EvaluationitemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 评分项目维护（烟卷质量、席坐员）
 */
@RequestMapping("/admin")
@Controller
@Slf4j
public class EvaluationItemController {

    @Autowired
    private EvaluationitemService evaluationitemService;

    /**
     * 为左侧菜单栏提供跳转链接
     * @return
     */
    @RequestMapping(value = "/evaluationitemList", method = RequestMethod.GET)
    public String getEvaluationItemList(){
        return "/admin/evaluationitem/evaluationitem.html";
    }

    /**
     * 获取所有评测项目
     * @return
     */
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCEvaluationitem> getEvaluationItem(){
        return evaluationitemService.getEvaluationItem();
    }

    /**
     * 添加评测项目
     * @return
     */
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseBody
    public String addEvaluationItem(@RequestBody @Valid TCCEvaluationitem target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评测项目维护插入错误 {} ", bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return evaluationitemService.addEvaluationItem(target);
    }

    /**
     * 修改评测项目
     * @return
     */
    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    @ResponseBody
    public String editEvaluationItem(@RequestBody @Valid TCCEvaluationitem target, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.info("评测项目维护修改错误 {} ", bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return evaluationitemService.editEvaluationItem(target);
    }

    /**
     * 删除评测项目
     * @return
     */
    @RequestMapping(value = "/item", method = RequestMethod.DELETE)
    @ResponseBody
    public String delEvaluationItem(@RequestBody TCCEvaluationitem target) {
        evaluationitemService.delEvaluationItem(target.getBickid());
        return "200";
    }

}
