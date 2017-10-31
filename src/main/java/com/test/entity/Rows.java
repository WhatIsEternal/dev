package com.test.entity;

import java.io.Serializable;
import java.util.List;

public class Rows implements Serializable {
    private List<Qx> rows;

    public Rows() {
    }

    public Rows(List<Qx> rows) {
        this.rows = rows;
    }

    public void setRows(List<Qx> rows) {
        this.rows = rows;
    }

    public List<Qx> getRows() {
        return rows;
    }
}
