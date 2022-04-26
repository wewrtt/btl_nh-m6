package com.example.btlandroidnhom6.model;

import java.util.List;

public class ResponseStore {
    private List<Store> data;
    private int statusCode;

    public ResponseStore(List<Store> storeList, int statusCode) {
        this.data = storeList;
        this.statusCode = statusCode;
    }

    public ResponseStore() {
    }

    public List<Store> getData() {
        return data;
    }

    public void setData(List<Store> data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
