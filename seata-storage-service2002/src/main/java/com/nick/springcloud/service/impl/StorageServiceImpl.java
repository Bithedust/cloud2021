package com.nick.springcloud.service.impl;

import com.nick.springcloud.dao.StorageDao;
import com.nick.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nick4Supreme
 * @date 2021/12/27
 */
@Service
public class StorageServiceImpl implements StorageService {

    private StorageDao storageDao;

    @Autowired
    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public int storageDecrease(Long productId, Integer count) {
        return storageDao.decreaseStorage(productId,count);
    }
}
