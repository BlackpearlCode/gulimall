package com.example.order.service.serviceImpl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.entity.OrderReturnApply;
import com.example.order.mapper.OrderReturnApplyMapper;
import com.example.order.service.OrderReturnApplyService;
@Service
public class OrderReturnApplyServiceImpl implements OrderReturnApplyService{

    @Autowired
    private OrderReturnApplyMapper orderReturnApplyMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderReturnApplyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderReturnApply record) {
        return orderReturnApplyMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderReturnApply record) {
        return orderReturnApplyMapper.insertSelective(record);
    }

    @Override
    public OrderReturnApply selectByPrimaryKey(Long id) {
        return orderReturnApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderReturnApply record) {
        return orderReturnApplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderReturnApply record) {
        return orderReturnApplyMapper.updateByPrimaryKey(record);
    }

}
