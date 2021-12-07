package com.nick.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.nick.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/11/18
 */
@RestController
@DefaultProperties(defaultFallback = "global_payment_fallback")
public class OrderHystrixController {

    private PaymentHystrixService paymentHystrixService;

    @Autowired
    public void setPaymentHystrixService(PaymentHystrixService paymentHystrixService) {
        this.paymentHystrixService = paymentHystrixService;
    }

    @RequestMapping("/consumer/payment/ok/hystrix/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.hystrix_ok(id);
    }

    @RequestMapping("/consumer/payment/timeout/hystrix/{id}")
//    @HystrixCommand(fallbackMethod = "hystrixTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String hystrix_timeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.hystrix_timeout(id);
    }

    public String hystrixTimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "Here is Consumer80 Fallback Method, Please try it later or contact our administrator";
    }

    public String global_payment_fallback(){
        return "Global异常处理信息，请稍后再试";
    }

}
