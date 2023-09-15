package com.rabbit.teste.userservice.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = "user-service")
    public void receiveMessage(@Payload Message message) {

        System.out.println("Received message: " + message);
    }
}
