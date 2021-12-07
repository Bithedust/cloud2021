package com.nick.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Nick4Supreme
 * @date 2021/11/11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMain80.class,args);
    }
}
