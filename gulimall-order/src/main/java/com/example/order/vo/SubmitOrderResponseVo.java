package com.example.order.vo;

import com.example.order.entity.Order;
import lombok.Data;

@Data
public class SubmitOrderResponseVo {
    private Order order;
    //错误状态码 0：成功 1：令牌错误 2：令牌过期 3：令牌不存在 4：用户不存在 5：商品库存不足 6：订单信息错误 7：订单创建失败 8：支付失败
    private Integer code;
}
