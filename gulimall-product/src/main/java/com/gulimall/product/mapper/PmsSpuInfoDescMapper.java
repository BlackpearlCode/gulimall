package com.gulimall.product.mapper;

import com.gulimall.product.entity.PmsSpuInfoDesc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsSpuInfoDescMapper {
    int deleteByPrimaryKey(Long spuId);

    int insert(PmsSpuInfoDesc record);

    int insertSelective(PmsSpuInfoDesc record);

    PmsSpuInfoDesc selectByPrimaryKey(Long spuId);

    int updateByPrimaryKeySelective(PmsSpuInfoDesc record);

    int updateByPrimaryKey(PmsSpuInfoDesc record);


}