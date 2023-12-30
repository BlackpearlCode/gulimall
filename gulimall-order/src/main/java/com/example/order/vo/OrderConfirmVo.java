package com.example.order.vo;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单确认页需要的数据
 */
@Data
public class OrderConfirmVo {
    //收获地址
    private List<MemberAddressVo> address;

    //所有选中的购物项
    private List<OrderItemVo> items;

    //发票记录

    //优惠卷信息
    private Integer integration;

    //防重令牌
    private String orderToken;



    //计算订单总额
    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal("0");
        if(CollectionUtils.isEmpty(items)){
            for(OrderItemVo item:items){
                BigDecimal multiply = item.getPrice().multiply(new BigDecimal(item.getCount().toString()));
                sum=sum.add(multiply);
            }
        }
        return sum;
    }

    //计算应付总额
    public BigDecimal getPayPrice() {

        return getTotal();
    }
}
