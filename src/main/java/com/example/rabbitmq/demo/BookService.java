package com.example.rabbitmq.demo;

import com.example.rabbitmq.demo.model.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "testqueue")
    public void receive(Book book){
        System.out.println("收到消息 "+book);
    }

    //消息头
//    @RabbitListener(queues = "testqueue")
//    public void receive(Message message){
//        System.out.println("消息");
//        System.out.println(message.getBody());
//        System.out.println(message.getMessageProperties());
//    }

}
