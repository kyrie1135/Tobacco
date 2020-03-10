package com.Lph.admin.subscript.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_c_c_clientsatisfy
 * @author 
 */
public class TCCClientsatisfy implements Serializable {
    private String bickid;

    @NotBlank(message = "指标归类不能为空")
    private String targetSort;

    //弃用：当修改评测项目后， 此处评测项目名称未修改
    @NotBlank(message = "评测项目不能为空")
    private String evaluateItem;

    @NotBlank(message = "评测项目bickid不能为空")
    private String evaluateItemBickid;

    //弃用：当修改评测指标后， 此处评测指标名称未修改
    @NotBlank(message = "评测指标不能为空")
    private String evaluateTarget;

    @NotBlank(message = "评测指标bickid不能为空")
    private String evaluateTargetBickid;

    @NotBlank(message = "是否启用不能为空")
    private String isUse;

    @NotBlank(message = "评价周期不能为空")
    private String evaluateCyc;

    @NotNull(message = "权重不能为空")
    private BigDecimal proportion;

    @NotBlank(message = "调查人员不能为空")
    private String empRole;

    private Date creDate;

    private Date endDate;

    private Integer deleted;

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

    public String getEvaluateItemBickid() {
        return evaluateItemBickid;
    }

    public void setEvaluateItemBickid(String evaluateItemBickid) {
        this.evaluateItemBickid = evaluateItemBickid;
    }

    public String getEvaluateTarget() {
        return evaluateTarget;
    }

    public void setEvaluateTarget(String evaluateTarget) {
        this.evaluateTarget = evaluateTarget;
    }

    public String getEvaluateTargetBickid() {
        return evaluateTargetBickid;
    }

    public void setEvaluateTargetBickid(String evaluateTargetBickid) {
        this.evaluateTargetBickid = evaluateTargetBickid;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}