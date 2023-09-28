package com.example.member.service;

import com.example.member.entity.MemberStatisticsInfo;
public interface MemberStatisticsInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(MemberStatisticsInfo record);

    int insertSelective(MemberStatisticsInfo record);

    MemberStatisticsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberStatisticsInfo record);

    int updateByPrimaryKey(MemberStatisticsInfo record);

}
