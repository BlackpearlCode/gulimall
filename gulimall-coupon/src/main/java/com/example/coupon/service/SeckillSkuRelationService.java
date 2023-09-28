package com.example.coupon.service;

import com.example.coupon.entity.SeckillSkuRelation;
public interface SeckillSkuRelationService{


    int deleteByPrimaryKey(Long id);

    int insert(SeckillSkuRelation record);

    int insertSelective(SeckillSkuRelation record);

    SeckillSkuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillSkuRelation record);

    int updateByPrimaryKey(SeckillSkuRelation record);

}
