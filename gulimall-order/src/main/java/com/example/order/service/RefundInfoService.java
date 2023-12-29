package com.example.order.service;

import com.example.order.entity.RefundInfo;
public interface RefundInfoService{

    int deleteByPrimaryKey(Long id);

    int insert(RefundInfo record);

    int insertSelective(RefundInfo record);

    RefundInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RefundInfo record);

    int updateByPrimaryKey(RefundInfo record);

}
