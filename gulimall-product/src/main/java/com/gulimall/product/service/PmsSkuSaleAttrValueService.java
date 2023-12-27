package com.gulimall.product.service;

import com.gulimall.product.entity.PmsSkuSaleAttrValue;
import com.gulimall.product.vo.SkuItemSaleAttrVo;

import java.util.List;

public interface PmsSkuSaleAttrValueService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuSaleAttrValue record);

    int insertSelective(PmsSkuSaleAttrValue record);

    PmsSkuSaleAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuSaleAttrValue record);

    int updateByPrimaryKey(PmsSkuSaleAttrValue record);


    List<SkuItemSaleAttrVo> getSaleAttrsBySpuId(Long spuId);


    List<String> getSkuSaleAttrValuesAsStringList(Long skuId);
}
