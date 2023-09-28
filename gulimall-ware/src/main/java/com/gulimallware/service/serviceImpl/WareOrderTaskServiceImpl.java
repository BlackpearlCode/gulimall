package com.gulimallware.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gulimallware.mapper.WareOrderTaskMapper;
import com.gulimallware.entity.WareOrderTask;
import com.gulimallware.service.WareOrderTaskService;
@Service
public class WareOrderTaskServiceImpl implements WareOrderTaskService{

    @Resource
    private WareOrderTaskMapper wareOrderTaskMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return wareOrderTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WareOrderTask record) {
        return wareOrderTaskMapper.insert(record);
    }

    @Override
    public int insertSelective(WareOrderTask record) {
        return wareOrderTaskMapper.insertSelective(record);
    }

    @Override
    public WareOrderTask selectByPrimaryKey(Long id) {
        return wareOrderTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WareOrderTask record) {
        return wareOrderTaskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WareOrderTask record) {
        return wareOrderTaskMapper.updateByPrimaryKey(record);
    }

}
