package com.example.coupon.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.coupon.entity.HomeSubject;
import com.example.coupon.mapper.HomeSubjectMapper;
import com.example.coupon.service.HomeSubjectService;
@Service
public class HomeSubjectServiceImpl implements HomeSubjectService{

    @Resource
    private HomeSubjectMapper homeSubjectMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return homeSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HomeSubject record) {
        return homeSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(HomeSubject record) {
        return homeSubjectMapper.insertSelective(record);
    }

    @Override
    public HomeSubject selectByPrimaryKey(Long id) {
        return homeSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HomeSubject record) {
        return homeSubjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HomeSubject record) {
        return homeSubjectMapper.updateByPrimaryKey(record);
    }

}
