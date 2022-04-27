package com.example.btlandroidnhom6.model;

import java.io.Serializable;
import java.util.List;

public class ResponeProduct implements Serializable {
    private List<Product> data;
    private int statusCode;

    public ResponeProduct(List<Product> data, int statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
