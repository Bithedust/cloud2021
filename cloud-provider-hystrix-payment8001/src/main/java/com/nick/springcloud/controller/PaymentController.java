package com.nick.springcloud.controller;

import com.nick.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/11/18
 */
@RestController
@Slf4j
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping("/payment/ok/hystrix/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id){
        return paymentService.hystrix_OK(id);
    }
    @RequestMapping("/payment/timeout/hystrix/{id}")
    public String hystrix_timeout(@PathVariable("id") Integer id){
        return paymentService.hystrix_timeout(id);
    }

    //=====服务熔断
    @RequestMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****info:" + result);
        return result;
    }

}
