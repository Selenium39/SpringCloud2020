package com.selenium.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 相当于applicationContext.xml
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced注解提供了RestTemplate负载均衡的能力
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
