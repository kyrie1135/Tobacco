package com.Lph.admin.Utils;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;

/**
 * bootstrap treeview所需Node类
 */
public class Node implements Serializable {
    private String id;
    private String parentId;
    private String text;

    private Integer orderIndex;
    private boolean lazyLoad=true;

    public Node(String id, String parentId, String text) {
        this.id = id;
        this.parentId = parentId;
        this.text = text;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public boolean isLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentid() {
        return parentId;
    }

    public void setParentid(String parentid) {
        this.parentId = parentid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
