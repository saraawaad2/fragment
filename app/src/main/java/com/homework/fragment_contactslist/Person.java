package com.homework.fragment_contactslist;

public class Person {
    private String name;
    private String phone;
    private int image;

    public Person(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
