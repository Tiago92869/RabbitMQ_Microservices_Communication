package com.rabbit.teste.userservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "user-service";

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    public static String getQueueName(String id) {
        return QUEUE_NAME + "-" + id;
    }
}