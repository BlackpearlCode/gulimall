package com.gulimall.product.service;

import com.gulimall.common.utils.PageEntity;
import com.gulimall.product.entity.PmsAttr;
import com.gulimall.product.vo.AttrInfoVo;

import java.util.List;

public interface PmsAttrService{


    int deleteByPrimaryKey(Long attrId);

    int insert(PmsAttr record);

    int insertSelective(PmsAttr record);

    PmsAttr selectByPrimaryKey(Long attrId);

    int updateByPrimaryKeySelective(PmsAttr record);

    int updateByPrimaryKey(PmsAttr record);


    PageEntity selectAll( int page, int limit,String key,Long catelogId,String attrType);

    AttrInfoVo selectAttrInfo(Long attrId);

    List<AttrInfoVo> selectBatchByAttrIds(List<Long> attrIds);

    PageEntity getRelation(long attrgroupId, int page, int limit, String key);

    //根据attrid批量删除
    void batchDeleteByAttrId(List<Long> attrIds);
}
