package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.entity.CouponHistory;
import com.example.coupon.mapper.CouponHistoryMapper;
import com.example.coupon.service.CouponHistoryService;
@Service
public class CouponHistoryServiceImpl implements CouponHistoryService{

    @Resource
    private CouponHistoryMapper couponHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return couponHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CouponHistory record) {
        return couponHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(CouponHistory record) {
        return couponHistoryMapper.insertSelective(record);
    }

    @Override
    public CouponHistory selectByPrimaryKey(Long id) {
        return couponHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CouponHistory record) {
        return couponHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CouponHistory record) {
        return couponHistoryMapper.updateByPrimaryKey(record);
    }

}
