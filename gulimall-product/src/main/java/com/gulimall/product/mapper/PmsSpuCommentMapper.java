package com.gulimall.product.mapper;

import com.gulimall.product.entity.PmsSpuComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PmsSpuCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuComment record);

    int insertSelective(PmsSpuComment record);

    PmsSpuComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuComment record);

    int updateByPrimaryKey(PmsSpuComment record);
}