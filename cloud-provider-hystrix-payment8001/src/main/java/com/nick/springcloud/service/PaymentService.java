package com.nick.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Nick4Supreme
 * @date 2021/11/18
 */
@Service
public class PaymentService {

    public String hystrix_OK(Integer id) {
        int i = 10 / 0;

        return "线程池：" + Thread.currentThread().getName() + "   hystrix_OK,id:" + id + "nick";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String hystrix_timeout(Integer id) {

        int sleepTime = 3000;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 10 / 0 ;

        return "线程池：" + Thread.currentThread().getName() + "   hystrix_timeout,id:" + id + "nick";
    }

    public String paymentTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentTimeoutHandler,id:" + id + "nick";
    }


    //--------------------------服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name= "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name= "circuitBreaker.requestVolumeThreshold",value = "0"),
            @HystrixProperty(name= "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name= "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试,id:" + id;
    }

}
