package com.Lph.admin.subscript.service.impl;

import com.Lph.admin.Utils.Node;
import com.Lph.admin.organization.dao.OrganizationDAO;
import com.Lph.admin.organization.model.Organization;
import com.Lph.admin.organization.model.OrganizationExample;
import com.Lph.admin.role.dao.RoleDAO;
import com.Lph.admin.role.model.Role;
import com.Lph.admin.role.model.RoleExample;
import com.Lph.admin.subscript.service.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptServiceImpl implements SubscriptService {

    @Autowired
    private OrganizationDAO organizationDAO;
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Node> getOrgTree(String id) {
        List<Organization> orgs = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        OrganizationExample organizationExample = new OrganizationExample();
        organizationExample.createCriteria().andPidEqualTo(id);
        orgs = organizationDAO.selectByExample(organizationExample);
        for (Organization organization : orgs){
            nodes.add(new Node(organization.getId(), organization.getPid(), organization.getName()));
        }
        return nodes;
    }

    @Override
    public List<Node> getRoleTree(String id) {
        List<Role> roles = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andOrgidEqualTo(id);
        roles = roleDAO.selectByExample(roleExample);
        for (Role role : roles){
            nodes.add(new Node(role.getId(), role.getOrgid(), role.getName()));
        }
        return nodes;
    }
}
