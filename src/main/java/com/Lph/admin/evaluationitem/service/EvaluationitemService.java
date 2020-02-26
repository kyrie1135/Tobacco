package com.Lph.admin.evaluationitem.service;

import com.Lph.admin.evaluationitem.model.TCCEvaluationitem;

import java.util.List;

public interface EvaluationitemService {

    /**
     * 获得评测项目
     * @return
     */
    public List<TCCEvaluationitem> getEvaluationItem();

    /**
     * 添加评测项目
     * @return
     */
    public String addEvaluationItem(TCCEvaluationitem target);

    /**
     * 修改评测项目
     * @return
     */
    public String editEvaluationItem(TCCEvaluationitem target);

    /**
     * 删除评测项目
     * @return
     */
    public String delEvaluationItem(String id);
}
