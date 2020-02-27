package com.Lph.admin.evaluationitem.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.evaluationitem.dao.TCCEvaluationitemDAO;
import com.Lph.admin.evaluationitem.model.TCCEvaluationitem;
import com.Lph.admin.evaluationitem.model.TCCEvaluationitemExample;
import com.Lph.admin.evaluationitem.service.EvaluationitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@SuppressWarnings("all")
public class EvaluationitemServiceImpl implements EvaluationitemService {

    @Autowired
    private TCCEvaluationitemDAO tccEvaluationitemDAO;

    /**
     * 获得评测项目
     * @return
     */
    @Override
    public List<TCCEvaluationitem> getEvaluationItem() {
        TCCEvaluationitemExample example = new TCCEvaluationitemExample();
        List<TCCEvaluationitem> list = tccEvaluationitemDAO.selectByExample(example);
        return list;
    }

    /**
     * 添加评测项目
     * @return
     */
    @Override
    public String addEvaluationItem(TCCEvaluationitem target) {
        target.setBickid(IdUtil.nextId());
        target.setCreDate(new Timestamp(System.currentTimeMillis()));
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccEvaluationitemDAO.insert(target);
        return "200";
    }

    /**
     * 修改评测项目
     * @return
     */
    @Override
    public String editEvaluationItem(TCCEvaluationitem target) {
        target.setEndDate(new Timestamp(System.currentTimeMillis()));
        tccEvaluationitemDAO.updateByPrimaryKey(target);
        return "200";
    }

    /**
     * 删除评测项目
     * @return
     */
    @Override
    public String delEvaluationItem(String id) {
        tccEvaluationitemDAO.deleteByPrimaryKey(id);
        return null;
    }
}
