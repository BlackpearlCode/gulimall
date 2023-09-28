package com.gulimall.product.service.impl;

import com.gulimall.product.entity.PmsSpuComment;
import com.gulimall.product.mapper.PmsSpuCommentMapper;
import com.gulimall.product.service.PmsSpuCommentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PmsSpuCommentServiceImpl implements PmsSpuCommentService {

    @Resource
    private PmsSpuCommentMapper pmsSpuCommentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSpuCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsSpuComment record) {
        return pmsSpuCommentMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsSpuComment record) {
        return pmsSpuCommentMapper.insertSelective(record);
    }

    @Override
    public PmsSpuComment selectByPrimaryKey(Long id) {
        return pmsSpuCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSpuComment record) {
        return pmsSpuCommentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSpuComment record) {
        return pmsSpuCommentMapper.updateByPrimaryKey(record);
    }

}
