package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author aegis
 * @date 2018-12-20 15:30
 */
public class HiConfig {

    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
