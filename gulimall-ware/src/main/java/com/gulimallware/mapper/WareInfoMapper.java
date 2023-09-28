package com.gulimallware.mapper;

import com.gulimallware.entity.WareInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WareInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WareInfo record);

    int insertSelective(WareInfo record);

    WareInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WareInfo record);

    int updateByPrimaryKey(WareInfo record);

    List<WareInfo> getAll(@Param("params") Map<String, Object> params);

    void batchDeleteById(@Param("ids") List<Long> ids);
}