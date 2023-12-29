package com.example.order.service.serviceImpl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.entity.OrderOperateHistory;
import com.example.order.mapper.OrderOperateHistoryMapper;
import com.example.order.service.OrderOperateHistoryService;
@Service
public class OrderOperateHistoryServiceImpl implements OrderOperateHistoryService{

    @Autowired
    private OrderOperateHistoryMapper orderOperateHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderOperateHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderOperateHistory record) {
        return orderOperateHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderOperateHistory record) {
        return orderOperateHistoryMapper.insertSelective(record);
    }

    @Override
    public OrderOperateHistory selectByPrimaryKey(Long id) {
        return orderOperateHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderOperateHistory record) {
        return orderOperateHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderOperateHistory record) {
        return orderOperateHistoryMapper.updateByPrimaryKey(record);
    }

}
