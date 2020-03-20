package com.Lph.admin.appandmod.service.impl;

import com.Lph.admin.appandmod.dao.ApplicationDAO;
import com.Lph.admin.appandmod.dao.ModuleDAO;
import com.Lph.admin.appandmod.model.Application;
import com.Lph.admin.appandmod.model.ApplicationExample;
import com.Lph.admin.appandmod.model.Module;
import com.Lph.admin.appandmod.model.ModuleExample;
import com.Lph.admin.appandmod.service.AppAndModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能和模块
 * 主要功能： 为主页面左侧菜单栏填充内容
 */
@Service
public class AppAndModServiceImpl implements AppAndModService {

    @Autowired
    private ApplicationDAO applicationDAO;
    @Autowired
    private ModuleDAO moduleDAO;

    /**
     * 获得所有父级菜单  App
     * @return
     */
    @Override
    public List<Application> getMenuApp() {
        ApplicationExample example = new ApplicationExample();
        example.setOrderByClause("`app_num` ASC");
        return applicationDAO.selectByExample(example);
    }

    /**
     * 获得所有子菜单  Mod
     * @return
     */
    @Override
    public List<Module> getMenuMod() {
        ModuleExample example = new ModuleExample();
        return moduleDAO.selectByExample(example);
    }
}
