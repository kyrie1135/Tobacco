package com.Lph.project.samplebright.bright.service.impl;

import com.Lph.project.samplebright.bright.dao.TBCClientDAO;
import com.Lph.project.samplebright.bright.service.BrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrightServiceImpl implements BrightService {

    @Autowired
    private TBCClientDAO tbcClientDAO;

    /**
     * 获取路段， 为督查抽样界面填充客户经理select
     */
    @Override
    public List<String> getMgrs() {
        List<String> mgrs = new ArrayList<>();
        mgrs.add("客户经理1");
        mgrs.add("客户经理2");
        mgrs.add("客户经理3");
        mgrs.add("客户经理4");
        mgrs.add("客户经理5");
        mgrs.add("客户经理6");
        mgrs.add("客户经理7");
        return mgrs;
    }

    /**
     * 获取营业状态， 为督查抽样界面填充营业状态select
     */
    @Override
    public List<String> getStates() {
        List<String> states = new ArrayList<>();
        states.add("初始申请");
        states.add("正常营业");
        states.add("歇业");
        states.add("注销");
        return states;
    }

    /**
     * 获取客户分类， 为督查抽样界面填充客户分类select
     */
    @Override
    public List<String> getTypes() {
        List<String> types = new ArrayList<>();
        types.add("一类客户");
        types.add("二类客户");
        types.add("三类客户");
        types.add("四类客户");
        types.add("五类客户");
        return types;
    }
}
