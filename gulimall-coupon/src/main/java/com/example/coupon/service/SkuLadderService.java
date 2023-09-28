package com.example.coupon.service;

import com.example.coupon.entity.SkuLadder;
public interface SkuLadderService{


    int deleteByPrimaryKey(Long id);

    int insert(SkuLadder record);

    int insertSelective(SkuLadder record);

    SkuLadder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuLadder record);

    int updateByPrimaryKey(SkuLadder record);

}
