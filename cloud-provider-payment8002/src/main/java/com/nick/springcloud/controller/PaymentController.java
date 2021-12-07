package com.nick.springcloud.controller;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import com.nick.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nick4Supreme
 * @date 2021/11/7
 */
@RestController
@Slf4j
public class PaymentController {

    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody(required = false) Payment payment){
        try {
            int result = paymentService.create(payment);
            if(result < 0){
                return new CommonResult<>(400,"FAILED");
            }
            return new CommonResult<>(200,"SUCCESS" + serverPort,result);
        } catch (Exception e) {
            return new CommonResult<>(404,e.getMessage());
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        try {
            Payment result = paymentService.getPaymentById(id);
            if(result == null){
                return new CommonResult<>(400,"FAILED");
            }
            return new CommonResult<>(200,"SUCCESS" + serverPort,result);
        } catch (Exception e) {
            return new CommonResult<>(404,e.getMessage());
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String openFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
