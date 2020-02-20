package com.Lph.admin.subscript.controller;

import com.Lph.admin.Utils.Node;
import com.Lph.admin.Utils.Test.dao.OrgDAO;
import com.Lph.admin.Utils.Test.model.Org;
import com.Lph.admin.Utils.Test.model.OrgExample;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class SubscriptController {
    @Autowired
    private OrgDAO orgDAO;
    //获取岗位树
    @RequestMapping(value = "/targetSortTree/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Node> getATargetSortTree(@PathVariable("id") String id){
        List<Org> orgs = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        OrgExample orgExample = new OrgExample();
        orgExample.createCriteria().andPidEqualTo(id);
        orgs = orgDAO.selectByExample(orgExample);
        for (Org org : orgs){
            nodes.add(new Node(org.getId(), org.getPid(), org.getName()));
        }
        return nodes;
    }

    @RequestMapping("/test")
    public String test(){
        return "/admin/subscript/subscriptAdd.html";
    }
}
