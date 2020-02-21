package com.Lph.admin.Utils.Test.model;

import java.io.Serializable;

/**
 * org
 * @author 
 */
public class Org implements Serializable {
    private Integer uuid;

    private String id;

    private String pid;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

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