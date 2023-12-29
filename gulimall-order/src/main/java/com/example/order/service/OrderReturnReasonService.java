package com.example.order.service;

import com.example.order.entity.OrderReturnReason;
public interface OrderReturnReasonService{

    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnReason record);

    int insertSelective(OrderReturnReason record);

    OrderReturnReason selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderReturnReason record);

    int updateByPrimaryKey(OrderReturnReason record);

}
