package com.Lph.admin.subscript.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.Utils.Node;
import com.Lph.admin.organdrole.dao.OrganizationDAO;
import com.Lph.admin.organdrole.model.Organization;
import com.Lph.admin.organdrole.model.OrganizationExample;
import com.Lph.admin.organdrole.dao.RoleDAO;
import com.Lph.admin.organdrole.model.Role;
import com.Lph.admin.organdrole.model.RoleExample;
import com.Lph.admin.subscript.dao.TCCClientsatisfyDAO;
import com.Lph.admin.subscript.model.TCCClientsatisfy;
import com.Lph.admin.subscript.model.TCCClientsatisfyExample;
import com.Lph.admin.subscript.service.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptServiceImpl implements SubscriptService {

    @Autowired
    private OrganizationDAO organizationDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private TCCClientsatisfyDAO tccClientsatisfyDAO;

    /**
     * 选择调查人员功能， 展示岗位树
     * @param id
     * @return
     */
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

    /**
     * 选择调查人员功能， 展示角色树
     * @param id
     * @return
     */
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

    /**
     * 获取所有评测指标
     * @return
     */
    @Override
    public List<TCCClientsatisfy> getSubscriptions() {
        TCCClientsatisfyExample example = new TCCClientsatisfyExample();
        return tccClientsatisfyDAO.selectByExample(example);
    }

    /**
     * 添加评测指标
     */
    @Override
    public String addSubsrciption(TCCClientsatisfy target) {
        target.setBickid(IdUtil.nextId());
        target.setCreDate(new Timestamp(System.currentTimeMillis()));
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccClientsatisfyDAO.insert(target);
        return "200";
    }
}
