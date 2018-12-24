package com.example.eurekafeign.web;

import com.example.eurekafeign.service.HelloService;
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
    HelloService helloService;


    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService1(name);
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloService.helloService1(name);
    }
}
