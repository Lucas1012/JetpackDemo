package com.lucas.jetpackdemo.bean;

import java.io.Serializable;

/**
 * Author: LucasCui
 * E-mail: 18410140018@163.com
 * Date: 2020/3/17
 * Description:
 */
public class User implements Serializable{

    private static final long serialVersionUID = -9188587891707725811L;
    public String name;
    public int age;

    public User(String name, int age){

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){

        return "User{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}
