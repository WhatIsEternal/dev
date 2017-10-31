package com.test.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class OrdersPic implements Serializable{
    private int m;
    private int num;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public OrdersPic() {
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
