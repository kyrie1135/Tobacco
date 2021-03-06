package com.Lph.admin.evaluationdescription.service;

import com.Lph.admin.evaluationdescription.model.TCCDescription;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;

import java.util.List;

public interface EvaluationDescriptService {

    /**
     * 获取所有评测指标描述
     * 作用：为table提供list
     */
    public List<TCCDescription> getDescriptions();

    /**
     * 根据选择的所属评测项目获取评测描述
     * @return
     */
    public List<TCCDescription> getDescriptionsByItem(String id);

    /**
     * 添加评测指标描述
     */
    public String addDescriptions(TCCDescription target);

    /**
     * 修改评测指标描述
     */
    public String editDescriptions(TCCDescription target);

    /**
     * 删除评测指标描述
     */
    public String delDescriptions(String id);

    /**
     * 根据bickid获得评测指标
     * @return bickid
     */
    public TCCDescription getDescriptionByBickid(String bickid);

    /**
     * 根据SatisfysurveyBickid获得汇总数量
     * @param bickid
     * @return
     */
    public List<TCCSaitDescription> getDescriptionNumByBickid(String bickid);
}
