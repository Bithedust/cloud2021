package com.nick.springcloud.dao;

import com.nick.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Nick4Supreme
 * @date 2021/12/25
 */
@Mapper
public interface OrderDao {

    int createOrder(Order order);

    int updateStatus(@Param("userId") Long userId, @Param("status") Integer status);

}
