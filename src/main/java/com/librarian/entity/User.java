package com.librarian.entity;

public class User {

    private String name;
    private String email;
    private String phone;
    private String libNumber;
    private String password;

    public User(String name, String email, String phone, String libNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libNumber = libNumber;
        this.password = password;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", libNumber='" + libNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
