package com.Lph.admin.appandmod.model;

import java.io.Serializable;

/**
 * application
 * @author 
 */
public class Application implements Serializable {
    private String appCode;

    private String appName;

    private static final long serialVersionUID = 1L;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}