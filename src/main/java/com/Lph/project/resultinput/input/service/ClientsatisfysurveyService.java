package com.Lph.project.resultinput.input.service;

import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;

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
}
