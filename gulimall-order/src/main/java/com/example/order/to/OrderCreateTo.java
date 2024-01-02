package com.example.order.to;

import com.example.order.entity.Order;
import com.example.order.entity.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderCreateTo {
    // 订单信息
    private Order order;
    // 所有订单项
    private List<OrderItem> items;
    // 应付总额
    private BigDecimal payPrice;
    //运费
    private BigDecimal fare;
}
