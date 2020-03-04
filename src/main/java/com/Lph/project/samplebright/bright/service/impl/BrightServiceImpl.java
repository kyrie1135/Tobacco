package com.Lph.project.samplebright.bright.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.project.samplebright.bright.dao.TBCClientDAO;
import com.Lph.project.samplebright.bright.dao.TCCSampleBrightDAO;
import com.Lph.project.samplebright.bright.model.TBCClient;
import com.Lph.project.samplebright.bright.model.TBCClientExample;
import com.Lph.project.samplebright.bright.model.TCCSampleBright;
import com.Lph.project.samplebright.bright.service.BrightService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BrightServiceImpl implements BrightService {

    @Autowired
    private TBCClientDAO tbcClientDAO;
    @Autowired
    private TCCSampleBrightDAO tccSampleBrightDAO;

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

    /**
     * 点击筛选触发
     * @param clientType 客户分类
     * @param workState 经营状态
     * @param clientMgr 客户经理
     * @param num 抽样数量
     * @return
     */
    @Override
    public List<TBCClient> searchClients(String clientType, String workState, String clientMgr, String num) {
        int n = Integer.parseInt(num);
        TBCClientExample example = new TBCClientExample();
        TBCClientExample.Criteria criteria = example.createCriteria();
        if (!clientType.equals("所有客户分类")){
            criteria.andClientTypeCodeEqualTo(clientType);
        }
        if (!workState.equals("所有经营状态")){
            criteria.andWorkStateEqualTo(workState);
        }
        if (!clientMgr.equals("所有客户经理")){
            criteria.andClientMgrEqualTo(clientMgr);
        }

        List<TBCClient> list = tbcClientDAO.selectByExample(example);
        if (n > list.size()){
            n = list.size();
        }
        Collections.shuffle(list);
        List<TBCClient> afterList = new ArrayList<>();
        for (int i = 0; i<n; i++){
            afterList.add(list.get(i));
        }
        //随机删选
        return afterList;
    }

    /**
     * 点击筛选-》保存触发
     * @param list
     * @return
     */
    @Override
    public String saveSearchClients(String list, String date) throws ParseException {
        TCCSampleBright target = new TCCSampleBright();
        JSONArray paradms = JSON.parseArray(list);
        for (int i = 0; i< paradms.size();i++) {
            JSONObject paramjson = (JSONObject) paradms.get(i);
            target.setBickid(IdUtil.nextId());
            target.setClientCode(paramjson.getString("facilityNum"));
            target.setClientName(paramjson.getString("clientName"));
            target.setSampleData(new SimpleDateFormat("yyyy-MM-dd").parse(date.substring(1, date.length()-1)));
            target.setDeleted(0);
            tccSampleBrightDAO.insert(target);
        }
        return "200";
    }

    /**
     * 抽样调查结果分析
     * @return
     */
    @Override
    public List<TCCSampleBright> saveClientsSearch(TCCSampleBright target) {

        return null;
    }
}
