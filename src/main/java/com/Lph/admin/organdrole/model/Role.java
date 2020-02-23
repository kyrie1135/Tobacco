package com.Lph.admin.organdrole.model;

import java.io.Serializable;

/**
 * role
 * 主要功能： 提供选择角色功能
 * @author 
 */
public class Role implements Serializable {
    private String id;

    private String orgid;

    private String name;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}