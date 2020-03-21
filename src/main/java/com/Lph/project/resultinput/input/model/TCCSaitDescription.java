package com.Lph.project.resultinput.input.model;

import java.io.Serializable;
import java.util.List;

/**
 * t_c_c_sait_description
 * @author 
 */
public class TCCSaitDescription implements Serializable {
    private String bickid;

    private String satisfysurveytargetBickid;

    private String subscriptBickid;

    private String clientCode;

    private String month;

    private List<String> des;

    private List<String> zhibiaoNames;

    private List<String> desBickids;

    public List<String> getDesBickids() {
        return desBickids;
    }

    public void setDesBickids(List<String> desBickids) {
        this.desBickids = desBickids;
    }

    public List<String> getDes() {
        return des;
    }

    public void setDes(List<String> des) {
        this.des = des;
    }

    public List<String> getZhibiaoNames() {
        return zhibiaoNames;
    }

    public void setZhibiaoNames(List<String> zhibiaoNames) {
        this.zhibiaoNames = zhibiaoNames;
    }

    private static final long serialVersionUID = 1L;

    public String getBickid() {
        return bickid;
    }

    public void setBickid(String bickid) {
        this.bickid = bickid;
    }

    public String getSatisfysurveytargetBickid() {
        return satisfysurveytargetBickid;
    }

    public void setSatisfysurveytargetBickid(String satisfysurveytargetBickid) {
        this.satisfysurveytargetBickid = satisfysurveytargetBickid;
    }

    public String getSubscriptBickid() {
        return subscriptBickid;
    }

    public void setSubscriptBickid(String subscriptBickid) {
        this.subscriptBickid = subscriptBickid;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}