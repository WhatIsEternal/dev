package com.test.entity;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class User {
    private int uid;
    private String account;
    private String pwd;
    private Role role;
    public User() {
    }

    public User(int uid, String account, String pwd, Role role) {
        this.uid = uid;
        this.account = account;
        this.pwd = pwd;
        this.role = role;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
