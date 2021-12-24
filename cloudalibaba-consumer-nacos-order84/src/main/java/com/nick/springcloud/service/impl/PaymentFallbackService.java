package com.nick.springcloud.service.impl;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.entities.Payment;
import com.nick.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author Nick4Supreme
 * @date 2021/12/24
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444,"服务降级");
    }
}
