package com.nick.springcloud.service;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import com.nick.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Nick4Supreme
 * @date 2021/12/24
 */
@FeignClient(name = "nacos-payment-provider",fallback = PaymentFallbackService.class)
@Service("paymentService")
public interface PaymentService {

    @GetMapping("/payment/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
