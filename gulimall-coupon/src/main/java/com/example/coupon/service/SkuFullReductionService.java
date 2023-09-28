package com.example.coupon.service;

import com.example.coupon.entity.SkuFullReduction;
import com.gulimall.common.to.SkuReductionTo;

public interface SkuFullReductionService{


    int deleteByPrimaryKey(Long id);

    int insert(SkuFullReduction record);

    int insertSelective(SkuFullReduction record);

    SkuFullReduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuFullReduction record);

    int updateByPrimaryKey(SkuFullReduction record);

    void save(SkuReductionTo skuReductionTo);
}
