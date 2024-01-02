package com.example.order.controller;

import com.example.order.service.OrderService;
import com.example.order.vo.OrderConfirmVo;
import com.example.order.vo.OrderSubmitVo;
import com.example.order.vo.SubmitOrderResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ExecutionException;

@Controller
public class OrderWebController {

    @Autowired
    private OrderService orderService;

    /**
     * 跳转到订单确认页面
     * @param model
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/toTrade")
    public String toTrade(Model model) throws ExecutionException, InterruptedException {
        OrderConfirmVo confirmVo=orderService.confirmOrder();
        model.addAttribute("confirmOrderData",confirmVo);
        return "confirm";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(OrderSubmitVo submitVo,Model model){
        //创建订单
        SubmitOrderResponseVo responseVo=orderService.submitOrder(submitVo);
        if(responseVo.getCode()==0){
            //下单成功到支付选择页面
            model.addAttribute("submitOrderResp",responseVo);
            return "redirect:http://order.gulimall.com/payOrder.html?orderSn="+responseVo.getOrder().getOrderSn();
        }else {
            return "redirect:http://order.gulimall.com/toTrade";
        }

    }
}
