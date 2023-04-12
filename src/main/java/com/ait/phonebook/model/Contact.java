package com.ait.phonebook.model;

public class Contact {
  private   String name;
  private  String surename;
 private  String phone;
  private  String email;
  private  String address;
   private String desc;

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDesc() {
        return desc;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setSurename(String surename) {
        this.surename = surename;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}