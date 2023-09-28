package com.example.coupon.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 优惠券与产品关联
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponSpuRelation implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 优惠券id
    */
    private Long couponId;

    /**
    * spu_id
    */
    private Long spuId;

    /**
    * spu_name
    */
    private String spuName;

    private static final long serialVersionUID = 1L;
}