package com.nick.springcloud.service;

import com.nick.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/moneyDecrease")
    CommonResult moneyDecrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);

}
