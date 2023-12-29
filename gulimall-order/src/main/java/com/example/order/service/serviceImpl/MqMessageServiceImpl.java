package com.example.order.service.serviceImpl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.mapper.MqMessageMapper;
import com.example.order.entity.MqMessage;
import com.example.order.service.MqMessageService;
@Service
public class MqMessageServiceImpl implements MqMessageService{

    @Autowired
    private MqMessageMapper mqMessageMapper;

    @Override
    public int deleteByPrimaryKey(String messageId) {
        return mqMessageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public int insert(MqMessage record) {
        return mqMessageMapper.insert(record);
    }

    @Override
    public int insertSelective(MqMessage record) {
        return mqMessageMapper.insertSelective(record);
    }

    @Override
    public MqMessage selectByPrimaryKey(String messageId) {
        return mqMessageMapper.selectByPrimaryKey(messageId);
    }

    @Override
    public int updateByPrimaryKeySelective(MqMessage record) {
        return mqMessageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MqMessage record) {
        return mqMessageMapper.updateByPrimaryKey(record);
    }

}
