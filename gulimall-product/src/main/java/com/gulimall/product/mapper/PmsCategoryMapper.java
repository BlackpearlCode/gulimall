package com.gulimall.product.mapper;

import com.gulimall.product.entity.PmsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsCategoryMapper {
    int deleteByPrimaryKey(Long catId);

    int insert(PmsCategory record);

    int insertSelective(PmsCategory record);

    PmsCategory selectByPrimaryKey(Long catId);

    int updateByPrimaryKeySelective(PmsCategory record);

    int updateByPrimaryKey(PmsCategory record);

    List<PmsCategory> list();

    int updateShowStatusList(List catIds);



}