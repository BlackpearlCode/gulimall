package com.gulimallware.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimallware.entity.WareInfo;

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
}
