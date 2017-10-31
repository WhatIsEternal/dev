package com.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Qx implements Serializable {
    private int id;
    private String name1;
    @JSONField(name="_parentId")
    private String _parentId;
    private String url;

    public Qx() {
    }

    public Qx(int id, String name1, String _parentId, String url) {
        this.id = id;
        this.name1 = name1;
        this._parentId = _parentId;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getName1() {
        return name1;
    }

    public String get_parentId() {
        return _parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void set_parentId(String _parentId) {
        this._parentId = _parentId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
