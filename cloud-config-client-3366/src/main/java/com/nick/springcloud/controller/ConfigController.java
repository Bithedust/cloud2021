package com.nick.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/12/10
 */
@RestController
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
