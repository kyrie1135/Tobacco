package com.Lph.admin.appandmod.service;

import com.Lph.admin.appandmod.model.Application;
import com.Lph.admin.appandmod.model.Module;

import java.util.List;

public interface AppAndModService {

    public List<Application> getMenuApp();

    public List<Module> getMenuMod();
}
