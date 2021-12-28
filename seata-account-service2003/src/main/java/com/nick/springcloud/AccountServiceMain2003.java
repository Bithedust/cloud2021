package com.nick.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Nick4Supreme
 * @date 2021/12/28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.nick.springcloud.dao")
public class AccountServiceMain2003 {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceMain2003.class,args);
    }

}
