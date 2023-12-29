package com.example.order;

import com.example.order.entity.OrderReturnReason;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class GulimallOrderApplicationTests {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 1.创建Exchange、Queue、Binding
     *  使用AmqpAdmin进行创建
     * 2.如何收发消息
     */
    @Test
    void contextLoads() {
        //创建交换机
        DirectExchange directExchange = new DirectExchange("hello-java-exchange",true,true,null);
        amqpAdmin.declareExchange(directExchange);
        log.info("Exchange创建成功");
    }

    @Test
    void createQueue(){
        /**
         * String name, boolean durable, boolean exclusive, boolean autoDelete,
         * 			            @Nullable Map<String, Object> arguments
         */
        Queue queue = new Queue("hello-java-queue",true,false,true,null);
        amqpAdmin.declareQueue(queue);
        log.info("Queue创建成功");
    }

    @Test
    void createBinding(){
        /**
         * @Nullable Queue lazyQueue, @Nullable String destination, DestinationType destinationType,
         * 			String exchange, @Nullable String routingKey, @Nullable Map<String, Object> arguments
         */
        //将exchange指定的交换机和destination目的地进行绑定，使用routingkey作为知道的的路由键
        Binding binding = new Binding("hello-java-queue", Binding.DestinationType.QUEUE,"hello-java-exchange","hello.java",null);
        amqpAdmin.declareBinding(binding);
        log.info("Binding创建成功");
    }

    @Test
    void senMessageTest(){
        OrderReturnReason orderReturnReason = new OrderReturnReason();
        orderReturnReason.setId(1L);
        orderReturnReason.setCreateTime(new Date());
        orderReturnReason.setName("哈哈哈");
        //1.发送消息
        rabbitTemplate.convertAndSend("hello-java-exchange","hello.java",orderReturnReason);
        log.info("消息发送成功{}",orderReturnReason);
    }







}
