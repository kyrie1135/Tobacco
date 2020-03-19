package com.Lph.admin.evaluationdescription.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.evaluationdescription.dao.TCCDescriptionDAO;
import com.Lph.admin.evaluationdescription.model.TCCDescription;
import com.Lph.admin.evaluationdescription.model.TCCDescriptionExample;
import com.Lph.admin.evaluationdescription.service.EvaluationDescriptService;
import com.Lph.project.resultinput.input.dao.TCCSaitDescriptionDAO;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;
import com.Lph.project.resultinput.input.model.TCCSaitDescriptionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@SuppressWarnings("all")
public class EvaluationDescriptServiceImpl implements EvaluationDescriptService {

    @Autowired
    private TCCDescriptionDAO tccDescriptionDAO;
    @Autowired
    private TCCSaitDescriptionDAO tccSaitDescriptionDAO;

    /**
     * 获取所有评测指标描述
     * 作用：为table提供list
     */
    @Override
    public List<TCCDescription> getDescriptions() {
        TCCDescriptionExample example = new TCCDescriptionExample();
        example.createCriteria().andDeletedEqualTo(0);
        return tccDescriptionDAO.selectByExample(example);
    }

    @Override
    public List<TCCDescription> getDescriptionsByItem(String id) {
        TCCDescriptionExample example = new TCCDescriptionExample();
        example.createCriteria().andBelongItemIdEqualTo(id);
        return tccDescriptionDAO.selectByExample(example);
    }

    /**
     * 添加评测指标描述
     */
    @Override
    public String addDescriptions(TCCDescription target) {
        target.setBickid(IdUtil.nextId());
        target.setDeleted(0);
        target.setCreDate(new Timestamp(System.currentTimeMillis()));
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccDescriptionDAO.insert(target);
        return "200";
    }

    /**
     * 修改评测指标描述
     */
    @Override
    public String editDescriptions(TCCDescription target) {
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccDescriptionDAO.updateByPrimaryKeySelective(target);
        return "200";
    }

    /**
     * 删除评测指标描述
     */
    @Override
    public String delDescriptions(String id) {
        TCCDescription record = tccDescriptionDAO.selectByPrimaryKey(id);
        if (record != null){
            record.setDeleted(1);
            tccDescriptionDAO.updateByPrimaryKey(record);
            return "200";
        }
        return "0";
    }

    /**
     * 根据bickid获得评测指标
     * @return bickid
     */
    @Override
    public TCCDescription getDescriptionByBickid(String bickid) {
        return tccDescriptionDAO.selectByPrimaryKey(bickid);
    }

    /**
     * 根据SatisfysurveyBickid获得汇总数量
     * @param bickid
     * @return
     */
    @Override
    public List<TCCSaitDescription> getDescriptionNumByBickid(String bickid) {
        TCCSaitDescriptionExample example = new TCCSaitDescriptionExample();
        example.createCriteria().andSatisfysurveytargetBickidEqualTo(bickid);
        return tccSaitDescriptionDAO.selectByExample(example);
    }
}
