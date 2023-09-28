package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.entity.SeckillSkuNotice;
import com.example.coupon.mapper.SeckillSkuNoticeMapper;
import com.example.coupon.service.SeckillSkuNoticeService;
@Service
public class SeckillSkuNoticeServiceImpl implements SeckillSkuNoticeService{

    @Resource
    private SeckillSkuNoticeMapper seckillSkuNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return seckillSkuNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SeckillSkuNotice record) {
        return seckillSkuNoticeMapper.insert(record);
    }

    @Override
    public int insertSelective(SeckillSkuNotice record) {
        return seckillSkuNoticeMapper.insertSelective(record);
    }

    @Override
    public SeckillSkuNotice selectByPrimaryKey(Long id) {
        return seckillSkuNoticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SeckillSkuNotice record) {
        return seckillSkuNoticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SeckillSkuNotice record) {
        return seckillSkuNoticeMapper.updateByPrimaryKey(record);
    }

}
