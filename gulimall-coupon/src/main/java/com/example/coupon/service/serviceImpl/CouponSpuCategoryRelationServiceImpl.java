package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.mapper.CouponSpuCategoryRelationMapper;
import com.example.coupon.entity.CouponSpuCategoryRelation;
import com.example.coupon.service.CouponSpuCategoryRelationService;
@Service
public class CouponSpuCategoryRelationServiceImpl implements CouponSpuCategoryRelationService{

    @Resource
    private CouponSpuCategoryRelationMapper couponSpuCategoryRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return couponSpuCategoryRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CouponSpuCategoryRelation record) {
        return couponSpuCategoryRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(CouponSpuCategoryRelation record) {
        return couponSpuCategoryRelationMapper.insertSelective(record);
    }

    @Override
    public CouponSpuCategoryRelation selectByPrimaryKey(Long id) {
        return couponSpuCategoryRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CouponSpuCategoryRelation record) {
        return couponSpuCategoryRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CouponSpuCategoryRelation record) {
        return couponSpuCategoryRelationMapper.updateByPrimaryKey(record);
    }

}
