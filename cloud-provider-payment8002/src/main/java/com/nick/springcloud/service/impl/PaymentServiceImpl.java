package com.nick.springcloud.service.impl;

import com.nick.springcloud.dao.PaymentDao;
import com.nick.springcloud.entities.Payment;
import com.nick.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nick4Supreme
 * @date 2021/11/7
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public void setPaymentDao(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
