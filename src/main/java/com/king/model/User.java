package com.king.model;

/**
 * Created by king on 2017/8/14.
 */
public class User {
    private String name;
    private int age;

    public User(String name,int age){
        setName(name);
        setAge(age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
