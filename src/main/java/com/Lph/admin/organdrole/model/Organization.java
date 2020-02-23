package com.Lph.admin.organdrole.model;

import java.io.Serializable;

/**
 * organdrole
 * 主要功能： 提供选择岗位功能
 * @author 
 */
public class Organization implements Serializable {
    private String id;

    private String pid;

    private String name;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}