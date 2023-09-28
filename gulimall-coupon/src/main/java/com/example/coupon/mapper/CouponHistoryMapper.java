package com.example.coupon.mapper;

import com.example.coupon.entity.CouponHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CouponHistory record);

    int insertSelective(CouponHistory record);

    CouponHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CouponHistory record);

    int updateByPrimaryKey(CouponHistory record);
}