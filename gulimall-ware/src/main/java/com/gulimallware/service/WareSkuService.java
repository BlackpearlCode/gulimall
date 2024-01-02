package com.gulimallware.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimallware.entity.WareSku;
import com.gulimallware.vo.LockStockResult;
import com.gulimallware.vo.SkusHasStockVo;
import com.gulimallware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

public interface WareSkuService{


    int deleteByPrimaryKey(Long id);

    int insert(WareSku record);

    int insertSelective(WareSku record);

    WareSku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WareSku record);

    int updateByPrimaryKey(WareSku record);

    PageEntity getAll(Map<String, Object> params);

    // 查询sku是否有库存
    List<SkusHasStockVo> getSkusHasStock(List<Long> skuIds);
    // 锁定库存
    Boolean orderLockStock(WareSkuLockVo vo);
}
