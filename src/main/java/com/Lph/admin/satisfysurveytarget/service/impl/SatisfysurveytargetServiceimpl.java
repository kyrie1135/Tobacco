package com.Lph.admin.satisfysurveytarget.service.impl;

import com.Lph.admin.Utils.IdUtil;
import com.Lph.admin.satisfysurveytarget.dao.TCCSatisfysurveytargetDAO;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;
import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytargetExample;
import com.Lph.admin.satisfysurveytarget.service.SatisfysurveytargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SatisfysurveytargetServiceimpl implements SatisfysurveytargetService {

    @Autowired
    private TCCSatisfysurveytargetDAO tccSatisfysurveytargetDAO;

    /**
     * 获得指标维护table
     * @return
     */
    @Override
    public List<TCCSatisfysurveytarget> getTable() {
        TCCSatisfysurveytargetExample example = new TCCSatisfysurveytargetExample();
        List<TCCSatisfysurveytarget> list= new ArrayList<>();
        list = tccSatisfysurveytargetDAO.selectByExample(example);
        return list;
    }

    /**
     * 评分标准维护-》添加弹窗-》确定
     * 添加评分标准
     */
    @Override
    public String addStandard(TCCSatisfysurveytarget target) {
        target.setBickid(IdUtil.nextId());
        tccSatisfysurveytargetDAO.insert(target);
        return "200";
    }

    /**
     * 评分标准维护-》确认删除弹窗-》确定
     * 删除评分标准
     */
    @Override
    public String delStandard(String id) {
        tccSatisfysurveytargetDAO.deleteByPrimaryKey(id);
        return "200";
    }

    /**
     * 评分标准维护-》修改弹窗-》确定
     * 删除评分标准
     */
    @Override
    public String editStandard(TCCSatisfysurveytarget target) {
        tccSatisfysurveytargetDAO.updateByPrimaryKeySelective(target);
        return "200";
    }
}
