package com.nick.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
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

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){

        CommonResult result = restTemplate.getForObject(serviceUrl + "/payment/{id}", CommonResult.class, id);
//        CommonResult result = restTemplate.getForObject(serviceUrl + "/payment/" + id, CommonResult.class); 均可使用

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常……");
        }else if(Objects.isNull(result.getData())){
            throw new NullPointerException(("NullPointException，该ID没有对应的记录，空指针异常"));
        }

        return result;

    }

}
