package com.Lph.project.samplebright.bright.model;

import java.io.Serializable;

/**
 * t_b_c_client
 * @author 
 */
public class TBCClient implements Serializable {
    private String clientCode;

    private String facilityNum;

    private String clientName;

    private String vsLine;

    private String callLine;

    private String deliverLine;

    private String bigCorpCode;

    private String clientTypeCode;

    private String workState;

    private String clientMgr;

    private static final long serialVersionUID = 1L;

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getFacilityNum() {
        return facilityNum;
    }

    public void setFacilityNum(String facilityNum) {
        this.facilityNum = facilityNum;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVsLine() {
        return vsLine;
    }

    public void setVsLine(String vsLine) {
        this.vsLine = vsLine;
    }

    public String getCallLine() {
        return callLine;
    }

    public void setCallLine(String callLine) {
        this.callLine = callLine;
    }

    public String getDeliverLine() {
        return deliverLine;
    }

    public void setDeliverLine(String deliverLine) {
        this.deliverLine = deliverLine;
    }

    public String getBigCorpCode() {
        return bigCorpCode;
    }

    public void setBigCorpCode(String bigCorpCode) {
        this.bigCorpCode = bigCorpCode;
    }

    public String getClientTypeCode() {
        return clientTypeCode;
    }

    public void setClientTypeCode(String clientTypeCode) {
        this.clientTypeCode = clientTypeCode;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getClientMgr() {
        return clientMgr;
    }

    public void setClientMgr(String clientMgr) {
        this.clientMgr = clientMgr;
    }
}