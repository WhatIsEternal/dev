package com.test.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private  String id;
    private  String code;
    private  float total;
    private String owner;
    private String createTime;
    private int status;
    private int pay_status;
    private int ship_status;

    public Order() {
    }

    public Order(String id, String code, float total, String owner, String createTime, int status, int pay_status, int ship_status) {
        this.id = id;
        this.code = code;
        this.total = total;
        this.owner = owner;
        this.createTime = createTime;
        this.status = status;
        this.pay_status = pay_status;
        this.ship_status = ship_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public int getShip_status() {
        return ship_status;
    }

    public void setShip_status(int ship_status) {
        this.ship_status = ship_status;
    }
}
