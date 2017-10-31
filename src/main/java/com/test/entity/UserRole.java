package com.test.entity;

import java.io.Serializable;

public class UserRole implements Serializable{
    private int uid;
    private String account;
    public int rid;
    private String role_name;

    public UserRole() {
    }

    public UserRole(int uid, String account, int rid, String role_name) {
        this.uid = uid;
        this.account = account;
        this.rid = rid;
        this.role_name = role_name;
    }

    public int getUid() {
        return uid;
    }

    public String getAccount() {
        return account;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setUid(int uid) {

        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
