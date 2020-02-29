package com.Lph.admin.subscript.service;

import com.Lph.admin.Utils.Node;
import com.Lph.admin.organdrole.model.Organization;
import com.Lph.admin.subscript.model.TCCClientsatisfy;

import java.util.List;

public interface SubscriptService {
    /**
     * 选择调查人员功能， 展示岗位树
     * @param id
     * @return
     */
    public List<Node> getOrgTree(String id);

    /**
     * 为评测指标维护上层，根据岗位查询填充内容，返回所有岗位
     */
    public List<Organization> getOrganizations();

    /**
     * 选择调查人员功能， 展示角色树
     * @param id
     * @return
     */
    public List<Node> getRoleTree(String id);

    /**
     * 获取所有评测指标
     * @return
     */
    public List<TCCClientsatisfy> getSubscriptions();

    /**
     * 添加评测指标
     */
    public String addSubscription(TCCClientsatisfy target);

    /**
     * 修改评测指标
     */
    public String editSubscription(TCCClientsatisfy target);

    /**
     * 删除评测指标
     */
    public String deleteSubscription(TCCClientsatisfy target);

    /**
     * 根据评测项目和所属项目筛选
     */
    public List<TCCClientsatisfy> getSubscriptionsBy(String itemBickid, String orgId);
}
