package com.rabbit.teste.appointmentservice.rabbit;

import com.rabbit.teste.appointmentservice.service.AppointmentService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class ConsumerService {

    private final AppointmentService appointmentService;

    @Autowired
    public ConsumerService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RabbitListener(queues = "delete-appointment-user")
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

    @RabbitListener(queues = "appointment-service-hello")
    public void test(Message message) throws UnsupportedEncodingException {

        String userId = new String(message.getBody(), "UTF-8");

        System.out.println("Received message: Hello " + userId);

    }



    @RabbitListener(queues = "queue1")
    public void processQueue1(String mensagem) {
        System.out.println("Recebida mensagem na fila 1: " + mensagem);
    }

    @RabbitListener(queues = "queue2")
    public void processQueue2(String mensagem) {
        System.out.println("Recebida mensagem na fila 2: " + mensagem);
    }

    @RabbitListener(queues = "queue3")
    public void processQueue3(String mensagem) {
        System.out.println("Recebida mensagem na fila 3: " + mensagem);
    }
}
