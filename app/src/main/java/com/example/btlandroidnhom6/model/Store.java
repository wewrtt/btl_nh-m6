package com.example.btlandroidnhom6.model;

import java.io.Serializable;

public class Store implements Serializable {
    private String address,description,email,name,phoneNumber,userId,imageUrl,_id;
    private Boolean isRoot;

    public Store(String address, String description, String email, Boolean isRoot, String name, String phoneNumber, String userId, String imageUrl) {
        this.address = address;
        this.description = description;
        this.email = email;
        this.isRoot = isRoot;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.imageUrl = imageUrl;
    }

    public Store() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRoot() {
        return isRoot;
    }

    public void setRoot(Boolean root) {
        isRoot = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}