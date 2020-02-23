package com.Lph.admin.appandmod.service;

import com.Lph.admin.appandmod.model.Application;
import com.Lph.admin.appandmod.model.Module;

import java.util.List;

public interface AppAndModService {

    /**
     * 获得所有父级菜单  App
     * @return
     */
    public List<Application> getMenuApp();

    /**
     * 获得所有子菜单  Mod
     * @return
     */
    public List<Module> getMenuMod();
}
