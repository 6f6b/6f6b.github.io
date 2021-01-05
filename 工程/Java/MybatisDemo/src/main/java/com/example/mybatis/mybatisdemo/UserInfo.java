package com.example.mybatis.mybatisdemo;

public class UserInfo {
    String userName;
    String password;
    String idcard;
    String email;
    String name;
    String address;
    int sex;
    String phone;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", idcard='" + idcard + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                '}';
    }
}
