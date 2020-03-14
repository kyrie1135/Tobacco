package com.Lph.project.resultinput.input.service;

import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;

import java.text.ParseException;
import java.util.List;

public interface ClientsatisfysurveyService {

    /**
     * 获取抽样得来的用户，为录入人员提供录入连接
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public List<TCCClientsatisfysurvey> getList(String dateFrom, String dateTo) throws ParseException;

    /**
     * 点击录入时， 生成表单
     * @param subscriptBickid
     * @return
     */
    public TCCSaitDescription toInputResult(String subscriptBickid);

    /**
     * 点击录入-》确定， 保存满意度录入信息
     * @param target
     * @return
     */
    public String saveInputResult(TCCSaitDescription target);

    /**
     * 点击已录入时， 生成表单
     * @param target
     * @return
     */
    public String getInputResult(TCCSaitDescription target);

    /**
     * 点击已录入-》确定， 保存满意度录入信息
     * @param target
     * @return
     */
    public String editInputResult(TCCSaitDescription target);
}
