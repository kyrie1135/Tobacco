package com.Lph.admin.evaluationdescription.controller;

import com.Lph.admin.evaluationdescription.model.TCCDescription;
import com.Lph.admin.evaluationdescription.service.EvaluationDescriptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@Controller
@Slf4j
public class EvaluationDescriptionController {

    @Autowired
    private EvaluationDescriptService evaluationDescriptService;
    /**
     * 为左侧菜单栏提供跳转链接
     * @return
     */
    @RequestMapping(value = "/descriptionList", method = RequestMethod.GET)
    public String getDescriptionList(){
        return "/admin/evaluationdescript/evaluationdescript.html";
    }

    /**
     * 获取所有评测描述
     * @return
     */
    @RequestMapping(value = "/description", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCDescription> getEvaluationItem(){
        return evaluationDescriptService.getDescriptions();
    }

    /**
     * 根据选择的所属评测项目获取评测描述
     * @return
     */
    @RequestMapping(value = "/descriptionbyitem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCDescription> getEvaluationItem(@PathVariable("id") String id){
        return evaluationDescriptService.getDescriptionsByItem(id);
    }

    /**
     * 添加评测指标描述
     */
    @RequestMapping(value = "/description", method = RequestMethod.POST)
    @ResponseBody
    public String addDescriptions(@RequestBody @Valid TCCDescription target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评测标准描述维护插入错误 {} ", bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return evaluationDescriptService.addDescriptions(target);
    }

    /**
     * 修改评测指标描述
     */
    @RequestMapping(value = "/description", method = RequestMethod.PUT)
    @ResponseBody
    public String editDescriptions(@RequestBody @Valid TCCDescription target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评测标准描述维护修改错误 {} ", bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return evaluationDescriptService.editDescriptions(target);
    }

    /**
     * 删除评测指标描述
     */
    @RequestMapping(value = "/description", method = RequestMethod.DELETE)
    @ResponseBody
    public String delDescriptions(@RequestBody TCCDescription target){
        return evaluationDescriptService.delDescriptions(target.getBickid());
    }
}
