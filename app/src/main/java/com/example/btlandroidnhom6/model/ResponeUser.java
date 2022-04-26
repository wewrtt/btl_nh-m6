package com.example.btlandroidnhom6.model;

import java.util.ArrayList;
import java.util.List;

public class ResponeUser {
    private  int statusCode;
    private List<User> data;

    public ResponeUser(int statusCode, List<User> data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public ResponeUser() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
