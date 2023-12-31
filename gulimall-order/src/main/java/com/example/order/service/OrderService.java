package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.vo.OrderConfirmVo;
import com.example.order.vo.OrderSubmitVo;
import com.example.order.vo.SubmitOrderResponseVo;

import java.util.concurrent.ExecutionException;

public interface OrderService{

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    // 订单确认页面信息
    OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

    // 提交订单
    SubmitOrderResponseVo submitOrder(OrderSubmitVo submitVo);
}
