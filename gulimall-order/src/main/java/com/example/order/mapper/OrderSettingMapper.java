package com.example.order.mapper;

import com.example.order.entity.OrderSetting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderSetting record);

    int insertSelective(OrderSetting record);

    OrderSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderSetting record);

    int updateByPrimaryKey(OrderSetting record);
}