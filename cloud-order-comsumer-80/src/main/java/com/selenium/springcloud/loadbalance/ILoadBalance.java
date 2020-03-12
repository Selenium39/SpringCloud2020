package com.selenium.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ILoadBalance {
    ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
