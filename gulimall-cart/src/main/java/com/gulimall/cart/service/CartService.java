package com.gulimall.cart.service;

import com.gulimall.cart.vo.CartItem;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CartService {
    //添加商品到购物车
    CartItem addCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    //获取购物车中某个购物项
    CartItem getCartItem(Long skuId);

    //获取当前用户购物车所有购物项
    List<CartItem> getAllCarts();
}
