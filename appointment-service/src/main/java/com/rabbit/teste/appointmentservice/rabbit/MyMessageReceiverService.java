package com.rabbit.teste.appointmentservice.rabbit;

import com.rabbit.teste.appointmentservice.service.AppointmentService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MyMessageReceiverService {

    private final AppointmentService appointmentService;

    @Autowired
    public MyMessageReceiverService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RabbitListener(queues = "appointment-service")
    public void receiveMessage(Message message) throws UnsupportedEncodingException {

        String messageType = (String) message.getMessageProperties().getHeaders().get("MessageType");

        if ("delete-user".equals(messageType)) {

            System.out.println("Receive message to delete appointments with specific userId");

            String userId = new String(message.getBody(), "UTF-8");
            this.appointmentService.deleteUsers(userId);

        }else {

            System.out.println("Received message: " + message);
        }
    }
}
