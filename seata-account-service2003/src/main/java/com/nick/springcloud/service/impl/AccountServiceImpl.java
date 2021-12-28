package com.nick.springcloud.service.impl;

import com.nick.springcloud.dao.AccountDao;
import com.nick.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Nick4Supreme
 * @date 2021/12/28
 */
@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public int moneyDecrease(Long userId, BigDecimal money) {

//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return accountDao.moneyDecrease(userId,money);
    }
}
