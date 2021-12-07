package com.nick.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Nick4Supreme
 * @date 2021/11/11
 */
@RestController
public class ConsumerZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/consumer/zk")
    public String paymentInfo(){

        return restTemplate.getForObject(INVOKE_URL + "/payment/zk",String.class);

    }

}
