package com.example.btlandroidnhom6.model;

public class Respone {
    private  int statusCode;
    private  Object data;

    public Respone(int statusCode, Object data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Respone() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
