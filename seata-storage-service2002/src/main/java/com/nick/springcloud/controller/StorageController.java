package com.nick.springcloud.controller;

import com.nick.springcloud.entities.CommonResult;
import com.nick.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@RestController
public class StorageController {

    private StorageService storageService;

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/storage/storageDecrease")
    public CommonResult storageDecrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        int result = storageService.storageDecrease(productId, count);
        if(result == 0){
            return new CommonResult(400, "修改失败");
        }
        return new CommonResult(200,"修改成功");
    }

}
