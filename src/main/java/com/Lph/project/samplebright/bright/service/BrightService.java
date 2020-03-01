package com.Lph.project.samplebright.bright.service;

import java.util.List;

public interface BrightService {

    /**
     * 获取路段， 为督查抽样界面填充路段select
     */
    public List<String> getLines(String type);
}
