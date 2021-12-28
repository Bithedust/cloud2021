package com.nick.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.nick.springcloud.dao")
public class StorageServiceMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceMain2002.class, args);
    }

}
