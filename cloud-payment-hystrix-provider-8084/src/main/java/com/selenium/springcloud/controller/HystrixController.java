package com.selenium.springcloud.controller;

import com.selenium.springcloud.result.CommonResult;
import com.selenium.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hystrix")
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/ok")
    public CommonResult getOk() {
        String result = hystrixService.requestOk();
        return new CommonResult(200, result, null);
    }

    @GetMapping("/error")
    public CommonResult getError() {
        String result = hystrixService.requestError();
        return new CommonResult(200, result, null);
    }

    @GetMapping("/break/{id}")
    public CommonResult requestBreak(@PathVariable int id) {
        String result = hystrixService.requestBreak(id);
        return new CommonResult(200, result, null);
    }

}
