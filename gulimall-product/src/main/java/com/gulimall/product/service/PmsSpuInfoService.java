package com.gulimall.product.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimall.product.entity.PmsSpuInfo;
import com.gulimall.product.vo.SpuInFo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface PmsSpuInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuInfo record);

    int insertSelective(PmsSpuInfo record);

    PmsSpuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuInfo record);

    int updateByPrimaryKey(PmsSpuInfo record);
    void saveSpuInfo(SpuInFo spu);

    PageEntity getAll(Map<String, Object>params);

    void up(Long id);

    // 根据skuId获取spu信息
    PmsSpuInfo getSpuInfoBySkuId(Long skuId);
}
