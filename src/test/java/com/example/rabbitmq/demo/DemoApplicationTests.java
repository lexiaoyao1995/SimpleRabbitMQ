package com.example.rabbitmq.demo;

import com.example.rabbitmq.demo.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    //创建交换机，队列和路由键
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {

        Book book = new Book(12,"asd");

        rabbitTemplate.convertAndSend("testexchange","testqueue",book);

    }

    @Test
    public void recevice(){
        Object o = rabbitTemplate.receiveAndConvert("testqueue");
        System.out.println(o.getClass());
        System.out.println(o);

    }

    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("javaExchange"));
    }

    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("javaQueue",true));
    }

    //创建绑定规则
    @Test
    public void bind(){
        amqpAdmin.declareBinding(new Binding("javaQueue",Binding.DestinationType.QUEUE,"javaExchange","javaQueue",null));
    }

}
