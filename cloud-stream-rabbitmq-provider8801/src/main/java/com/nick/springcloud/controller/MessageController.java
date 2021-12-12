package com.nick.springcloud.controller;

import com.nick.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Nick4Supreme
 * @date 2021/12/12
 */
@RestController
public class MessageController {

    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
