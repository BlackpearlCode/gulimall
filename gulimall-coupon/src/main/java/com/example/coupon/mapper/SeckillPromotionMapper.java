package com.example.coupon.mapper;

import com.example.coupon.entity.SeckillPromotion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillPromotion record);

    int insertSelective(SeckillPromotion record);

    SeckillPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillPromotion record);

    int updateByPrimaryKey(SeckillPromotion record);
}