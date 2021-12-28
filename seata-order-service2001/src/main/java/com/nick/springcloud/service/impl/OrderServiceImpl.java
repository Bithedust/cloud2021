package com.nick.springcloud.service.impl;

import com.nick.springcloud.dao.OrderDao;
import com.nick.springcloud.domain.Order;
import com.nick.springcloud.service.AccountService;
import com.nick.springcloud.service.OrderService;
import com.nick.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private StorageService storageService;
    private AccountService accountService;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @GlobalTransactional(name = "default_tx_group", rollbackFor = Exception.class)
    public int createOrder(Order order) {
        log.info("---------->开始创建订单");
        orderDao.createOrder(order);

        log.info("---------->订单微服务开始调用库存，减少库存--START");
        storageService.storageDecrease(order.getProductId(),order.getCount());
        log.info("---------->订单微服务开始调用库存，减少库存--END");

        log.info("---------->订单微服务开始调用账户，扣除资金--START");
        accountService.moneyDecrease(order.getUserId(),order.getMoney());
        log.info("---------->订单微服务开始调用账户，扣除资金--END");

        log.info("---------->修改订单状态--START");
        orderDao.updateStatus(order.getUserId(),0);
        log.info("---------->修改订单状态--END");

        log.info("---------->订单创建成功");
        return 0;
    }
}
