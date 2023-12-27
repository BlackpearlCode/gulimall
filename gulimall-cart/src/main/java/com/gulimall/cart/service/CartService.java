package com.gulimall.cart.service;

import com.gulimall.cart.vo.CartItem;

import java.util.concurrent.ExecutionException;

public interface CartService {
    CartItem addCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;
}
