package com.example.feigin.service;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author aegis
 * @date 2018-12-19 21:45
 */
@FeignClient(value = "service-hi", fallbackFactory = HelloServiceChildFactory.class)
public interface HelloServiceChild extends HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @CacheResult
    String sayHiFromClient2(@RequestParam(value = "name") String name);
}
