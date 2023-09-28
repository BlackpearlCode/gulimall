package com.example.coupon.mapper;

import com.example.coupon.entity.SpuBounds;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpuBoundsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpuBounds record);

    int insertSelective(SpuBounds record);

    SpuBounds selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpuBounds record);

    int updateByPrimaryKey(SpuBounds record);
}