package com.nick.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Nick4Supreme
 * @date 2021/12/28
 */
@Mapper
public interface AccountDao {

    int moneyDecrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
