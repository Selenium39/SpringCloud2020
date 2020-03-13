package com.selenium.springcloud.controller;

import com.selenium.springcloud.entity.Payment;
import com.selenium.springcloud.result.CommonResult;
import com.selenium.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        return new CommonResult(200, "success,serverPort: " + serverPort, result);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200, "success,serverPort: " + serverPort, payment);
    }

    @GetMapping("/feign/timeout")
    public CommonResult getFeignTimeout() {
        try {
            //Feign客户端默认超时时间1秒
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200, "success,serverPort: " + serverPort, null);
    }


}
