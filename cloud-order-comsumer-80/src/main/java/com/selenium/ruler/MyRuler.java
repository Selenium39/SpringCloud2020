package com.selenium.ruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 替换Ribbon默认访问策略
 * 需要注意不要将它放在@ComponentScan的应用上下文中，否则它将被所有的@RibbonClients共享。
 */
@Configuration
public class MyRuler {
    @Bean
    public IRule getRuler() {
        return new RandomRule(); //随机访问
    }
}
