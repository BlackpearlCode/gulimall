package com.example.coupon.mapper;

import com.example.coupon.entity.HomeSubjectSpu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeSubjectSpuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HomeSubjectSpu record);

    int insertSelective(HomeSubjectSpu record);

    HomeSubjectSpu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HomeSubjectSpu record);

    int updateByPrimaryKey(HomeSubjectSpu record);
}