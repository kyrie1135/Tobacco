package com.Lph.admin.subscript.service;

import com.Lph.admin.Utils.Node;

import java.util.List;

public interface SubscriptService {
    public List<Node> getOrgTree(String id);

    public List<Node> getRoleTree(String id);
}
