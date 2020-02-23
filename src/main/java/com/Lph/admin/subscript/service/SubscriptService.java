package com.Lph.admin.subscript.service;

import com.Lph.admin.Utils.Node;

import java.util.List;

public interface SubscriptService {
    /**
     * 选择调查人员功能， 展示岗位树
     * @param id
     * @return
     */
    public List<Node> getOrgTree(String id);

    /**
     * 选择调查人员功能， 展示角色树
     * @param id
     * @return
     */
    public List<Node> getRoleTree(String id);
}
