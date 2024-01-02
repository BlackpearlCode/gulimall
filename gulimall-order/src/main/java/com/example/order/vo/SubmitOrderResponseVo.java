package com.example.order.vo;

import com.example.order.entity.Order;
import lombok.Data;

@Data
public class SubmitOrderResponseVo {
    private Order order;
    //错误状态码 0：成功
    private Integer code;
}
