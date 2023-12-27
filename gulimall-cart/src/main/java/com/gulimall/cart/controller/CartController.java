package com.gulimall.cart.controller;

import com.gulimall.cart.interceptor.CartInterceptor;
import com.gulimall.cart.service.CartService;
import com.gulimall.cart.vo.CartItem;
import com.gulimall.cart.vo.UserInfoTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutionException;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     *
     * @return
     */
    @GetMapping("/cart.html")
    public String cartListPage(){
        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
        System.out.println(userInfoTo);
        return "cartList";
    }

    /**
     * 添加商品到购物车
     * @return
     */
    @GetMapping("/addCartItem")
    public String addCartItem(@RequestParam("skuId") Long skuId,@RequestParam("num") Integer num, Model model) throws ExecutionException, InterruptedException {
        CartItem cartItem=cartService.addCart(skuId,num);
        model.addAttribute("cartItem",cartItem);
        return "success";
    }
}
