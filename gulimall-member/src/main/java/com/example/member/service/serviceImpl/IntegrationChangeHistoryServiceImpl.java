package com.example.member.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.member.entity.IntegrationChangeHistory;
import com.example.member.mapper.IntegrationChangeHistoryMapper;
import com.example.member.service.IntegrationChangeHistoryService;
@Service
public class IntegrationChangeHistoryServiceImpl implements IntegrationChangeHistoryService{

    @Resource
    private IntegrationChangeHistoryMapper integrationChangeHistoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return integrationChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IntegrationChangeHistory record) {
        return integrationChangeHistoryMapper.insert(record);
    }

    @Override
    public int insertSelective(IntegrationChangeHistory record) {
        return integrationChangeHistoryMapper.insertSelective(record);
    }

    @Override
    public IntegrationChangeHistory selectByPrimaryKey(Long id) {
        return integrationChangeHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IntegrationChangeHistory record) {
        return integrationChangeHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IntegrationChangeHistory record) {
        return integrationChangeHistoryMapper.updateByPrimaryKey(record);
    }

}
