package com.example.demo.pojo;


import lombok.ToString;
import org.springframework.data.annotation.Transient;

import java.util.List;

@ToString
public class Menu {

    int id;
    String path;
    String name;

    String nameZh;
    String iconCls;
    String component;
    int parentId;
    @Transient
    private List<Menu> children;

    public int getId() {
        return id;
    }

    public Menu setId(int id) {
        this.id = id;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Menu setPath(String path) {
        this.path = path;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getNameZh() {
        return nameZh;
    }

    public Menu setNameZh(String nameZh) {
        this.nameZh = nameZh;
        return this;
    }

    public String getIconCls() {
        return iconCls;
    }

    public Menu setIconCls(String iconCls) {
        this.iconCls = iconCls;
        return this;
    }

    public String getComponent() {
        return component;
    }

    public Menu setComponent(String component) {
        this.component = component;
        return this;
    }

    public int getParentId() {
        return parentId;
    }

    public Menu setParentId(int parentId) {
        this.parentId = parentId;
        return this;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public Menu setChildren(List<Menu> children) {
        this.children = children;
        return this;
    }


}
