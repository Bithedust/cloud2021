package com.nick.springcloud.controller;

import com.nick.springcloud.domain.CommonResult;
import com.nick.springcloud.domain.Order;
import com.nick.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/createOrder")
    public CommonResult createOrder(Order order){

        int result = orderService.createOrder(order);

        return new CommonResult(200,"创建成功", result);

    }
}
