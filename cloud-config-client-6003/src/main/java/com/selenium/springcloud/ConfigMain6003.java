package com.selenium.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigMain6003 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain6003.class, args);
    }
}
