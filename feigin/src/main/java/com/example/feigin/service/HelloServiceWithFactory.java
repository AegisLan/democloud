package com.example.feigin.service;

import com.example.feigin.model.Student;

/**
 * @author aegis
 * @date 2018-12-23 15:11
 */
public class HelloServiceWithFactory implements HelloServiceChild {
    @Override
    public String sayHiFromClient2(String name) {
        return "HelloServiceWithFactory sayHiFromClient2 : " + name;
    }

    @Override
    public String sayHiFromClientOne(String name) {
        return "HelloServiceWithFactory sayHiFromClientOne : " + name;
    }

    @Override
    public String student(String name, Student student) {
        return "HelloServiceWithFactory student : " + name;
    }
}
