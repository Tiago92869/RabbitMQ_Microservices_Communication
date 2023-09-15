package com.rabbit.teste.userservice.config;

import org.springframework.amqp.core.*;
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


    @Bean
    public DirectExchange updateExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("appointment-service-hello");
    }

    @Bean
    public Binding bindingUpdate() {
        return BindingBuilder.bind(myQueue2()).to(updateExchange()).with("appointment-hello");
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

    @Bean
    public Queue queue3() {
        return new Queue("queue3");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("app.*.error");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("app.#");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(topicExchange()).with("app.server.*");
    }

}