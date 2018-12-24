package com.example.eurekaclient2.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author aegis
 * @date 2018-12-17 21:08
 */
@RestController
public class FirstController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "example") String name) {
        System.out.println(request);
        return "hi" + name + ",i am from port:" + port;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "example") String name) {
        return "hello" + name + ",i am from port:" + port;
    }

}
