package com.Lph.project.samplebright.bright.service;

import com.Lph.project.samplebright.bright.model.TBCClient;
import com.Lph.project.samplebright.bright.model.TCCSampleBright;

import java.text.ParseException;
import java.util.List;

public interface BrightService {

    /**
     * 获取客户经理， 为督查抽样界面填充客户经理select
     */
    public List<String> getMgrs();

    /**
     * 获取营业状态， 为督查抽样界面填充营业状态select
     */
    public List<String> getStates();

    /**
     * 获取客户分类， 为督查抽样界面填充客户分类select
     */
    public List<String> getTypes();

    /**
     * 点击筛选触发
     * @param clientType 客户分类
     * @param workState 经营状态
     * @param clientMgr 客户经理
     * @param num 抽样数量
     * @return
     */
    public List<TBCClient> searchClients(String clientType, String workState, String clientMgr, String num);

    /**
     * 点击筛选-》保存触发
     * @param list
     * @return
     */
    public String saveSearchClients(String list, String date, String diaochaDate, String luruDate, String luruPer) throws ParseException;

    /**
     * 抽样调查结果分析
     * @return
     */
    public List<TCCSampleBright> saveClientsSearch(TCCSampleBright target);

    /**
     * 抽样调查结果分析table填充内容
     * @return
     */
    public List<TCCSampleBright> getClients(String date, String clientCode, String clientName) throws ParseException ;
}
