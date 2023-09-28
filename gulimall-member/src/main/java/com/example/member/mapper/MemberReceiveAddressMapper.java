package com.example.member.mapper;

import com.example.member.entity.MemberReceiveAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberReceiveAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberReceiveAddress record);

    int insertSelective(MemberReceiveAddress record);

    MemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberReceiveAddress record);

    int updateByPrimaryKey(MemberReceiveAddress record);
}