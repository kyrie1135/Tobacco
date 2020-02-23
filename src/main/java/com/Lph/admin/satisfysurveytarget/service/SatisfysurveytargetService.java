package com.Lph.admin.satisfysurveytarget.service;

import com.Lph.admin.satisfysurveytarget.model.TCCSatisfysurveytarget;

import java.util.List;

public interface SatisfysurveytargetService {
    /**
     * 获得指标维护table
     * @return
     */
    public List<TCCSatisfysurveytarget> getTable();
}
