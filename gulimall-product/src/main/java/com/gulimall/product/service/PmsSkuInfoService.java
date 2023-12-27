package com.gulimall.product.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimall.product.entity.PmsSkuInfo;
import com.gulimall.product.entity.PmsSpuInfo;
import com.gulimall.product.vo.SkuItemVo;
import com.gulimall.product.vo.Skus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface PmsSkuInfoService{


    int deleteByPrimaryKey(Long skuId);

    int insert(PmsSkuInfo record);

    int insertSelective(PmsSkuInfo record);

    PmsSkuInfo selectByPrimaryKey(Long skuId);

    int updateByPrimaryKeySelective(PmsSkuInfo record);

    int updateByPrimaryKey(PmsSkuInfo record);

    void save(Long id, List<Skus> skus, PmsSpuInfo spuInfo);

    PageEntity getSkuInfo(Map<String, Object> params);

    List<PmsSkuInfo> selectBySpuId(Long spuId);


    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;

    List<String> getSkuSaleAtttrValues(Long skuId);
}
