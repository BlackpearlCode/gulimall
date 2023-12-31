package com.gulimallware.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimallware.entity.WareInfo;
import com.gulimallware.vo.FareVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WareInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(WareInfo record);

    int insertSelective(WareInfo record);

    WareInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WareInfo record);

    int updateByPrimaryKey(WareInfo record);

    PageEntity getAll(Map<String, Object> params);

    void batchDeleteById(List<Long> ids);

    //根据用户地址进行收取运费
    FareVo getFare(Long id);
}
