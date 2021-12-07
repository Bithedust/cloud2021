package com.nick.springcloud.service;

import com.nick.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author Nick4Supreme
 * @date 2021/11/7
 */
@Service
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
