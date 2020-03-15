package com.selenium.springcloud.controller;

import com.selenium.springcloud.result.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping("/consul")
    public CommonResult test() {
        return new CommonResult(200, "success", null);
    }
}
