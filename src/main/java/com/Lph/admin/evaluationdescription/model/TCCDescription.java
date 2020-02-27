package com.Lph.admin.evaluationdescription.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * t_c_c_description
 * @author 
 */
public class TCCDescription implements Serializable {
    private String bickid;

    @NotBlank(message = "所属测评项目不能为空")
    private String belongItemId;

    @NotBlank(message = "评测指标名称不能为空")
    private String itemName;

    @NotBlank(message = "评测指标描述不能为空")
    private String description;

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

    public String getBelongItemId() {
        return belongItemId;
    }

    public void setBelongItemId(String belongItemId) {
        this.belongItemId = belongItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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