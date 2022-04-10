package com.example.btlandroidnhom6.model;

import android.widget.Toast;

import com.example.btlandroidnhom6.login_registor.Registor;

public class User {
    private String fullName,userName,passWord,email;
    private String _id;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.passWord = password;
    }

    public User(String fullName, String userName, String password, String email) {
        this.fullName = fullName;
        this.userName = userName;
        this.passWord = password;
        this.email = email;
    }

    public User(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.passWord = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "User{" +

                "  id='" + _id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
