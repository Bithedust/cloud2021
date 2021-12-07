package com.nick.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Nick4Supreme
 * @date 2021/11/11
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String getPaymentInfo(){

        return "SpringCloud with Consul from :" + serverPort + UUID.randomUUID().toString();
    }

}
