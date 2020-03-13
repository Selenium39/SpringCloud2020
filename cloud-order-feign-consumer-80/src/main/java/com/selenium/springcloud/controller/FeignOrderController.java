package com.selenium.springcloud.controller;

import com.selenium.springcloud.result.CommonResult;
import com.selenium.springcloud.service.OpenFeignOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/order")
public class FeignOrderController {

    @Resource
    private OpenFeignOrderService feignOrderService;


    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return feignOrderService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public CommonResult getFeignTimeout() {
        return feignOrderService.getFeignTimeout();
    }


}
