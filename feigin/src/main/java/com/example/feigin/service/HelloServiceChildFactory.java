package com.example.feigin.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author aegis
 * @date 2018-12-23 15:07
 */
@Component
public class HelloServiceChildFactory implements FallbackFactory<HelloServiceChild> {

    @Override
    public HelloServiceChild create(Throwable throwable) {
        return new HelloServiceWithFactory() {
            @Override
            public String sayHiFromClient2(String name) {
                return "HelloServiceChildFactory";
            }
        };
    }
}
