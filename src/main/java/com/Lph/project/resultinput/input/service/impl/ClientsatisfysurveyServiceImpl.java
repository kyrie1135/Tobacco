package com.Lph.project.resultinput.input.service.impl;

import com.Lph.project.resultinput.input.dao.TCCClientsatisfysurveyDAO;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurveyExample;
import com.Lph.project.resultinput.input.service.ClientsatisfysurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClientsatisfysurveyServiceImpl implements ClientsatisfysurveyService {

    @Autowired
    private TCCClientsatisfysurveyDAO tccClientsatisfysurveyDAO;

    /**
     * 获取抽样得来的用户，为录入人员提供录入连接
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @Override
    public List<TCCClientsatisfysurvey> getList(String dateFrom, String dateTo) throws ParseException {
        Date dateF = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        Date dateT = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
        TCCClientsatisfysurveyExample example = new TCCClientsatisfysurveyExample();
        example.createCriteria().andGetDateBetween(dateF, dateT);

        return tccClientsatisfysurveyDAO.selectByExample(example);
    }
}
