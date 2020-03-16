package com.Lph.project.resultinput.input.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.evaluationdescription.dao.TCCDescriptionDAO;
import com.Lph.admin.satisfysurveytarget.dao.TCCSatisfysurveytargetDAO;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytargetExample;
import com.Lph.admin.subscript.dao.TCCClientsatisfyDAO;
import com.Lph.admin.subscript.model.TCCClientsatisfy;
import com.Lph.admin.subscript.model.TCCClientsatisfyExample;
import com.Lph.project.resultinput.input.dao.TCCClientsatisfysurveyDAO;
import com.Lph.project.resultinput.input.dao.TCCSaitDescriptionDAO;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCClientsatisfysurveyExample;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;
import com.Lph.project.resultinput.input.model.TCCSaitDescriptionExample;
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
    @Autowired
    private TCCSaitDescriptionDAO tccSaitDescriptionDAO;

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

    /**
     * 点击录入时， 生成表单
     * @param subscriptBickid
     * @return
     */
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
        List<String> tempDesBickids = new ArrayList<>();
        for (TCCSatisfysurveytarget t : list1){
            tempDesBickids.add(t.getBickid());
        }
        target.setDesBickids(tempDesBickids);
        return target;
    }

    /**
     * 点击录入-》确定， 保存满意度录入信息
     * @param target
     * @return
     */
    @Override
    public String saveInputResult(TCCSaitDescription target) {
        TCCSaitDescriptionExample e = new TCCSaitDescriptionExample();
        e.createCriteria().andSatisfysurveytargetBickidEqualTo(target.getSatisfysurveytargetBickid())
                .andClientCodeEqualTo(target.getClientCode());
        List<TCCSaitDescription> tccSaitDescriptions = tccSaitDescriptionDAO.selectByExample(e);
        if (tccSaitDescriptions.size() == 0){
            target.setBickid(IdUtil.nextId());
            tccSaitDescriptionDAO.insert(target);
        }else {
            target.setBickid(tccSaitDescriptions.get(0).getBickid());
            tccSaitDescriptionDAO.updateByPrimaryKeySelective(target);
        }

        //将满意度调查录入表中的状态改为已录入
        TCCClientsatisfysurveyExample example = new TCCClientsatisfysurveyExample();
        example.createCriteria().andSubscriptBickidEqualTo(target.getSatisfysurveytargetBickid()).andClientCodeEqualTo(target.getClientCode());
        TCCClientsatisfysurvey tccClientsatisfysurvey = tccClientsatisfysurveyDAO.selectByExample(example).get(0);
        tccClientsatisfysurvey.setIsOver(1);
        tccClientsatisfysurveyDAO.updateByPrimaryKey(tccClientsatisfysurvey);
        return "200";
    }

    /**
     * 点击已录入时， 生成表单
     * @param target
     * @return
     */
    @Override
    public String getInputResult(TCCSaitDescription target) {
        TCCSaitDescriptionExample example = new TCCSaitDescriptionExample();
        example.createCriteria().andSatisfysurveytargetBickidEqualTo(target.getSatisfysurveytargetBickid()).andClientCodeEqualTo(target.getClientCode());
        TCCSaitDescription tccSaitDescription = tccSaitDescriptionDAO.selectByExample(example).get(0);
        return tccSatisfysurveytargetDAO.selectByPrimaryKey(tccSaitDescription.getSubscriptBickid()).getBickid();
    }

    /**
     * 满意度综合查询根据筛选条件返回
     * @param dateFrom
     * @param dateTo
     * @param target
     * @return
     * @throws ParseException
     */
    @Override
    public List<TCCClientsatisfysurvey> getComprehensiveList(String dateFrom, String dateTo, TCCClientsatisfysurvey target) throws ParseException {
        TCCClientsatisfysurveyExample example = new TCCClientsatisfysurveyExample();
        TCCClientsatisfysurveyExample.Criteria criteria = example.createCriteria();

        if (!target.getGeter().equals("null")){
            criteria.andGeterEqualTo(target.getGeter());
        }
        if (!target.getDeptName().equals("null")){
            criteria.andDeptNameEqualTo(target.getDeptName());
        }
        if (!target.getClientName().equals("null")){
            criteria.andClientNameEqualTo(target.getClientName());
        }
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

}
