package com.Lph.admin.satisfysurveytarget.service.impl;

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
        System.out.println(list);
        return list;
    }
}
