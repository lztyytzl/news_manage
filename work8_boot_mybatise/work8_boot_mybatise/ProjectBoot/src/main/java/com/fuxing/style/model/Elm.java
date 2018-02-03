package com.fuxing.style.model;

public class Elm {
    private Integer id;

    private String storename;

    private String data;

    public Elm(Integer id, String storename, String data) {
        this.id = id;
        this.storename = storename;
        this.data = data;
    }

    public Elm() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}