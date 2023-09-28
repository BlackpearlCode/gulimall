package com.gulimall.product.mapper;

import com.gulimall.product.entity.PmsAttr;
import com.gulimall.product.entity.PmsSpuInfo;
import com.gulimall.product.vo.SpuInFo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PmsSpuInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuInfo record);

    int insertSelective(PmsSpuInfo record);

    PmsSpuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuInfo record);

    int updateByPrimaryKey(PmsSpuInfo record);

    List<PmsSpuInfo> getAll(@Param("params") Map<String, Object> params);
}