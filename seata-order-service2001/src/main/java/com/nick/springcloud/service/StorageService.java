package com.nick.springcloud.service;

import com.nick.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/storageDecrease")
    CommonResult storageDecrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
