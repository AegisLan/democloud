package com.example.eurekaclient.web;

import com.example.eurekaclient.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author aegis
 * @date 2018-12-17 21:08
 */
@RestController
public class FirstController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String sayHiFromClientOne(@RequestParam(value = "name", defaultValue = "example") String name) {

        System.out.println("hi is been call:" + new Date());
        return "hi" + name + ",i am from port:" + port;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "example") String name) {
        System.out.println("hello is been call:" + new Date());
        return "hello" + name + ",i am from port:" + port;
    }

    @RequestMapping("/student")
    public String student(@RequestParam(value = "name", defaultValue = "example") String name, @RequestBody Student student) {
        System.out.println("hello is been call:" + new Date());
        System.out.println(student.toString());
        return "hello" + name + ",i am from port:" + port;
    }

}
