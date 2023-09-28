package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.mapper.CouponMapper;
import com.example.coupon.entity.Coupon;
import com.example.coupon.service.CouponService;
@Service
public class CouponServiceImpl implements CouponService{

    @Resource
    private CouponMapper couponMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return couponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Coupon record) {
        return couponMapper.insert(record);
    }

    @Override
    public int insertSelective(Coupon record) {
        return couponMapper.insertSelective(record);
    }

    @Override
    public Coupon selectByPrimaryKey(Long id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Coupon record) {
        return couponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Coupon record) {
        return couponMapper.updateByPrimaryKey(record);
    }

}
