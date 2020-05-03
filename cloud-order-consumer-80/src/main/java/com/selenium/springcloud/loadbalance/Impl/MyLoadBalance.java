package com.selenium.springcloud.loadbalance.Impl;

import com.selenium.springcloud.loadbalance.ILoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class MyLoadBalance implements ILoadBalance {
    AtomicInteger atomicInteger;

    public MyLoadBalance() {
        this.atomicInteger = new AtomicInteger(0);
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        return instances.get(getServerInstanceIndex(instances));
    }

    public final Integer getServerInstanceIndex(List<ServiceInstance> instances) {
        int current;
        int next;
        for (; ; ) {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : (current + 1) % instances.size();
            if (this.atomicInteger.compareAndSet(current, next))
                return next;
        }
    }
}
