package com.example.whatsapptema;

import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private int phone;
    private String pass;
    private String passConf;

    public User(String email, int phone, String pass, String passConf) {
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.passConf = passConf;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassConf() {
        return passConf;
    }

    public void setPassConf(String passConf) {
        this.passConf = passConf;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", phone=" + phone +
                ", pass='" + pass + '\'' +
                ", passConf='" + passConf + '\'' +
                '}';
    }
}
