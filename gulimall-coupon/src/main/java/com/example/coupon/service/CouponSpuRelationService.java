package com.example.coupon.service;

import com.example.coupon.entity.CouponSpuRelation;
public interface CouponSpuRelationService{


    int deleteByPrimaryKey(Long id);

    int insert(CouponSpuRelation record);

    int insertSelective(CouponSpuRelation record);

    CouponSpuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CouponSpuRelation record);

    int updateByPrimaryKey(CouponSpuRelation record);

}
