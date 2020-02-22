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

@Service
public class AppAndModServiceImpl implements AppAndModService {

    @Autowired
    private ApplicationDAO applicationDAO;
    @Autowired
    private ModuleDAO moduleDAO;

    @Override
    public List<Application> getMenuApp() {
        ApplicationExample example = new ApplicationExample();
        return applicationDAO.selectByExample(example);
    }

    @Override
    public List<Module> getMenuMod() {
        ModuleExample example = new ModuleExample();
        return moduleDAO.selectByExample(example);
    }
}
