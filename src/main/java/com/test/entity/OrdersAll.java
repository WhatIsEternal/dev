package com.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class OrdersAll {
    private String id;
    private String code;
    private float total;
    private int num;
    private String title;
    @JSONField(format = "yyyy-MM-dd kk:mm:ss")
    private Date createTime;
    private String   owner;
    private int ship_status;
    public OrdersAll() {
    }

    public OrdersAll(String id, String code, float total, int num, String title, Date createTime, String owner, int ship_status) {
        this.id = id;
        this.code = code;
        this.total = total;
        this.num = num;
        this.title = title;
        this.createTime = createTime;
        this.owner = owner;
        this.ship_status = ship_status;
    }

    public int getShip_status() {
        return ship_status;
    }

    public void setShip_status(int ship_status) {
        this.ship_status = ship_status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "OrdersAll{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", total=" + total +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", owner='" + owner + '\'' +
                '}';
    }
}
