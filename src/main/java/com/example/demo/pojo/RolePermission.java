package com.example.demo.pojo;

import lombok.ToString;

@ToString
public class RolePermission {
    int id;
    int rid;
    int pid;

    public int getId() {
        return id;
    }

    public RolePermission setId(int id) {
        this.id = id;
        return this;
    }

    public int getRid() {
        return rid;
    }

    public RolePermission setRid(int rid) {
        this.rid = rid;
        return this;
    }

    public int getPid() {
        return pid;
    }

    public RolePermission setPid(int pid) {
        this.pid = pid;
        return this;
    }
}
