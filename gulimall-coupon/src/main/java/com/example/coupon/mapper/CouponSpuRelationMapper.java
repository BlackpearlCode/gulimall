package com.example.coupon.mapper;

import com.example.coupon.entity.CouponSpuRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponSpuRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CouponSpuRelation record);

    int insertSelective(CouponSpuRelation record);

    CouponSpuRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CouponSpuRelation record);

    int updateByPrimaryKey(CouponSpuRelation record);
}