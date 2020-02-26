package com.Lph.admin.evaluationitem.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * t_c_c_evaluationitem
 * @author 
 */
public class TCCEvaluationitem implements Serializable {
    private String bickid;

    @NotBlank(message = "项目名称不能为空")
    private String itemName;

    private String itemCode;

    private Date creDate;

    private Date endDate;

    private static final long serialVersionUID = 1L;

    public String getBickid() {
        return bickid;
    }

    public void setBickid(String bickid) {
        this.bickid = bickid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}