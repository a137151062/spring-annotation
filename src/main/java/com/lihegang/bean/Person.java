package com.lihegang.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by dong-er on 2019-08-04.
 */
public class Person {
    private String age;
    private String name;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {

    }

    public Person(String age, String name, String nickName) {
        this.age = age;
        this.name = name;
        this.nickName = nickName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
