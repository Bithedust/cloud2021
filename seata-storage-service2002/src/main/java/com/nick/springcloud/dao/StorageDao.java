package com.nick.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Nick4Supreme
 * @date 2021/12/26
 */
@Mapper
public interface StorageDao {

    int decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);

}
