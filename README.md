### springboot and RabbitMQ

只是一些简单的操作

@rabbitlistener

```
@Autowired
private RabbitTemplate rabbitTemplate;


//创建交换机，队列和路由键
@Autowired
private AmqpAdmin amqpAdmin;
```

json化