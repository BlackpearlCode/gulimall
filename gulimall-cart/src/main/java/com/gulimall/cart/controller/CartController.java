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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
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
    public String cartListPage(Model model){
        //获取用户登录信息
        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();
        //获取购物车列表
        List<CartItem> cartItems=cartService.getAllCarts();
        model.addAttribute("cartList",cartItems);
        return "cartList";
    }

    /**
     * 添加商品到购物车
     * @return
     */
    @GetMapping("/addCartItem")
    public String addCartItem(@RequestParam("skuId") Long skuId, @RequestParam("num") Integer num, RedirectAttributes redirectAttributes) throws ExecutionException, InterruptedException {
        cartService.addCart(skuId,num);
        redirectAttributes.addAttribute("skuId",skuId);
        return "redirect:http://cart.onlineshopping.com/addToCartSuccess.html";
    }

    @GetMapping("/addToCartSuccess.html")
    public String addToCartSuccessPage(@RequestParam("skuId") Long skuId, Model model){
      //重定向到成功页面，再次查询购物车数据
        CartItem cartItem=cartService.getCartItem(skuId);
        model.addAttribute("cartItem",cartItem);
        return "success";
    }
}
