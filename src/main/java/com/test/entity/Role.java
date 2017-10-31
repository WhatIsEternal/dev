package com.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {
    private int rid;
    @JSONField(name = "text")
    private  String role_name;
    @JSONField(name = "children")
    private Set<Perm> perms;
    public Role() {
    }

    public Role(int rid, String role_name, Set<Perm> perms) {
        this.rid = rid;
        this.role_name = role_name;
        this.perms = perms;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setPerms(Set<Perm> perms) {
        this.perms = perms;
    }

    public int getRid() {
        return rid;
    }

    public String getRole_name() {
        return role_name;
    }

    public Set<Perm> getPerms() {
        return perms;
    }
}
