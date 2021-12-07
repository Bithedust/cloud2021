package com.nick.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nick4Supreme
 * @date 2021/11/16
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }

}
