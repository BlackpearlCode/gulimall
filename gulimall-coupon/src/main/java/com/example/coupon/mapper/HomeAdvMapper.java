package com.example.coupon.mapper;

import com.example.coupon.entity.HomeAdv;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeAdvMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HomeAdv record);

    int insertSelective(HomeAdv record);

    HomeAdv selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HomeAdv record);

    int updateByPrimaryKey(HomeAdv record);
}