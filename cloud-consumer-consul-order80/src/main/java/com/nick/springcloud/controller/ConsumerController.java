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
public class ConsumerController {

    public static final String CONSUL_URI= "http://cloud-provider-payment";

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/consumer/consul")
    public String getConsulInfo(){
        return restTemplate.getForObject(CONSUL_URI + "/payment/consul", String.class);
    }

}
