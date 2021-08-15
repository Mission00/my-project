package com.example.demo.pojo;

public class Admin {
    private int id;
    private String adminname;
    private String password;
    private String remarks;
    private Boolean isUsed;

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
