package com.gulimallware.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gulimallware.mapper.UndoLogMapper;
import com.gulimallware.entity.UndoLog;
import com.gulimallware.service.UndoLogService;
@Service
public class UndoLogServiceImpl implements UndoLogService{

    @Resource
    private UndoLogMapper undoLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return undoLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UndoLog record) {
        return undoLogMapper.insert(record);
    }

    @Override
    public int insertSelective(UndoLog record) {
        return undoLogMapper.insertSelective(record);
    }

    @Override
    public UndoLog selectByPrimaryKey(Long id) {
        return undoLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UndoLog record) {
        return undoLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UndoLog record) {
        return undoLogMapper.updateByPrimaryKey(record);
    }

}
