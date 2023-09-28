package com.example.member.service;

import com.example.member.entity.MemberCollectSpu;
public interface MemberCollectSpuService{


    int deleteByPrimaryKey(Long id);

    int insert(MemberCollectSpu record);

    int insertSelective(MemberCollectSpu record);

    MemberCollectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCollectSpu record);

    int updateByPrimaryKey(MemberCollectSpu record);

}
