package com.example.whatsapptema;

import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "pass")
    private String pass;
    @ColumnInfo(name = "pass_conf")
    private String passConf;

    public User(String email, String phone, String pass, String passConf) {
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.passConf = passConf;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", pass='" + pass + '\'' +
                ", passConf='" + passConf + '\'' +
                '}';
    }
}
