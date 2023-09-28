package com.example.coupon.service;

import com.example.coupon.entity.HomeSubject;
public interface HomeSubjectService{


    int deleteByPrimaryKey(Long id);

    int insert(HomeSubject record);

    int insertSelective(HomeSubject record);

    HomeSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HomeSubject record);

    int updateByPrimaryKey(HomeSubject record);

}
