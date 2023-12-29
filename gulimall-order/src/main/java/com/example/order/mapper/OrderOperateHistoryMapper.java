package com.example.order.mapper;

import com.example.order.entity.OrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderOperateHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderOperateHistory record);

    int insertSelective(OrderOperateHistory record);

    OrderOperateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderOperateHistory record);

    int updateByPrimaryKey(OrderOperateHistory record);
}