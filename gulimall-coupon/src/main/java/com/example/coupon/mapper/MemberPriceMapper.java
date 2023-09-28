package com.example.coupon.mapper;

import com.example.coupon.entity.MemberPrice;
import feign.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MemberPriceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberPrice record);

    int insertSelective(MemberPrice record);

    MemberPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberPrice record);

    int updateByPrimaryKey(MemberPrice record);

    void batchSave(@Param("list") List<MemberPrice> memberPriceList);
}