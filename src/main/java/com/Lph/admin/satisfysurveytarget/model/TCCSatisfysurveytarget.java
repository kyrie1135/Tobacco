package com.Lph.admin.satisfysurveytarget.model;

import java.io.Serializable;

/**
 * t_c_c_satisfysurveytarget
 * 主要功能： 评分标准增删改查（满意， 比较满意。。。）
 * @author 
 */
public class TCCSatisfysurveytarget implements Serializable {
    private String bickid;

    private Double evaluateTarget;

    private String evaluateStandard;

    private static final long serialVersionUID = 1L;

    public String getBickid() {
        return bickid;
    }

    public void setBickid(String bickid) {
        this.bickid = bickid;
    }

    public Double getEvaluateTarget() {
        return evaluateTarget;
    }

    public void setEvaluateTarget(Double evaluateTarget) {
        this.evaluateTarget = evaluateTarget;
    }

    public String getEvaluateStandard() {
        return evaluateStandard;
    }

    public void setEvaluateStandard(String evaluateStandard) {
        this.evaluateStandard = evaluateStandard;
    }
}