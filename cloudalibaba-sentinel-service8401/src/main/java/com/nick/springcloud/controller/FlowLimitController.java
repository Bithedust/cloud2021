package com.nick.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/testD")
    public String testD(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName() +"--testD");
        int a = 10 / 0;

        return  "----testD";
    }

    @GetMapping("/testE")
    public String testE(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName() +"--testE");
//        int a = 10 / 0;

        return  "----testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(name = "p1", required = false) String p1,
                             @RequestParam(name = "p2", required = false) String p2){
        return "testHotKey" + (p1 == null ? ",p1: null":",p1:" + p1) + (p2 == null ? ",p2:null": ",p2:" + p2) ;
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "HotKey blocking";
    }

}
