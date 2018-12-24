package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aegis
 * @date 2018-12-24 17:50
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${from}")
    String name;

    @RequestMapping("/test")
    public String test() {
        return name;
    }
}
