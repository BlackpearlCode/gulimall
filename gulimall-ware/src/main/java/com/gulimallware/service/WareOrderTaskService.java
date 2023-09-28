package com.gulimallware.service;

import com.gulimallware.entity.WareOrderTask;
public interface WareOrderTaskService{


    int deleteByPrimaryKey(Long id);

    int insert(WareOrderTask record);

    int insertSelective(WareOrderTask record);

    WareOrderTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WareOrderTask record);

    int updateByPrimaryKey(WareOrderTask record);

}
