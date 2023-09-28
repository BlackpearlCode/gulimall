package com.gulimallware.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gulimallware.entity.WareOrderTaskDetail;
import com.gulimallware.mapper.WareOrderTaskDetailMapper;
import com.gulimallware.service.WareOrderTaskDetailService;
@Service
public class WareOrderTaskDetailServiceImpl implements WareOrderTaskDetailService{

    @Resource
    private WareOrderTaskDetailMapper wareOrderTaskDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return wareOrderTaskDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WareOrderTaskDetail record) {
        return wareOrderTaskDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(WareOrderTaskDetail record) {
        return wareOrderTaskDetailMapper.insertSelective(record);
    }

    @Override
    public WareOrderTaskDetail selectByPrimaryKey(Long id) {
        return wareOrderTaskDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WareOrderTaskDetail record) {
        return wareOrderTaskDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WareOrderTaskDetail record) {
        return wareOrderTaskDetailMapper.updateByPrimaryKey(record);
    }

}
