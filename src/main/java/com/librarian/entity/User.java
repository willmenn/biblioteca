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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public String getPassword() {
        return password;
    }
}
