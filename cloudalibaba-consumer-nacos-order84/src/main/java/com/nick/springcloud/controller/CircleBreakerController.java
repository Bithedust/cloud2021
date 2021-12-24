package com.nick.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import com.nick.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author Nick4Supreme
 * @date 2021/12/24
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    public String serviceUrl;

    public PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback") // 没有配置
//    @SentinelResource(value = "fallback", fallback = "fallbackHandler") // 只配置了 fallback
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") // 只配置了 blockHandler
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackHandler") // 配置了 blockHandler 和 fallback
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){

//        CommonResult result = restTemplate.getForObject(serviceUrl + "/payment/{id}", CommonResult.class, id);
        CommonResult result = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常……");
        }else if(Objects.isNull(result.getData())){
            throw new NullPointerException(("NullPointException，该ID没有对应的记录，空指针异常"));
        }
        return result;
    }
//    fallback配置
    public CommonResult<Payment> fallbackHandler(@PathVariable Long id,Throwable e){
        return new CommonResult<>(444, "输入的ID不符合要求，被 fallback 限流，请重新输入," + e.getClass().getName());
    }

//    blockHandler配置
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException exception){
        return new CommonResult<>(4004,"被 blockHandler 限流了，请稍后再试");
    }

    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult<Payment> openfeignPayment(@PathVariable Long id){
        return paymentService.paymentSQL(id);

    }
}
