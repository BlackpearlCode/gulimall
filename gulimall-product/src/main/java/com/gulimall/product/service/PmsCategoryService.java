package com.gulimall.product.service;

import com.gulimall.product.entity.PmsCategory;

import java.util.List;

public interface PmsCategoryService{


    int deleteByPrimaryKey(Long catId);

    int insert(PmsCategory record);

    int insertSelective(PmsCategory record);

    PmsCategory selectByPrimaryKey(Long catId);

    int updateByPrimaryKeySelective(PmsCategory record);

    int updateByPrimaryKey(PmsCategory record);

    List<PmsCategory> selectlist();

    List<PmsCategory> seletcListTree();

    //批量删除(逻辑删除)
    int updateShowStatusList(List ids);

    List<PmsCategory> getLevel1Categorys();
}
