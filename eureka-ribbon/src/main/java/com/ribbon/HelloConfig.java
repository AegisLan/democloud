package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @author aegis
 * @date 2018-12-20 15:29
 */
public class HelloConfig {

    @Bean
    public IRule roundRobinRule() {
        return new RoundRobinRule();
    }
}
