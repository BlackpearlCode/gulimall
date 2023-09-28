package com.gulimallware.mapper;

import com.gulimallware.entity.WareOrderTaskDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WareOrderTaskDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WareOrderTaskDetail record);

    int insertSelective(WareOrderTaskDetail record);

    WareOrderTaskDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WareOrderTaskDetail record);

    int updateByPrimaryKey(WareOrderTaskDetail record);
}