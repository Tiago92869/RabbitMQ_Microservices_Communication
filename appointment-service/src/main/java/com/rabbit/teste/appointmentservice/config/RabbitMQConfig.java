package com.rabbit.teste.appointmentservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue appointmentQueue() {
        return new Queue("delete-appointment-user");
    }

    @Bean
    public Queue helloQueue() {
        return new Queue("appointment-service-hello");
    }
}