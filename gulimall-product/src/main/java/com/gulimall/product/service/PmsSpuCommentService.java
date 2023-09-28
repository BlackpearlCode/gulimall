package com.gulimall.product.service;

import com.gulimall.product.entity.PmsSpuComment;

public interface PmsSpuCommentService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsSpuComment record);

    int insertSelective(PmsSpuComment record);

    PmsSpuComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSpuComment record);

    int updateByPrimaryKey(PmsSpuComment record);

}
