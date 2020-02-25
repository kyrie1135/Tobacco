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
}
