package com.example.btlandroidnhom6.model;

public class Respone {
    private  String message;
    private  User data;

    public Respone(String message, User user) {
        this.message = message;
        this.data = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return data;
    }

    public void setUser(User user) {
        this.data = user;
    }
}
