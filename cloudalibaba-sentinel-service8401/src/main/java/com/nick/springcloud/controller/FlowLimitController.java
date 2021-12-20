package com.nick.springcloud.controller;

import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Nick4Supreme
 * @date 2021/12/21
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() +"--testB");

        return  "----testB";
    }

}
