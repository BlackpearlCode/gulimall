package com.example.member.service;

import com.example.member.entity.MemberLoginLog;
public interface MemberLoginLogService{


    int deleteByPrimaryKey(Long id);

    int insert(MemberLoginLog record);

    int insertSelective(MemberLoginLog record);

    MemberLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberLoginLog record);

    int updateByPrimaryKey(MemberLoginLog record);

}
