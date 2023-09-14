package com.rabbit.teste.appointmentservice.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MyMessageReceiverService {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
    }
}
