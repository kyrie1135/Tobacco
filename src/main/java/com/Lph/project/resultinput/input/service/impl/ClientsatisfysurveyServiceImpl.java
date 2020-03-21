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
import com.Lph.project.resultinput.input.model.*;
import com.Lph.project.resultinput.input.service.ClientsatisfysurveyService;
import com.Lph.project.samplebright.bright.dao.TCCSampleBrightDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private TCCSampleBrightDAO tccSampleBrightDAO;

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

    /**
     * 为满意度非类查询填充table
     * @return
     */
    @Override
    public List<ClassificationSearch> getClassificationSearchs(String perName) {
        List<ClassificationSearch> list = new ArrayList<>();

        //获取当前所有的评测指标名称
        TCCClientsatisfyExample example = new TCCClientsatisfyExample();
        if (!perName.equals("null")){
            example.createCriteria().andEmpRoleEqualTo(perName);
        }
        List<TCCClientsatisfy> l =  tccClientsatisfyDAO.selectByExample(example);

        //获取当前所有的评分标准
        TCCSatisfysurveytargetExample e = new TCCSatisfysurveytargetExample();
        List<TCCSatisfysurveytarget> tccSatisfysurveytargets = tccSatisfysurveytargetDAO.selectByExample(e);

        //将两者交叉组合
        for (TCCClientsatisfy i : l){
            for (TCCSatisfysurveytarget t : tccSatisfysurveytargets){
                ClassificationSearch target = new ClassificationSearch();
                target.setIndexName(i.getEvaluateTarget());
                target.setSatisfaction(t.getEvaluateStandard());
                TCCSaitDescriptionExample example1 = new TCCSaitDescriptionExample();
                example1.createCriteria().andSatisfysurveytargetBickidEqualTo(i.getBickid()).andSubscriptBickidEqualTo(t.getBickid());
                long l1 = tccSaitDescriptionDAO.countByExample(example1);
                target.setTimes(l1);
                target.setScore(l1 * t.getEvaluateTarget());
                list.add(target);
            }
        }
        return list;
    }

    /**
     * 返回每一年每个月的满意度总分
     * @return
     */
    @Override
    public List<MonthScore> getMonthScore() {
        List<MonthScore> list = new ArrayList<>();
        List<String> months = tccSaitDescriptionDAO.selectMonthDistinct();
        for (String s : months){
            MonthScore m = new MonthScore();
            TCCSaitDescriptionExample e = new TCCSaitDescriptionExample();
            e.createCriteria().andMonthEqualTo(s);
            List<TCCSaitDescription> tccSaitDescriptions = tccSaitDescriptionDAO.selectByExample(e);
            m.setYearAndMonth(s);
            m.setNum(tccSaitDescriptions.size());
            Double score = 0.0;
            for (TCCSaitDescription t : tccSaitDescriptions){
                double evaluateTarget = tccSatisfysurveytargetDAO.selectByPrimaryKey(t.getSubscriptBickid()).getEvaluateTarget();
                double proportion = tccClientsatisfyDAO.selectByPrimaryKey(t.getSatisfysurveytargetBickid()).getProportion().doubleValue();
                score += evaluateTarget * proportion * 0.1;
            }
            m.setScore(score);
            list.add(m);
        }
        return list;
    }

    /**
     * 返回每个指标每个月的总得分（不考虑指标权重）
     * @return
     */
    @Override
    public List<TargetMonthScore> getTargetMonthScore() {
        List<TargetMonthScore> list = new ArrayList<>();
        List<TCCSaitDescription> tccSaitDescriptions = tccSaitDescriptionDAO.selectTargetMonthDistinct();
        for (TCCSaitDescription t : tccSaitDescriptions){
            TargetMonthScore targetMonthScore = new TargetMonthScore();
            targetMonthScore.setZhibiao(tccClientsatisfyDAO.selectByPrimaryKey(t.getSatisfysurveytargetBickid()).getEvaluateTarget());
            targetMonthScore.setYearAndMonth(t.getMonth());
            TCCSaitDescriptionExample e = new TCCSaitDescriptionExample();
            e.createCriteria().andMonthEqualTo(t.getMonth()).andSatisfysurveytargetBickidEqualTo(t.getSatisfysurveytargetBickid());
            List<TCCSaitDescription> tc = tccSaitDescriptionDAO.selectByExample(e);
            targetMonthScore.setNum(tc.size());

            Double score = 0.0;
            for (TCCSaitDescription ta : tc){
                double evaluateTarget = tccSatisfysurveytargetDAO.selectByPrimaryKey(ta.getSubscriptBickid()).getEvaluateTarget();
                score += evaluateTarget;
            }
            targetMonthScore.setScore(score);
            list.add(targetMonthScore);
        }
        return list;
    }

}
