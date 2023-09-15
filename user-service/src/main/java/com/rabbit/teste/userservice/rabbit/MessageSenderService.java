package com.rabbit.teste.userservice.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;

    public MessageSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void deleteUser(String message) {
        MessageProperties properties = new MessageProperties();
        properties.setHeader("MessageType", "delete-user");
        Message msg = new Message(message.getBytes(), properties);
        rabbitTemplate.send("appointment-service", msg);
    }
}
