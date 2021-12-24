package com.nick.springcloud.controller;

import com.nick.springcloud.PaymentMain9003;
import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Nick4Supreme
 * @date 2021/12/24
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "93c0668c-f980-4d5c-8b2c-224530e36ebf"));
        hashMap.put(2L, new Payment(2L, "2a37b187-91cd-4e46-866d-f87d93f36821"));
        hashMap.put(3L, new Payment(3L, "c7cf6188-4683-4c5c-9893-5783e87135fc"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,server port:" + serverPort, payment);
        return result;
    }

}
