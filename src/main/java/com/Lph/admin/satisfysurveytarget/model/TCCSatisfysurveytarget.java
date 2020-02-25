package com.Lph.admin.satisfysurveytarget.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * t_c_c_satisfysurveytarget
 * 主要功能： 评分标准增删改查（满意， 比较满意。。。）
 * @author 
 */
public class TCCSatisfysurveytarget implements Serializable {

    private String bickid;
    @NotNull(message = "评测指标分值不能为空")
    private Double evaluateTarget;
    @NotBlank(message = "评测指标不能为空")
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