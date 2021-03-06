package com.nick.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Nick4Supreme
 * @date 2021/12/10
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366.class,args);
    }

}
