package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.entity.HomeAdv;
import com.example.coupon.mapper.HomeAdvMapper;
import com.example.coupon.service.HomeAdvService;
@Service
public class HomeAdvServiceImpl implements HomeAdvService{

    @Resource
    private HomeAdvMapper homeAdvMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return homeAdvMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HomeAdv record) {
        return homeAdvMapper.insert(record);
    }

    @Override
    public int insertSelective(HomeAdv record) {
        return homeAdvMapper.insertSelective(record);
    }

    @Override
    public HomeAdv selectByPrimaryKey(Long id) {
        return homeAdvMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HomeAdv record) {
        return homeAdvMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HomeAdv record) {
        return homeAdvMapper.updateByPrimaryKey(record);
    }

}
