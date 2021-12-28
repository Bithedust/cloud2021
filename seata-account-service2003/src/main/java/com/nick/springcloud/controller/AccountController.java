package com.nick.springcloud.controller;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Nick4Supreme
 * @date 2021/12/28
 */
@RestController
@Slf4j
public class AccountController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/moneyDecrease")
    CommonResult moneyDecrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        int result = accountService.moneyDecrease(userId, money);

        if(result == 0){
            log.info("修改失败");
            return new CommonResult(4004,"修改失败");
        }
        return new CommonResult(200, "修改成功");
    }

}
