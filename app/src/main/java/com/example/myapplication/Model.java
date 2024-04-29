package com.example.myapplication;

public class Model {
    String Name,Email,Gender,Code,Number,Address,Size,Item;
    public Model() {
    }

    public Model(String name, String email, String gender, String code, String number, String address, String size, String item) {
        Name = name;
        Email = email;
        Gender = gender;
        Code = code;
        Number = number;
        Address = address;
        Size = size;
        Item = item;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public Object getAdmin() {
        return null;
    }
}
