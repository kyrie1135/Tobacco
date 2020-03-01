package com.Lph.project.samplebright.bright.service.impl;

import com.Lph.project.samplebright.bright.dao.TBCClientDAO;
import com.Lph.project.samplebright.bright.model.TBCClientExample;
import com.Lph.project.samplebright.bright.service.BrightService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BrightServiceImpl implements BrightService {

    @Autowired
    private TBCClientDAO tbcClientDAO;
    /**
     * 获取路段， 为督查抽样界面填充路段select
     */
    @Override
    public List<String> getLines(String type) {
        List<String> lines = new ArrayList<>();
        TBCClientExample example = new TBCClientExample();
        TBCClientExample.Criteria criteria = example.createCriteria();

        return null;
    }
}
