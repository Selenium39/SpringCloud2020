package com.selenium.springcloud.service;

import com.selenium.springcloud.result.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class OpenFeignOrderServiceFallback implements OpenFeignOrderService {
    @Override
    public CommonResult getOk() {
        return new CommonResult(500, "CLOUD-ORDER-FEIGN-HYSTRIX-SERVICE:80:request Error fallback by fallback class", null);

    }

    @Override
    public CommonResult getError() {
        return new CommonResult(500, "CLOUD-ORDER-FEIGN-HYSTRIX-SERVICE:80:request Error fallback by fallback class", null);
    }
}
