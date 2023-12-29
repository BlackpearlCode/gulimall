package com.example.order.service;

import com.example.order.entity.OrderOperateHistory;
public interface OrderOperateHistoryService{

    int deleteByPrimaryKey(Long id);

    int insert(OrderOperateHistory record);

    int insertSelective(OrderOperateHistory record);

    OrderOperateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderOperateHistory record);

    int updateByPrimaryKey(OrderOperateHistory record);

}
