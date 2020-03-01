package com.Lph.project.samplebright.bright.service;

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
}
