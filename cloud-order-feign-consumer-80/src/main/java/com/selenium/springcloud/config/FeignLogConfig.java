package com.selenium.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 设置Feign的日志级别
 */
@Configuration
public class FeignLogConfig {
    @Bean
    public Logger.Level getFeignLogLever() {
        return Logger.Level.FULL;
    }
}
