package com.Lph.project.samplebright.bright.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_c_c_sample_bright
 * @author 
 */
public class TCCSampleBright implements Serializable {
    private String bickid;

    private String clientCode;

    private String clientName;

    private Date sampleData;

    private Integer deleted;

    private static final long serialVersionUID = 1L;

    public String getBickid() {
        return bickid;
    }

    public void setBickid(String bickid) {
        this.bickid = bickid;
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

    public Date getSampleData() {
        return sampleData;
    }

    public void setSampleData(Date sampleData) {
        this.sampleData = sampleData;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}