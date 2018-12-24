package com.example.eurekafeign;

import com.ribbon.HelloConfig;
import com.ribbon.HiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClients(
        value = {
                @RibbonClient(name = "service-hi", configuration = HiConfig.class),
                @RibbonClient(name = "service-hello", configuration = HelloConfig.class)
        }
)
@EnableCircuitBreaker
public class EurekaRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean hystrixRequestContextServletFilter() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HystrixRequestContextServletFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("hystrixRequestContextServletFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

