package com.nick.springcloud.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Nick4Supreme
 * @date 2021/12/28
 */
public interface AccountService {

    int moneyDecrease(Long userId, BigDecimal money);

}
