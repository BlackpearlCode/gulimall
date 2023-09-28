package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.entity.CouponSpuRelation;
import com.example.coupon.mapper.CouponSpuRelationMapper;
import com.example.coupon.service.CouponSpuRelationService;
@Service
public class CouponSpuRelationServiceImpl implements CouponSpuRelationService{

    @Resource
    private CouponSpuRelationMapper couponSpuRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return couponSpuRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CouponSpuRelation record) {
        return couponSpuRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(CouponSpuRelation record) {
        return couponSpuRelationMapper.insertSelective(record);
    }

    @Override
    public CouponSpuRelation selectByPrimaryKey(Long id) {
        return couponSpuRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CouponSpuRelation record) {
        return couponSpuRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CouponSpuRelation record) {
        return couponSpuRelationMapper.updateByPrimaryKey(record);
    }

}
