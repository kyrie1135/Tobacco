package com.Lph.admin.satisfysurveytarget.service;

import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;

import java.util.List;

public interface SatisfysurveytargetService {
    /**
     * 获得指标维护table
     * @return
     */
    public List<TCCSatisfysurveytarget> getTable();

    /**
     * 评分标准维护-》添加弹窗-》确定
     * 添加评分标准
     */
    public String addStandard(TCCSatisfysurveytarget target);

    /**
     * 评分标准维护-》确认删除弹窗-》确定
     * 删除评分标准
     */
    public String delStandard(String id);

    /**
     * 评分标准维护-》修改弹窗-》确定
     * 删除评分标准
     */
    public String editStandard(TCCSatisfysurveytarget target);

    /**
     * 根据评测指标bickid和评测标准bickid返回数量
     * @param subscriptBickid
     * @param targetBickid
     * @return
     */
    public Integer getTargetNum(String subscriptBickid, String targetBickid);
}
