package com.gulimall.cart.service.impl;

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
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

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
        String cartKey = getString();
        //查询购物车中是否有该商品，有则数量累加，没有则添加新商品
        String data = redisFeignService.getHash(cartKey, skuId.toString());
        if(!StringUtils.isEmpty(data)){
            //购物车中有该商品，数量累加
            Gson gson=new Gson();
            CartItem cartItem=gson.fromJson(data, CartItem.class);
            cartItem.setCount(cartItem.getCount()+num);
            cartItem.setTotalPrice(cartItem.getTotalPrice());
            redisFeignService.saveHash(cartKey, skuId.toString(),gson.toJson(cartItem));
            return cartItem;
        }

        //添加新商品到购物车
        CartItem cartItem = new CartItem();
        //异步：远程查询sku信息
        Gson gson = new Gson();
        CompletableFuture<Void> getSkuInfoTask = CompletableFuture.runAsync(() -> {
            Result info = productFeignService.info(skuId);

            Object sku = info.get("sku");
            PmsSkuInfo skuInfoVo = gson.fromJson(gson.toJson(sku), PmsSkuInfo.class);

            cartItem.setCheck(true);
            cartItem.setCount(num);
            cartItem.setImage(skuInfoVo.getSkuDefaultImg());
            cartItem.setSkuId(skuId);
            cartItem.setTitle(skuInfoVo.getSkuTitle());
            cartItem.setPrice(skuInfoVo.getPrice());
            cartItem.setTotalPrice(cartItem.getTotalPrice());
        },executor);
        //异步：查询sku的组合信息
        CompletableFuture<Void> getSkuSaleAttrValues = CompletableFuture.runAsync(() -> {
            List<String> skuSaleAtttrValues = productFeignService.getSkuSaleAtttrValues(skuId);
            cartItem.setSkuAttr(skuSaleAtttrValues);
        }, executor);
        CompletableFuture.allOf(getSkuInfoTask,getSkuSaleAttrValues).get();
        redisFeignService.saveHash(cartKey, String.valueOf(skuId),gson.toJson(cartItem));

        return cartItem;
    }

    //获取购物车key
    private String getString() {
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
        return cartKey;
    }

    @Override
    public CartItem getCartItem(Long skuId) {
        String cartKey = getString();
        String data = redisFeignService.getHash(cartKey, skuId.toString());
        Gson gson=new Gson();
        CartItem cartItem=gson.fromJson(data, CartItem.class);
        return cartItem;
    }

    @Override
    public List<CartItem> getAllCarts() {
        String key = getString();
        Map<String, String> cartItemMap=redisFeignService.getAllHash(key);
        Collection<String> values = cartItemMap.values();
        List<CartItem> cartitems = values.stream().map(i -> {
            Gson gson = new Gson();
            CartItem cartItem = gson.fromJson( i, CartItem.class);
            return cartItem;
        }).collect(Collectors.toList());
        return cartitems;
    }
}
