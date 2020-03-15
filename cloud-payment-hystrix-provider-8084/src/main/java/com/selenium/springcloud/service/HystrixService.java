package com.selenium.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    public String requestOk() {
        return "ok";
    }

    /**
     * 服务降级
     */
    @HystrixCommand(fallbackMethod = "requestErrorHandler")
    public String requestError() {
        int a = 10 / 0;
        return "request Error" + a;
    }

    /**
     * 服务熔断:在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     */
    @HystrixCommand(fallbackMethod = "requestBreakHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String requestBreak(int id) {
        int a = 10 / id;
        return "test break: " + a;
    }

    /***
     *触发服务降级后执行此方法
     */
    public String requestErrorHandler() {
        return "CLOUD-PAYMENT-HYSTRIX-SERVICE:8004:request Error fallback";
    }

    /***
     *触发服务熔断后执行此方法
     */
    public String requestBreakHandler(int id) {
        return "CLOUD-PAYMENT-HYSTRIX-SERVICE:8004:request Error Break:" + id;
    }
}
