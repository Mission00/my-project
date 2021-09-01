package com.example.demo.pojo;

import lombok.ToString;

import java.util.List;

@ToString
public class Admin {
    private int id;
    private String adminname;
    private String password;
    private String remarks;
    private Boolean isUsed;
    private List<Role> roles;


    public List<Role> getRoles() {
        return roles;
    }

    public Admin setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Boolean getisUsed() {
        return isUsed;
    }

    public Admin setisUsed(Boolean isUsed) {
        this.isUsed = isUsed;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
