package com.selenium.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.selenium.springcloud.result.CommonResult;
import com.selenium.springcloud.service.OpenFeignOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/hystrix")
@DefaultProperties(defaultFallback = "requestGlobeErrorHandler")
public class FeignOrderController {

    @Resource
    private OpenFeignOrderService feignOrderService;


    @GetMapping("/ok")
    public CommonResult getOk() {
        return feignOrderService.getOk();
    }

    @HystrixCommand(fallbackMethod = "requestErrorHandler")
    @GetMapping("/error")
    public CommonResult getError() {
        int a = 10 / 0;
        return feignOrderService.getError();
    }

    @HystrixCommand
    @GetMapping("/globe/error")
    public CommonResult getGlobeError() {
        int a = 10 / 0;
        return feignOrderService.getError();
    }

    public CommonResult requestErrorHandler() {
        return new CommonResult(500, "CLOUD-ORDER-FEIGN-HYSTRIX-SERVICE:80:request Error fallback", null);
    }

    public CommonResult requestGlobeErrorHandler() {
        return new CommonResult(500, "CLOUD-ORDER-FEIGN-HYSTRIX-SERVICE:80:request Globe Error fallback", null);
    }


}
