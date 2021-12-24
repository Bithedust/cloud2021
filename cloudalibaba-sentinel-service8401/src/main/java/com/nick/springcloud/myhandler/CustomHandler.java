package com.nick.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nick.springcloud.entities.CommonResult;

/**
 * @author Nick4Supreme
 * @date 2021/12/23
 */
public class CustomHandler {

    public static CommonResult myCustomHandler1(BlockException exception){
        return new CommonResult(444,"被限流了~------1");
    }

    public static CommonResult myCustomHandler2(BlockException exception){
        return new CommonResult(444,"被限流了~------2");
    }

}
