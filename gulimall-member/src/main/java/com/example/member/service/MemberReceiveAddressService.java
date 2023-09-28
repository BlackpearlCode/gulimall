package com.example.member.service;

import com.example.member.entity.MemberReceiveAddress;
public interface MemberReceiveAddressService{


    int deleteByPrimaryKey(Long id);

    int insert(MemberReceiveAddress record);

    int insertSelective(MemberReceiveAddress record);

    MemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberReceiveAddress record);

    int updateByPrimaryKey(MemberReceiveAddress record);

}
