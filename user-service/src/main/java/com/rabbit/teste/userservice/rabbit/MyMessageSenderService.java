package com.rabbit.teste.userservice.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyMessageSenderService {

    private final RabbitTemplate rabbitTemplate;

    public MyMessageSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("my-queue", message);
    }
}
