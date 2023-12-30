package com.example.order.service.serviceImpl;

import com.example.order.entity.Order;
import com.example.order.entity.OrderReturnReason;
import com.example.order.feign.CartFeignService;
import com.example.order.feign.MemberFeignService;
import com.example.order.interceptor.LoginUserInterceptor;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import com.example.order.vo.MemberAddressVo;
import com.example.order.vo.MemberVo;
import com.example.order.vo.OrderConfirmVo;
import com.example.order.vo.OrderItemVo;
import com.gulimall.common.vo.TokenInfo;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

@RabbitListener(queues = {"hello-java-queue"})
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MemberFeignService memberFeignService;

    @Autowired
    private CartFeignService cartFeignService;

    @Autowired
    private ThreadPoolExecutor executor;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException {
        TokenInfo tokenInfo = LoginUserInterceptor.loginUser.get();
        if(tokenInfo==null){
            return null;
        }
        String memberId="";
        if(!StringUtils.isEmpty(tokenInfo.getUserId())){
            //如果用户是账号登录
            memberId=tokenInfo.getUserId();
        }else{
            //如果用户是第三方登录，
            memberId=tokenInfo.getSocialUid();
        }
        OrderConfirmVo confirmVo=new OrderConfirmVo();
        String finalMemberId = memberId;
        //获取之前的请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        CompletableFuture<MemberVo> memberFuture = CompletableFuture.supplyAsync(() -> {
            //每一个线程都共享之前的数据
            RequestContextHolder.setRequestAttributes(requestAttributes);
            //根据memberId查询用户信息
            MemberVo memberInfo = memberFeignService.findMemberId(finalMemberId);
            //查询用户积分
            Integer integration = memberInfo.getIntegration();
            confirmVo.setIntegration(integration);

           return memberInfo;
        }, executor);

        CompletableFuture<Void> addressFuture =memberFuture.thenAcceptAsync((res)->{
            //每一个线程都共享之前的数据
            RequestContextHolder.setRequestAttributes(requestAttributes);
            List<MemberAddressVo> address = memberFeignService.getAddress(res.getId());
            confirmVo.setAddress(address);

        });


        CompletableFuture<Void> orderFuture = CompletableFuture.runAsync(() -> {
            //每一个线程都共享之前的数据
            RequestContextHolder.setRequestAttributes(requestAttributes);
            //2.远程查询购物车所有选中的购物项
            List<OrderItemVo> currentUserCartItems = cartFeignService.getCurrentUserCartItems();
            confirmVo.setItems(currentUserCartItems);

        }, executor);

        CompletableFuture.allOf(memberFuture,addressFuture,orderFuture).get();




        //TODO 防重令牌
        return confirmVo;
    }

    @RabbitHandler
    public void receieveMessage(Message message, OrderReturnReason content, Channel channel) throws IOException {
        System.out.println("收到消息：" + content);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("deliveryTag--->"+deliveryTag);
        //手动签收
        channel.basicAck(deliveryTag,false);
        /**
         * 拒绝消息
         * deliveryTag：消息的唯一标识
         * multiple：是否批量拒绝
         * requeue：是否重新入队；true：重新入队，false：不重新入队
         */
        // channel.basicNack(deliveryTag,false,true);
    }

}
