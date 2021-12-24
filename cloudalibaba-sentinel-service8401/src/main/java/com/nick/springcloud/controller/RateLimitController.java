package com.nick.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.myhandler.CustomHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/12/23
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResourceHandler")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名限流测试");
    }
    public CommonResult byResourceHandler(BlockException exception){
        return new CommonResult(444,"被限流了，" + exception.getMessage());
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url地址限流测试");
    }

    @GetMapping("/customHandler")
    @SentinelResource(value = "customHandler", blockHandlerClass = CustomHandler.class, blockHandler = "myCustomHandler1")
    public CommonResult customHandler(){
        return new CommonResult(200,"用户自定义处理测试");
    }



}
