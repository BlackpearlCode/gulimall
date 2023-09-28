package com.example.coupon.service;

import com.example.coupon.entity.CouponSpuCategoryRelation;
public interface CouponSpuCategoryRelationService{


    int deleteByPrimaryKey(Long id);

    int insert(CouponSpuCategoryRelation record);

    int insertSelective(CouponSpuCategoryRelation record);

    CouponSpuCategoryRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CouponSpuCategoryRelation record);

    int updateByPrimaryKey(CouponSpuCategoryRelation record);

}
