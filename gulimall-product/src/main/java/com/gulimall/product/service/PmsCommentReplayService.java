package com.gulimall.product.service;

import com.gulimall.product.entity.PmsCommentReplay;

public interface PmsCommentReplayService{


    int deleteByPrimaryKey(Long id);

    int insert(PmsCommentReplay record);

    int insertSelective(PmsCommentReplay record);

    PmsCommentReplay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsCommentReplay record);

    int updateByPrimaryKey(PmsCommentReplay record);

}
