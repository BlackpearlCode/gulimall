package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsCommentReplay;
import com.gulimall.product.mapper.PmsCommentReplayMapper;
import com.gulimall.product.service.PmsCommentReplayService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PmsCommentReplayServiceImpl implements PmsCommentReplayService {

    @Resource
    private PmsCommentReplayMapper pmsCommentReplayMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsCommentReplayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsCommentReplay record) {
        return pmsCommentReplayMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsCommentReplay record) {
        return pmsCommentReplayMapper.insertSelective(record);
    }

    @Override
    public PmsCommentReplay selectByPrimaryKey(Long id) {
        return pmsCommentReplayMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsCommentReplay record) {
        return pmsCommentReplayMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsCommentReplay record) {
        return pmsCommentReplayMapper.updateByPrimaryKey(record);
    }

}
