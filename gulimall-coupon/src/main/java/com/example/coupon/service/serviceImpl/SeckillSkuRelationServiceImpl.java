package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.mapper.SeckillSkuRelationMapper;
import com.example.coupon.entity.SeckillSkuRelation;
import com.example.coupon.service.SeckillSkuRelationService;
@Service
public class SeckillSkuRelationServiceImpl implements SeckillSkuRelationService{

    @Resource
    private SeckillSkuRelationMapper seckillSkuRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return seckillSkuRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SeckillSkuRelation record) {
        return seckillSkuRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(SeckillSkuRelation record) {
        return seckillSkuRelationMapper.insertSelective(record);
    }

    @Override
    public SeckillSkuRelation selectByPrimaryKey(Long id) {
        return seckillSkuRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SeckillSkuRelation record) {
        return seckillSkuRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SeckillSkuRelation record) {
        return seckillSkuRelationMapper.updateByPrimaryKey(record);
    }

}
