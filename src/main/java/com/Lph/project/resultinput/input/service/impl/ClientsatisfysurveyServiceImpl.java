package com.Lph.project.resultinput.input.service.impl;

import com.Lph.admin.evaluationdescription.dao.TCCDescriptionDAO;
import com.Lph.admin.evaluationdescription.model.TCCDescription;
import com.Lph.admin.evaluationdescription.model.TCCDescriptionExample;
import com.Lph.admin.satisfysurveytarget.dao.TCCSatisfysurveytargetDAO;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytargetExample;
import com.Lph.admin.subscript.dao.TCCClientsatisfyDAO;
import com.Lph.admin.subscript.model.TCCClientsatisfy;
import com.Lph.admin.subscript.model.TCCClientsatisfyExample;
import com.Lph.project.resultinput.input.dao.TCCClientsatisfysurveyDAO;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurveyExample;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;
import com.Lph.project.resultinput.input.service.ClientsatisfysurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ClientsatisfysurveyServiceImpl implements ClientsatisfysurveyService {

    @Autowired
    private TCCClientsatisfysurveyDAO tccClientsatisfysurveyDAO;
    @Autowired
    private TCCClientsatisfyDAO tccClientsatisfyDAO;
    @Autowired
    private TCCDescriptionDAO tccDescriptionDAO;
    @Autowired
    private TCCSatisfysurveytargetDAO tccSatisfysurveytargetDAO;

    /**
     * 获取抽样得来的用户，为录入人员提供录入连接
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @Override
    public List<TCCClientsatisfysurvey> getList(String dateFrom, String dateTo) throws ParseException {
        TCCClientsatisfysurveyExample example = new TCCClientsatisfysurveyExample();
        TCCClientsatisfysurveyExample.Criteria criteria = example.createCriteria();

        if (!dateFrom.equals("null")){
            Date dateF = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
            criteria.andGetDateGreaterThanOrEqualTo(dateF);
        }
        if (!dateTo.equals("null")){
            Date dateT = new SimpleDateFormat("yyyy-MM-dd").parse(dateTo);
            criteria.andGetDateLessThanOrEqualTo(dateT);
        }
        example.setOrderByClause("`INPUT_DATE` DESC, `IS_OVER` ASC");
        List<TCCClientsatisfysurvey> list = tccClientsatisfysurveyDAO.selectByExample(example);
        for (TCCClientsatisfysurvey t : list){
            Calendar c = Calendar.getInstance();
            c.setTime(t.getGetDate());
            c.add(Calendar.DAY_OF_MONTH, 1);
            t.setGetDate(c.getTime());

            c.setTime(t.getInputDate());
            c.add(Calendar.DAY_OF_MONTH, 1);
            t.setInputDate(c.getTime());
        }
        return list;
    }

    @Override
    public TCCSaitDescription toInputResult(String subscriptBickid) {
        TCCSaitDescription target = new TCCSaitDescription();
        //获取此测评项目中的评测指标
        TCCClientsatisfyExample example = new TCCClientsatisfyExample();
        example.createCriteria().andBickidEqualTo(subscriptBickid.substring(1, subscriptBickid.length()-1));
        List<TCCClientsatisfy> list = tccClientsatisfyDAO.selectByExample(example);
        List<String> tempNames = new ArrayList<>();
        for (TCCClientsatisfy t : list){
            tempNames.add(t.getEvaluateTarget());
        }
        target.setZhibiaoNames(tempNames);

        //获取评分标准
        TCCSatisfysurveytargetExample example1 = new TCCSatisfysurveytargetExample();
        List<TCCSatisfysurveytarget> list1 = tccSatisfysurveytargetDAO.selectByExample(example1);
        List<String> tempStanders = new ArrayList<>();
        for (TCCSatisfysurveytarget t : list1){
            tempStanders.add(t.getEvaluateStandard());
        }
        target.setDes(tempStanders);
        return target;
    }
}
