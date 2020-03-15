package com.selenium.springcloud.service;

import com.selenium.springcloud.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = OpenFeignOrderServiceFallback.class)
public interface OpenFeignOrderService {

    @GetMapping("/hystrix/ok")
    CommonResult getOk();

    @GetMapping("/hystrix/error")
    CommonResult getError();
}
