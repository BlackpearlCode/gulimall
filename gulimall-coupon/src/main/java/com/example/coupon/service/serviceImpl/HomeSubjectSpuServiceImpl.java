package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.mapper.HomeSubjectSpuMapper;
import com.example.coupon.entity.HomeSubjectSpu;
import com.example.coupon.service.HomeSubjectSpuService;
@Service
public class HomeSubjectSpuServiceImpl implements HomeSubjectSpuService{

    @Resource
    private HomeSubjectSpuMapper homeSubjectSpuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return homeSubjectSpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HomeSubjectSpu record) {
        return homeSubjectSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(HomeSubjectSpu record) {
        return homeSubjectSpuMapper.insertSelective(record);
    }

    @Override
    public HomeSubjectSpu selectByPrimaryKey(Long id) {
        return homeSubjectSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HomeSubjectSpu record) {
        return homeSubjectSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HomeSubjectSpu record) {
        return homeSubjectSpuMapper.updateByPrimaryKey(record);
    }

}
