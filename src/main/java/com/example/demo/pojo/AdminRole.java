package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

public class AdminRole {

    int id;
    int aid;
    int rid;

    public int getId() {
        return id;
    }

    public AdminRole setId(int id) {
        this.id = id;
        return this;
    }

    public int getAid() {
        return aid;
    }

    public AdminRole setAid(int aid) {
        this.aid = aid;
        return this;
    }

    public int getRid() {
        return rid;
    }

    public AdminRole setRid(int rid) {
        this.rid = rid;
        return this;
    }
}
