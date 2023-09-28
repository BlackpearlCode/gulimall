package com.example.coupon.service;

import com.example.coupon.entity.HomeAdv;
public interface HomeAdvService{


    int deleteByPrimaryKey(Long id);

    int insert(HomeAdv record);

    int insertSelective(HomeAdv record);

    HomeAdv selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HomeAdv record);

    int updateByPrimaryKey(HomeAdv record);

}
