package com.test.entity;

import java.io.Serializable;

public class OrderReturn  implements Serializable{
    private int id;
    private String ordercode;
    private String own_account;
    private String createorder_time;
    private int return_status;
    private String createreturn_time;
    private String status;

    public OrderReturn() {
    }

    public OrderReturn(int id, String ordercode, String own_account, String createorder_time, int return_status, String createreturn_time, String status) {
        this.id = id;
        this.ordercode = ordercode;
        this.own_account = own_account;
        this.createorder_time = createorder_time;
        this.return_status = return_status;
        this.createreturn_time = createreturn_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOwn_account() {
        return own_account;
    }

    public void setOwn_account(String own_account) {
        this.own_account = own_account;
    }

    public String getCreateorder_time() {
        return createorder_time;
    }

    public void setCreateorder_time(String createorder_time) {
        this.createorder_time = createorder_time;
    }

    public int getReturn_status() {
        return return_status;
    }

    public void setReturn_status(int return_status) {
        this.return_status = return_status;
    }

    public String getCreatereturn_time() {
        return createreturn_time;
    }

    public void setCreatereturn_time(String createreturn_time) {
        this.createreturn_time = createreturn_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
