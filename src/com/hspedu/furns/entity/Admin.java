package com.hspedu.furns.entity;

/**
 * @author 金宗文
 * @version 1.0
 */
public class Admin {
    private Integer id;
    private String adminName;
    private String password;

    public Admin() {
    }

    public Admin(Integer id, String adminName, String password) {
        this.id = id;
        this.adminName = adminName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
