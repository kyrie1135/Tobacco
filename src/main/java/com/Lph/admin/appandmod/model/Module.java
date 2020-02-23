package com.Lph.admin.appandmod.model;

import java.io.Serializable;

/**
 * module
 * 主要功能： 为主页面左侧菜单栏提供子菜单
 * @author 
 */
public class Module implements Serializable {
    private String moduleCode;

    private String moduleName;

    private String moduleAppid;

    private String moduleUrl;

    private static final long serialVersionUID = 1L;

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleAppid() {
        return moduleAppid;
    }

    public void setModuleAppid(String moduleAppid) {
        this.moduleAppid = moduleAppid;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }
}