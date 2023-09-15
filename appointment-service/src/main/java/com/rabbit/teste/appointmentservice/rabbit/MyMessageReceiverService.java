package com.rabbit.teste.appointmentservice.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MyMessageReceiverService {

    @RabbitListener(queues = "appointment-service")
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
    }
}
