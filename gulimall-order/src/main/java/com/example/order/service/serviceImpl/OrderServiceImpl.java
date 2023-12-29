package com.example.order.service.serviceImpl;

import com.example.order.entity.OrderReturnReason;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.mapper.OrderMapper;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;

import java.io.IOException;

@RabbitListener(queues = {"hello-java-queue"})
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

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
