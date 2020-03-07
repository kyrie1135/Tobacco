package com.Lph.admin.login.model;

import java.io.Serializable;

/**
 * user_right
 * @author 
 */
public class UserRight implements Serializable {
    private String userRole;

    private String userRight;

    private static final long serialVersionUID = 1L;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRight() {
        return userRight;
    }

    public void setUserRight(String userRight) {
        this.userRight = userRight;
    }
}