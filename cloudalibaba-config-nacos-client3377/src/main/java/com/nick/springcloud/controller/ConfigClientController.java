package com.nick.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/12/17
 */
@RestController
@RefreshScope // 支持 Nacos 的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
