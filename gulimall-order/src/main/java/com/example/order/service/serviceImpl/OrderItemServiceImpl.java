package com.example.order.service.serviceImpl;

import com.example.order.entity.OrderItem;
import com.example.order.mapper.OrderItemMapper;
import com.example.order.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemMapper orderItemMapper;



    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderItem record) {
        return orderItemMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }

    @Override
    public OrderItem selectByPrimaryKey(Long id) {
        return orderItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderItem record) {
        return orderItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderItem record) {
        return orderItemMapper.updateByPrimaryKey(record);
    }


}
