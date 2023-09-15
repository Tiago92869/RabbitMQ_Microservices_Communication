package com.rabbit.teste.userservice.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void deleteUser(String userId) {
        MessageProperties properties = new MessageProperties();
        properties.setHeader("MessageType", "delete-user");
        Message msg = new Message(userId.getBytes(), properties);
        rabbitTemplate.send("appointment-service", msg);
    }

    public void hello(String userId) {
        Message msg = new Message(userId.getBytes());
        rabbitTemplate.send("directExchange", "appointment-hello", msg);
    }

    public void topicExchange(){

        rabbitTemplate.convertAndSend("topicExchange", "app.user.error", "Erro de usuário");
        rabbitTemplate.convertAndSend("topicExchange", "app.product.error", "Erro de produto");
        rabbitTemplate.convertAndSend("topicExchange", "app.order.created", "Pedido criado");
        rabbitTemplate.convertAndSend("topicExchange", "app.server.status", "Status do servidor");
    }
}
