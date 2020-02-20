package com.Lph.admin.Utils;

public class Node {
    String id;
    String pid;
    String text;

    public Node() {
    }

    public Node(String id, String pid, String text) {
        this.id = id;
        this.pid = pid;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
