package com.Lph.project.resultinput.input.service;

import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 满意度综合查询根据筛选条件返回
     * @param dateFrom
     * @param dateTo
     * @param target
     * @return
     * @throws ParseException
     */
    public List<TCCClientsatisfysurvey> getComprehensiveList(@RequestParam("") String dateFrom, @RequestParam("") String dateTo, @RequestBody TCCClientsatisfysurvey target) throws ParseException;
}
