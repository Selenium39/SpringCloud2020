package com.selenium.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过编码配置Gateway路由
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator getCustomRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("route3",
                r -> r.path("/baidu")
                        .uri("https://www.baidu.com/"))
                .build();
        return routes.build();
    }
}
