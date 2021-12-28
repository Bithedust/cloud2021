package com.nick.springcloud.service;

/**
 * @author Nick4Supreme
 * @date 2021/12/27
 */
public interface StorageService {

    int storageDecrease(Long productId, Integer count);

}
