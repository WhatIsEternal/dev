package com.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Perm implements Serializable {
    private int pid;
    @JSONField(name = "text")
    private  String perm_name;

    public Perm() {
    }

    public Perm(int pid, String perm_name) {
        this.pid = pid;
        this.perm_name = perm_name;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPerm_name(String perm_name) {
        this.perm_name = perm_name;
    }

    public int getPid() {
        return pid;
    }

    public String getPerm_name() {
        return perm_name;
    }
}
