package com.Lph.admin.subscript.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_c_c_clientsatisfy
 * 主要功能： 评测指标维护
 * @author 
 */
public class SubscriptModel implements Serializable {
    private String bickid;

    private String targetSort;

    private String evaluateItem;

    private String evaluateTarget;

    private Integer isUse;

    private String evaluateCyc;

    private BigDecimal proportion;

    private String empRole;

    private static final long serialVersionUID = 1L;

    public String getBickid() {
        return bickid;
    }

    public void setBickid(String bickid) {
        this.bickid = bickid;
    }

    public String getTargetSort() {
        return targetSort;
    }

    public void setTargetSort(String targetSort) {
        this.targetSort = targetSort;
    }

    public String getEvaluateItem() {
        return evaluateItem;
    }

    public void setEvaluateItem(String evaluateItem) {
        this.evaluateItem = evaluateItem;
    }

    public String getEvaluateTarget() {
        return evaluateTarget;
    }

    public void setEvaluateTarget(String evaluateTarget) {
        this.evaluateTarget = evaluateTarget;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public String getEvaluateCyc() {
        return evaluateCyc;
    }

    public void setEvaluateCyc(String evaluateCyc) {
        this.evaluateCyc = evaluateCyc;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }
}