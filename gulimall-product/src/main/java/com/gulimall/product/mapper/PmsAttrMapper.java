package com.gulimall.product.mapper;

import com.gulimall.product.entity.PmsAttr;
import com.gulimall.product.entity.PmsAttrGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PmsAttrMapper {
    int deleteByPrimaryKey(Long attrId);

    int insert(PmsAttr record);

    int insertSelective(PmsAttr record);

    PmsAttr selectByPrimaryKey(Long attrId);

    int updateByPrimaryKeySelective(PmsAttr record);

    int updateByPrimaryKey(PmsAttr record);

    List<PmsAttr> selectByKey(String key,String attrType);
    List<PmsAttr> selectByKeyAndCatelogId(Long catelogId,String key,String attrType);
    List<PmsAttr> selectByAttrNameOrId(String key, long catelogId);

    List<PmsAttr> selectBatchByAttrIds(@Param("ids")List<Long> ids);


    List<PmsAttr> selectRelation(Long catelogId,@Param("attrIdList") List<Long> attrIdList,String key,int attrType);


    List<PmsAttr> selectByAttrType(int attrType,String key);

    void batchDeleteByAttrId(@Param("attrIds") List<Long> attrIds);

    PmsAttr selectAttrNameByAttrIdAndAttrType(Long item, int attrType);
}