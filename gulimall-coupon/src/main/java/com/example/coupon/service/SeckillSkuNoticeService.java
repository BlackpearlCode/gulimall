package com.example.coupon.service;

import com.example.coupon.entity.SeckillSkuNotice;
public interface SeckillSkuNoticeService{


    int deleteByPrimaryKey(Long id);

    int insert(SeckillSkuNotice record);

    int insertSelective(SeckillSkuNotice record);

    SeckillSkuNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillSkuNotice record);

    int updateByPrimaryKey(SeckillSkuNotice record);

}
