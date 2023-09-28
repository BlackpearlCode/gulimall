package com.example.coupon.mapper;

import com.example.coupon.entity.SkuFullReduction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkuFullReductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuFullReduction record);

    int insertSelective(SkuFullReduction record);

    SkuFullReduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuFullReduction record);

    int updateByPrimaryKey(SkuFullReduction record);
}