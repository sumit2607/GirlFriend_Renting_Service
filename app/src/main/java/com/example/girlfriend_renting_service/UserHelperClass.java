package com.example.girlfriend_renting_service;

public class UserHelperClass {
    String name,email,adhar, age,password;

    public UserHelperClass() {
    }

    public UserHelperClass(String name, String email, String adhar, String age, String password) {
        this.name = name;
        this.email = email;
        this.adhar = adhar;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
