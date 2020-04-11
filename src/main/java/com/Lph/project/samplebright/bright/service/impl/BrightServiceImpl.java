package com.Lph.project.samplebright.bright.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.subscript.dao.TCCClientsatisfyDAO;
import com.Lph.admin.subscript.model.TCCClientsatisfy;
import com.Lph.admin.subscript.model.TCCClientsatisfyExample;
import com.Lph.project.resultinput.input.dao.TCCClientsatisfysurveyDAO;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.samplebright.bright.dao.TBCClientDAO;
import com.Lph.project.samplebright.bright.dao.TCCSampleBrightDAO;
import com.Lph.project.samplebright.bright.model.TBCClient;
import com.Lph.project.samplebright.bright.model.TBCClientExample;
import com.Lph.project.samplebright.bright.model.TCCSampleBright;
import com.Lph.project.samplebright.bright.model.TCCSampleBrightExample;
import com.Lph.project.samplebright.bright.service.BrightService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BrightServiceImpl implements BrightService {

    @Autowired
    private TBCClientDAO tbcClientDAO;
    @Autowired
    private TCCSampleBrightDAO tccSampleBrightDAO;
    @Autowired
    private TCCClientsatisfyDAO tccClientsatisfyDAO;
    @Autowired
    private TCCClientsatisfysurveyDAO tccClientsatisfysurveyDAO;

    /**
     * 获取路段， 为督查抽样界面填充客户经理select
     */
    @Override
    public List<String> getMgrs() {
        List<String> mgrs = new ArrayList<>();
        mgrs.add("客户经理1");
        mgrs.add("客户经理2");
        mgrs.add("客户经理3");
//        mgrs.add("客户经理4");
//        mgrs.add("客户经理5");
//        mgrs.add("客户经理6");
//        mgrs.add("客户经理7");
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
//        types.add("五类客户");
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
    public String saveSearchClients(String list, String date, String diaochaDate, String luruDate, String luruPer) throws ParseException {
        List<TCCSampleBright> clients = new ArrayList<>();
        JSONArray paradms = JSON.parseArray(list);
        TBCClientExample example = new TBCClientExample();
        for (int i = 0; i< paradms.size();i++) {
            TCCSampleBright target = new TCCSampleBright();
            JSONObject paramjson = (JSONObject) paradms.get(i);
            example.clear();
            example.createCriteria().andFacilityNumEqualTo(paramjson.getString("facilityNum"));

            target.setBickid(IdUtil.nextId());
            target.setLuruPer(luruPer.substring(1, luruPer.length()-1));
            target.setClientCode(paramjson.getString("facilityNum"));
            target.setClientName(paramjson.getString("clientName"));
            target.setSampleData(new SimpleDateFormat("yyyy/MM/dd").parse(date.substring(1, date.length()-1)));
            target.setDiaochaData(new SimpleDateFormat("yyyy-MM-dd").parse(diaochaDate.substring(1, diaochaDate.length()-1)));
            target.setLuruData(new SimpleDateFormat("yyyy-MM-dd").parse(luruDate.substring(1, luruDate.length()-1)));

            target.setDeleted(0);
            clients.add(target);
            tccSampleBrightDAO.insert(target);
        }
        buildResultInputList(clients);
        return "200";
    }

    public void buildResultInputList(List<TCCSampleBright> list){
        List<TCCClientsatisfy> zhibiaoList = new ArrayList<>();
        TCCClientsatisfyExample example = new TCCClientsatisfyExample();
        zhibiaoList = tccClientsatisfyDAO.selectByExample(example);

        for (TCCSampleBright t : list){
            for (TCCClientsatisfy tc : zhibiaoList){
                TCCClientsatisfysurvey target = new TCCClientsatisfysurvey();
                TBCClientExample clientExample = new TBCClientExample();
                TBCClientExample.Criteria criteria = clientExample.createCriteria();
                target.setBickid(IdUtil.nextId());
                target.setSubscriptBickid(tc.getBickid());

                criteria.andFacilityNumEqualTo(t.getClientCode());
                List<TBCClient> tbcClients = tbcClientDAO.selectByExample(clientExample);
                target.setDeptName(tbcClients.get(0).getBigCorpCode());

                target.setClientCode(t.getClientCode());
                target.setClientName(t.getClientName());

                target.setInputDate(t.getLuruData());
                target.setGetDate(t.getDiaochaData());
                target.setGeter(tc.getEmpRole());
                target.setInputer(t.getLuruPer());
                target.setIsOver(0);
                tccClientsatisfysurveyDAO.insert(target);
            }
        }
    }

    /**
     * 抽样调查结果分析
     * @return
     */
    @Override
    public List<TCCSampleBright> saveClientsSearch(TCCSampleBright target) {
        return null;
    }

    /**
     * 抽样调查结果分析table填充内容
     * @return
     */
    @Override
    public List<TCCSampleBright> getClients(String date, String clientCode, String clientName) throws ParseException {
        TCCSampleBrightExample example = new TCCSampleBrightExample();
        TCCSampleBrightExample.Criteria criteria = example.createCriteria();
        if (!date.equals("null") && date != null){
            Date today = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.DAY_OF_MONTH, 1);
            Date tomorrow = c.getTime(); //date的下一天
            c.setTime(today);
            c.add(Calendar.DAY_OF_MONTH, -1);
            Date yesterday = c.getTime();   //date的前一天
            criteria.andSampleDataBetween(yesterday, tomorrow);
        }

        if (!clientCode.equals("null") && clientCode != null){
            criteria.andClientCodeEqualTo(clientCode);
        }
        if (!clientName.equals("null") && clientName != null){
            criteria.andClientNameEqualTo(clientName);
        }
        criteria.andDeletedEqualTo(0);
        List<TCCSampleBright> list = tccSampleBrightDAO.selectByExample(example);
        for (TCCSampleBright t : list){
            Calendar c = Calendar.getInstance();
            c.setTime(t.getDiaochaData());
            c.add(Calendar.DAY_OF_MONTH, 1);
            t.setDiaochaData(c.getTime());

            c.setTime(t.getLuruData());
            c.add(Calendar.DAY_OF_MONTH, 1);
            t.setLuruData(c.getTime());
        }
        return list;
    }
}
