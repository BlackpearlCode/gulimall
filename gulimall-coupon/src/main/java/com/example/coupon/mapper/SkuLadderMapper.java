package com.example.coupon.mapper;

import com.example.coupon.entity.SkuLadder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkuLadderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuLadder record);

    int insertSelective(SkuLadder record);

    SkuLadder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuLadder record);

    int updateByPrimaryKey(SkuLadder record);
}