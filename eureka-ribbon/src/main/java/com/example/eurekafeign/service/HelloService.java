package com.example.eurekafeign.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Date;

/**
 * @author aegis
 * @date 2018-12-18 13:02
 */
@Service
@SessionScope
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(groupKey = "group1", commandKey = "hiService1")
    public String hiService1(String name) {
        System.out.println("hiService1 : " + new Date());
        return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
    }

    @CacheRemove(commandKey = "hiService")
    @HystrixCommand(groupKey = "group1", commandKey = "helloService1")
    public String helloService1(String name) {
        return restTemplate.getForObject("http://service-hi/hello?name=" + name, String.class);
    }


    public String myCacheKeyMethod(String name) {
        return name;
    }

}
