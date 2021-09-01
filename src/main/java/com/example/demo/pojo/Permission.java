package com.example.demo.pojo;


import lombok.ToString;

@ToString
public class Permission {
    int id;
    String name;
    String desc;
    String url;

    public int getId() {
        return id;
    }

    public Permission setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Permission setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Permission setUrl(String url) {
        this.url = url;
        return this;
    }
}
