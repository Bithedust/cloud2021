package com.nick.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nick4Supreme
 * @date 2021/11/18
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceFallback.class)
public interface PaymentHystrixService {

    @RequestMapping("/payment/ok/hystrix/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id);

    @RequestMapping("/payment/timeout/hystrix/{id}")
    public String hystrix_timeout(@PathVariable("id") Integer id);

}
