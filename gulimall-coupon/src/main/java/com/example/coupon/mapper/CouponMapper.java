package com.example.coupon.mapper;

import com.example.coupon.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}