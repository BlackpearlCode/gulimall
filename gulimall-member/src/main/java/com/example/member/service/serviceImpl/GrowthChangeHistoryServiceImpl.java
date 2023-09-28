package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.GrowthChangeHistory;
import com.example.member.mapper.GrowthChangeHistoryMapper;
import com.example.member.service.GrowthChangeHistoryService;
@Service
public class GrowthChangeHistoryServiceImpl implements GrowthChangeHistoryService{

    @Resource
    private GrowthChangeHistoryMapper growthChangeHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return growthChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GrowthChangeHistory record) {
        return growthChangeHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(GrowthChangeHistory record) {
        return growthChangeHistoryMapper.insertSelective(record);
    }

    @Override
    public GrowthChangeHistory selectByPrimaryKey(Long id) {
        return growthChangeHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GrowthChangeHistory record) {
        return growthChangeHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GrowthChangeHistory record) {
        return growthChangeHistoryMapper.updateByPrimaryKey(record);
    }

}
