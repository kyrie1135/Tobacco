package com.Lph.admin.subscript.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.Utils.Node;
import com.Lph.admin.evaluationitem.model.TCCEvaluationitemExample;
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
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
     * 为评测指标维护上层，根据岗位查询填充内容，返回所有岗位
     */
    @Override
    public List<Organization> getOrganizations() {
        OrganizationExample example = new OrganizationExample();
        return organizationDAO.selectByExample(example);
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
        example.createCriteria().andDeletedEqualTo(0);
        return tccClientsatisfyDAO.selectByExample(example);
    }

    /**
     * 添加评测指标
     */
    @Override
    public String addSubscription(TCCClientsatisfy target) {
        target.setBickid(IdUtil.nextId());
        target.setDeleted(0);
        target.setCreDate(new Timestamp(System.currentTimeMillis()));
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccClientsatisfyDAO.insert(target);
        return "200";
    }

    /**
     * 修改评测指标
     */
    @Override
    public String editSubscription(TCCClientsatisfy target) {
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccClientsatisfyDAO.updateByPrimaryKeySelective(target);
        return "200";
    }

    /**
     * 删除评测指标
     */
    @Override
    public String deleteSubscription(TCCClientsatisfy target) {
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        target.setDeleted(1);
        tccClientsatisfyDAO.updateByPrimaryKeySelective(target);
        return "200";
    }

    @Override
    public List<TCCClientsatisfy> getSubscriptionsBy(String itemBickid, String orgId) {
        TCCClientsatisfyExample example = new TCCClientsatisfyExample();
        TCCClientsatisfyExample.Criteria criteria = example.createCriteria();
        if (!itemBickid.equals("null")){
            criteria.andEvaluateItemBickidEqualTo(itemBickid);
        }
        if (!orgId.equals("null")){
            criteria.andTargetSortEqualTo(orgId);
        }
        criteria.andDeletedEqualTo(0);
        return tccClientsatisfyDAO.selectByExample(example);
    }
}
