package com.fuxing.style.model;

public class User {
    private Integer id;

    private String name;

    private String sex;

    public User(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}