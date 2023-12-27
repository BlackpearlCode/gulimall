package com.gulimall.cart.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.gulimall.cart.feign.ProductFeignService;
import com.gulimall.cart.feign.RedisFeignService;
import com.gulimall.cart.interceptor.CartInterceptor;
import com.gulimall.cart.service.CartService;
import com.gulimall.cart.vo.CartItem;
import com.gulimall.cart.vo.PmsSkuInfo;
import com.gulimall.cart.vo.UserInfoTo;
import com.gulimall.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductFeignService productFeignService;
    @Autowired
    private RedisFeignService redisFeignService;

    @Autowired
    private ThreadPoolExecutor executor;

    private final String CART_PREFIX = "gulimall:cart:";
    @Override
    public CartItem addCart(Long skuId, Integer num) throws ExecutionException, InterruptedException {
        //获取当前用户信息
        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
        String cartKey="";
        if (userInfoTo.getUserId()!= null) {
            //登录状态下，添加购物车
            cartKey=CART_PREFIX+userInfoTo.getUserId();
        }else {
            //未登录状态下，添加购物车
            cartKey=CART_PREFIX+userInfoTo.getUserKey();
        }
        CartItem cartItem = new CartItem();
        //异步：远程查询sku信息
        CompletableFuture<Void> getSkuInfoTask = CompletableFuture.runAsync(() -> {
            Result info = productFeignService.info(skuId);
            Gson gson = new Gson();
            Object sku = info.get("sku");
            PmsSkuInfo skuInfoVo = gson.fromJson(gson.toJson(sku), PmsSkuInfo.class);

            cartItem.setCheck(true);
            cartItem.setCount(num);
            cartItem.setImage(skuInfoVo.getSkuDefaultImg());
            cartItem.setSkuId(skuId);
            cartItem.setTitle(skuInfoVo.getSkuTitle());
            cartItem.setPrice(skuInfoVo.getPrice());
        },executor);
        //异步：查询sku的组合信息
        CompletableFuture<Void> getSkuSaleAttrValues = CompletableFuture.runAsync(() -> {
            List<String> skuSaleAtttrValues = productFeignService.getSkuSaleAtttrValues(skuId);
            cartItem.setSkuAttr(skuSaleAtttrValues);
        }, executor);
        CompletableFuture.allOf(getSkuInfoTask,getSkuSaleAttrValues).get();
        redisFeignService.saveHash(cartKey, String.valueOf(skuId),cartItem);

        return cartItem;
    }
}
