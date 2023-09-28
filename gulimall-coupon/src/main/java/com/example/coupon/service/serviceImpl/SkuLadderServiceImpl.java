package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.mapper.SkuLadderMapper;
import com.example.coupon.entity.SkuLadder;
import com.example.coupon.service.SkuLadderService;
@Service
public class SkuLadderServiceImpl implements SkuLadderService{

    @Resource
    private SkuLadderMapper skuLadderMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return skuLadderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SkuLadder record) {
        return skuLadderMapper.insert(record);
    }

    @Override
    public int insertSelective(SkuLadder record) {
        return skuLadderMapper.insertSelective(record);
    }

    @Override
    public SkuLadder selectByPrimaryKey(Long id) {
        return skuLadderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SkuLadder record) {
        return skuLadderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SkuLadder record) {
        return skuLadderMapper.updateByPrimaryKey(record);
    }

}
