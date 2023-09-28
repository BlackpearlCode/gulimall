package com.example.coupon.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 优惠券分类关联
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponSpuCategoryRelation implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 优惠券id
    */
    private Long couponId;

    /**
    * 产品分类id
    */
    private Long categoryId;

    /**
    * 产品分类名称
    */
    private String categoryName;

    private static final long serialVersionUID = 1L;
}