package com.example.demo.pojo;


import lombok.ToString;

import java.util.List;


@ToString
public class Role {

    int id;
    String name;
    String name_zh;
    List<Permission> perms;
    List<Menu> menus;


    public List<Menu> getMenus() {
        return menus;
    }

    public Role setMenus(List<Menu> menus) {
        this.menus = menus;
        return this;
    }

    public List<Permission> getPerms() {
        return perms;
    }

    public Role setPerms(List<Permission> perms) {
        this.perms = perms;
        return this;
    }

    public int getId() {
        return id;
    }

    public Role setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getName_zh() {
        return name_zh;
    }

    public Role setName_zh(String name_zh) {
        this.name_zh = name_zh;
        return this;
    }
}
