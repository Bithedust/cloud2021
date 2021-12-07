package com.nick.springcloud.service;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Nick4Supreme
 * @date 2021/11/16
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String openFeignTimeout();

}
