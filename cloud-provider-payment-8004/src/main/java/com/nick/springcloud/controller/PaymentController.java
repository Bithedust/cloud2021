package com.nick.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Nick4Supreme
 * @date 2021/11/10
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    
    @RequestMapping("/payment/zk")
    public String paymentZk(){

        return "SpringCloud with ZooKeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
