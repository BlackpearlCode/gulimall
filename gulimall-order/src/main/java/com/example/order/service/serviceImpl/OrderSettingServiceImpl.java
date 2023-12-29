package com.example.order.service.serviceImpl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.entity.OrderSetting;
import com.example.order.mapper.OrderSettingMapper;
import com.example.order.service.OrderSettingService;
@Service
public class OrderSettingServiceImpl implements OrderSettingService{

    @Autowired
    private OrderSettingMapper orderSettingMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderSettingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderSetting record) {
        return orderSettingMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderSetting record) {
        return orderSettingMapper.insertSelective(record);
    }

    @Override
    public OrderSetting selectByPrimaryKey(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderSetting record) {
        return orderSettingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderSetting record) {
        return orderSettingMapper.updateByPrimaryKey(record);
    }

}
