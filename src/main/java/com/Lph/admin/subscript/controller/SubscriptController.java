package com.Lph.admin.subscript.controller;

import com.Lph.admin.Utils.Node;
import com.Lph.admin.organdrole.model.Organization;
import com.Lph.admin.organdrole.model.Person;
import com.Lph.admin.organdrole.model.Role;
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
     * 为评测指标维护上层，根据岗位查询填充内容，返回所有岗位
     */
    @RequestMapping(value = "/org", method = RequestMethod.GET)
    @ResponseBody
    public List<Organization> getOrganizations(){
        return subscriptService.getOrganizations();
    }

    /**
     * 为评测指标维护上层， 根据岗位查询填充内容， 返回所有角色
     * @return
     */
    @RequestMapping(value = "/role/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRoles(@PathVariable("roleId") String roleId){
        return subscriptService.getRoles(roleId);
    }

    /**
     * 返回所有角色
     * @return
     */
    @RequestMapping(value = "/allroles", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getAllRoles(){
        return subscriptService.getAllRoles();
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
     * 获取所有部门
     * @return
     */
    @RequestMapping(value = "/allcorps", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllCorps(){
        return subscriptService.getBigCorps();
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
    public String addSubscription(@RequestBody @Valid TCCClientsatisfy target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评测指标维护插入错误 {}: ",bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return subscriptService.addSubscription(target);
    }

    /**
     * 修改评测指标
     */
    @RequestMapping(value = "/subscript", method = RequestMethod.PUT)
    @ResponseBody
    public String editSubscription(@RequestBody @Valid TCCClientsatisfy target, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("评测指标维护插入错误 {}: ",bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return subscriptService.editSubscription(target);
    }

    /**
     * 删除评测指标
     */
    @RequestMapping(value = "/subscript", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSubscription(@RequestBody TCCClientsatisfy target){
        return subscriptService.deleteSubscription(target);
    }

    /**
     * 根据评测项目和所属项目筛选
     */
    @RequestMapping(value = "/subscriptBy/{itemBickid}/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCClientsatisfy> getSubscriptionsBy(@PathVariable("itemBickid") String itemBickid, @PathVariable("roleId") String roleId){
        return subscriptService.getSubscriptionsBy(itemBickid, roleId);
    }

    /**
     * 根据所属岗位筛选
     * @return
     */
    @RequestMapping(value = "/subscriptByRoleId/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCClientsatisfy> getSubscriptionsByRoleId(@PathVariable("roleId") String roleId){
        return subscriptService.getSubscriptionByRoleId(roleId);
    }

    /**
     * 选择调查人员   当选择角色时， 显示属于此角色的人员
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/getpersbyroleid/{roleid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersByRoleId(@PathVariable("roleid") String roleId){
        return subscriptService.getPersByRoleId(roleId);
    }

    /**
     * 选择调查人员   当选择部门时， 显示属于此部门的人员
     * @param orgId
     * @return
     */
    @RequestMapping(value = "/getpersbyorgid/{orgid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersByOrgId(@PathVariable("orgid") String orgId){
        return subscriptService.getPersByOrgId(orgId);
    }

    /**
     * 将evaluateItemBickid转换为evaluateItem
     * @param bickid
     * @return
     */
    @RequestMapping(value = "/changeevaluateItemBickid", method = RequestMethod.GET)
    @ResponseBody
    public String changeEvaluateItemBickid(@RequestParam("evaluateItemBickid") String bickid){
        return subscriptService.changeEvaluateItemBickid(bickid);
    }

    /**
     * 将evaluateTargetBickid转换为evaluateTarget
     * @param bickid
     * @return
     */
    @RequestMapping(value = "/changeevaluateTargetBickid", method = RequestMethod.GET)
    @ResponseBody
    public String changeEvaluateTargetBickid(@RequestParam("evaluateTargetBickid") String bickid){
        return subscriptService.changeEvaluateTargetBickid(bickid);
    }
}
