package com.Lph.project.resultinput.input.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_c_c_clientsatisfysurvey
 * @author 
 */
public class TCCClientsatisfysurvey implements Serializable {
    private String bickid;

    private String subscriptBickid;

    private String deptName;

    private String clientCode;

    private String clientName;

    private Date inputDate;

    private Date getDate;

    private String inputer;

    private String geter;

    private Integer isOver;

    private static final long serialVersionUID = 1L;

    public String getBickid() {
        return bickid;
    }

    public void setBickid(String bickid) {
        this.bickid = bickid;
    }

    public String getSubscriptBickid() {
        return subscriptBickid;
    }

    public void setSubscriptBickid(String subscriptBickid) {
        this.subscriptBickid = subscriptBickid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public String getInputer() {
        return inputer;
    }

    public void setInputer(String inputer) {
        this.inputer = inputer;
    }

    public String getGeter() {
        return geter;
    }

    public void setGeter(String geter) {
        this.geter = geter;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }
}