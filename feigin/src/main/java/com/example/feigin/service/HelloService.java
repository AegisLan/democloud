package com.example.feigin.service;


import com.example.feigin.model.Student;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @CacheResult
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    String student(@RequestParam(value = "name", defaultValue = "example") String name, @RequestBody Student student);
}