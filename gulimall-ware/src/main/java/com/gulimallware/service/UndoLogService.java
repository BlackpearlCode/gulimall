package com.gulimallware.service;

import com.gulimallware.entity.UndoLog;
public interface UndoLogService{


    int deleteByPrimaryKey(Long id);

    int insert(UndoLog record);

    int insertSelective(UndoLog record);

    UndoLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UndoLog record);

    int updateByPrimaryKey(UndoLog record);

}
