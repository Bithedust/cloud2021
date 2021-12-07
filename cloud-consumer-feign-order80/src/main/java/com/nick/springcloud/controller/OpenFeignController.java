package com.nick.springcloud.controller;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import com.nick.springcloud.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Nick4Supreme
 * @date 2021/11/16
 */
@RestController
public class OpenFeignController {

    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return openFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String getOpenFeignTimeout(){
        return openFeignService.openFeignTimeout();
    }

}
