package com.example.member.mapper;

import com.example.member.entity.GrowthChangeHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GrowthChangeHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GrowthChangeHistory record);

    int insertSelective(GrowthChangeHistory record);

    GrowthChangeHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GrowthChangeHistory record);

    int updateByPrimaryKey(GrowthChangeHistory record);
}