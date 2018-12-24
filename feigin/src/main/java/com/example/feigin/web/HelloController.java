package com.example.feigin.web;

import com.example.feigin.model.Student;
import com.example.feigin.service.HelloServiceChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aegis
 * @date 2018-12-18 13:03
 */
@RestController
public class HelloController {

    @Autowired
    HelloServiceChild helloServiceChild;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {

        return helloServiceChild.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloServiceChild.sayHiFromClient2(name);
    }

    @RequestMapping(value = "/student")
    public String student(@RequestParam String name) {

        Student student = new Student();
        student.setName(name);
        student.setAge(25);
        return helloServiceChild.student(name, student);
    }
}
