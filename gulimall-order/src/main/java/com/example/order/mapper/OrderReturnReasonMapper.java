package com.example.order.mapper;

import com.example.order.entity.OrderReturnReason;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderReturnReasonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderReturnReason record);

    int insertSelective(OrderReturnReason record);

    OrderReturnReason selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderReturnReason record);

    int updateByPrimaryKey(OrderReturnReason record);
}