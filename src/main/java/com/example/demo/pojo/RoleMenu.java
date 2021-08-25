package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "role_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class RoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    int rid;
    int mid;

    public int getId() {
        return id;
    }

    public RoleMenu setId(int id) {
        this.id = id;
        return this;
    }

    public int getRid() {
        return rid;
    }

    public RoleMenu setRid(int rid) {
        this.rid = rid;
        return this;
    }

    public int getMid() {
        return mid;
    }

    public RoleMenu setMid(int mid) {
        this.mid = mid;
        return this;
    }
}
