package com.example.order.service.serviceImpl;

import com.example.order.service.RefundInfoService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.mapper.RefundInfoMapper;
import com.example.order.entity.RefundInfo;

@Service
public class RefundInfoServiceImpl implements RefundInfoService {

    @Autowired
    private RefundInfoMapper refundInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return refundInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RefundInfo record) {
        return refundInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(RefundInfo record) {
        return refundInfoMapper.insertSelective(record);
    }

    @Override
    public RefundInfo selectByPrimaryKey(Long id) {
        return refundInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RefundInfo record) {
        return refundInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RefundInfo record) {
        return refundInfoMapper.updateByPrimaryKey(record);
    }

}
