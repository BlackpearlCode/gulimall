package com.gulimall.product.service;

import com.gulimall.product.entity.PmsAttrAttrgroupRelation;
import com.gulimall.product.vo.AttrGroupRelationVo;

import java.util.List;

public interface PmsAttrAttrgroupRelationService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsAttrAttrgroupRelation record);

    int insertSelective(PmsAttrAttrgroupRelation record);

    PmsAttrAttrgroupRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsAttrAttrgroupRelation record);

    int updateByPrimaryKey(PmsAttrAttrgroupRelation record);

    void updateByAttrId(Long attrGroupId, Long attrId);

    List<Long> selectByGroupId(Long attrGroupId);

    void deleteRelation(AttrGroupRelationVo[] relationVo);

    //批量添加
    void batchInsert (List<PmsAttrAttrgroupRelation> relationVo);
}
