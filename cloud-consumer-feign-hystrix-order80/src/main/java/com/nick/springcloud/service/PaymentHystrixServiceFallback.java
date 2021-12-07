package com.nick.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Nick4Supreme
 * @date 2021/11/19
 */
@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService{
    @Override
    public String hystrix_ok(Integer id) {
        return "--------------------------------- PaymentHystrixServiceFallback";
    }

    @Override
    public String hystrix_timeout(Integer id) {
        return "--------------------------------- PaymentHystrixServiceFallback";
    }
}
