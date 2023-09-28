package com.gulimallware.service;

import com.gulimallware.entity.WareOrderTaskDetail;
public interface WareOrderTaskDetailService{


    int deleteByPrimaryKey(Long id);

    int insert(WareOrderTaskDetail record);

    int insertSelective(WareOrderTaskDetail record);

    WareOrderTaskDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WareOrderTaskDetail record);

    int updateByPrimaryKey(WareOrderTaskDetail record);

}
