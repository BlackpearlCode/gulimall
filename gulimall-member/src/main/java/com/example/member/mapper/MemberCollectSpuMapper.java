package com.example.member.mapper;

import com.example.member.entity.MemberCollectSpu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberCollectSpuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberCollectSpu record);

    int insertSelective(MemberCollectSpu record);

    MemberCollectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberCollectSpu record);

    int updateByPrimaryKey(MemberCollectSpu record);
}